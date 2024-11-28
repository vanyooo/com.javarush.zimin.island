package entity.predator;

import entity.Animal;
import entity.Entity;
import entity.Settings;
import entity.herbivore.Herbivore;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

public abstract class Predator extends Animal {

    @Override
    public void eat(ConcurrentLinkedQueue<Entity> queueEntity) {
//        System.out.println("Пробует есть " + this.getClass().getSimpleName());
        if (actualSatiety >= maxSatiety) {
            actualSatiety = maxSatiety;
//            System.out.println("Я ссыт ");
            return;
        }
        List<Animal> listEat = new ArrayList<>(queueEntity.stream().filter(cell -> cell instanceof Animal).map(cell -> (Animal) cell)
                .toList());
        if (listEat.isEmpty()) {
//            System.out.println("Больше нет доступной еды.");
            return;
        }
        Collections.shuffle(listEat);
        for (Animal animal : listEat) {
//            System.out.println("Съели " + animal.getClass().getSimpleName());
            try {
                Integer probability = this.probabilityEaten.get(animal.getClass().getSimpleName());
                int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
//                System.out.println(probability + " - " + randomNum);
                if (probability >= randomNum) {
                    Double weightFood = Settings.weightOfAllEdibleAnimals.get(animal.getClass().getSimpleName());
                    if (weightFood > maxSatiety) {
                        actualSatiety = maxSatiety;
//                    System.out.println(animal.getClass().getSimpleName() + " die");
                        queueEntity.remove(animal);
                    } else {
                        actualSatiety += weightFood;
                        queueEntity.remove(animal);
//                    System.out.println(animal.getClass().getSimpleName() + " die");
//                    eat(cellList);
                    }
                }
                return;
            } catch (NullPointerException nullPint) {
//                System.out.println("Выпал 0");
                eat(queueEntity);
                return;
            }
        }
    }
}
