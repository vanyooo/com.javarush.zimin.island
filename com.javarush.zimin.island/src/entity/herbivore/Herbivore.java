package entity.herbivore;

import entity.Animal;
import entity.Entity;
import entity.Plant;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Herbivore extends Animal {
    @Override
    public void eat(ConcurrentLinkedQueue<Entity> queueEntity) {
//        System.out.println("Пробует есть " + this.getClass().getSimpleName());
        if (actualSatiety >= maxSatiety){
            actualSatiety = maxSatiety;
//            System.out.println("Я ссыт ");
            return;
        }
        List<Plant> listEat = queueEntity.stream().filter(cell -> cell instanceof Plant).map(cell -> (Plant) cell)
                .toList();
        if (listEat.isEmpty()) {
//            System.out.println("Больше нет доступной еды.");
            return;
        }
        for (Plant plant : listEat) {
//            System.out.println("Съели " + plant.getClass().getSimpleName());
            int weightPlant = Plant.weight;
            if (weightPlant > maxSatiety){
                actualSatiety = maxSatiety;
                queueEntity.remove(plant);
                Plant.count--;
            } else {
                actualSatiety = actualSatiety + weightPlant + (maxSatiety * 0.4);
                queueEntity.remove(plant);
                Plant.count--;
                eat(queueEntity);
                return;
            }
        }
    }
}
