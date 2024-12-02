package entity.herbivore;

import entity.Animal;
import entity.Location.Cell;
import entity.Plant;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Herbivore extends Animal {
    Lock lock = new ReentrantLock();

    @Override
    public void eat(Cell cell) {
        lock.lock();
        try {
//            System.out.println("Пробует есть " + this.getClass().getSimpleName());
            if (actualSatiety >= maxSatiety) {
                actualSatiety = maxSatiety;
//                System.out.println("Я ссыт ");
                return;
            }
            CopyOnWriteArrayList<Plant> listPlant = cell.listPlant;
//        List<Plant> listEat = queueEntity.stream().filter(cell -> cell instanceof Plant).map(cell -> (Plant) cell)
//                .toList();
            if (listPlant.isEmpty()) {
//                System.out.println("Больше нет доступной еды.");
                return;
            }
            for (Plant plant : listPlant) {
//                System.out.println("Съели " + plant.getClass().getSimpleName());
                int weightPlant = Plant.weight;
//                System.out.println("Вес травы: " + weightPlant);
                if (weightPlant > maxSatiety) {
                    actualSatiety = maxSatiety;
//                    System.out.println(1 + "||" + actualSatiety);
                    cell.listPlant.remove(plant);
                } else {
                    actualSatiety = actualSatiety + weightPlant + (maxSatiety * 0.3);
//                    System.out.println(2 + "||" + actualSatiety);
                    cell.listPlant.remove(plant);
                }
                return;
            }
        }finally {
            lock.unlock();
        }
    }
}
