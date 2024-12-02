package entity.predator;

import entity.Animal;
import entity.Location.Cell;
import entity.Settings;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Predator extends Animal {

    Lock lock = new ReentrantLock();

    @Override
    public void eat(Cell cell) {
        lock.lock();
        try {
//            System.out.println("Method eat");
//            System.out.println("Пробует есть " + this.getClass().getSimpleName());
            if (actualSatiety >= maxSatiety) {
                actualSatiety = maxSatiety;
//                System.out.println("Я ссыт ");
                return;
            }
//        List<Animal> listEat = new ArrayList<>(cell.queueEntity.stream().filter(a -> a instanceof Animal).map(a -> (Animal) a)
//                .toList());
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            if (listAnimal.isEmpty()) {
//                System.out.println("Больше нет доступной еды.");
                return;
            }
            List<Animal> listFilter = listAnimal.stream().filter(animal -> this.probabilityEaten.getOrDefault
                            (animal.getClass().getSimpleName(), 0) > 0).sorted((a1, a2) -> Integer.compare(
                            this.probabilityEaten.getOrDefault(a2.getClass().getSimpleName(), 0),
                            this.probabilityEaten.getOrDefault(a1.getClass().getSimpleName(), 0)
                    ))
                    .toList();
            for (Animal animal : listFilter) {
                try {
                    Integer probability = this.probabilityEaten.get(animal.getClass().getSimpleName());
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
//                    System.out.println(probability + " - " + randomNum);
                    if (probability >= randomNum) {
//                        System.out.println("Съели " + animal.getClass().getSimpleName());
                        Double weightFood = Settings.weightOfAllEdibleAnimals.get(animal.getClass().getSimpleName());
                        if (weightFood > maxSatiety) {
                            actualSatiety = maxSatiety;
//                            System.out.println(animal.getClass().getSimpleName() + " die");
                        } else {
                            actualSatiety += weightFood;
//                            System.out.println(animal.getClass().getSimpleName() + " die");
                        }
                        cell.listAnimal.remove(animal);
                    }
                    return;
                } catch (NullPointerException nullPint) {
//                    System.out.println("Выпал 0");
//                    eat(cell);
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
