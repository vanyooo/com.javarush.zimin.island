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
            if (actualSatiety >= maxSatiety) {
                actualSatiety = maxSatiety;
                return;
            }
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            if (listAnimal.isEmpty()) {
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
                    if (probability >= randomNum) {
                        Double weightFood = Settings.weightOfAllEdibleAnimals.get(animal.getClass().getSimpleName());
                        if (weightFood > maxSatiety) {
                            actualSatiety = maxSatiety;
                        } else {
                            actualSatiety += weightFood;
                        }
                        cell.listAnimal.remove(animal);
                    }
                    return;
                } catch (NullPointerException nullPint) {
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
