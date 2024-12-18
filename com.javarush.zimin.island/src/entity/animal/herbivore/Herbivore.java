package entity.animal.herbivore;

import entity.animal.Animal;
import entity.location.Cell;
import entity.plant.Plant;
import config.Settings;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Herbivore extends Animal {
    Lock lock = new ReentrantLock();

    @Override
    public boolean eat(Cell cell) {
        lock.lock();
        try {
            if (actualSatiety >= maxSatiety) {
                actualSatiety = maxSatiety;
                return true;
            }
            CopyOnWriteArrayList<Plant> listPlant = cell.listPlant;
            if (listPlant.isEmpty()) {
                return false;
            }
            for (Plant plant : listPlant) {
                int weightPlant = Plant.weight;
                if (weightPlant > maxSatiety) {
                    actualSatiety = maxSatiety;
                    cell.listPlant.remove(plant);
                } else {
                    actualSatiety = actualSatiety + weightPlant + (maxSatiety * Settings.onTopWeightAnimalAndPlant);
                    cell.listPlant.remove(plant);
                }
                return true;
            }
        }finally {
            lock.unlock();
        }
        return true;
    }
}
