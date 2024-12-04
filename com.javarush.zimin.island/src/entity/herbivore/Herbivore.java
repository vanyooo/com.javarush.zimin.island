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
            if (actualSatiety >= maxSatiety) {
                actualSatiety = maxSatiety;
                return;
            }
            CopyOnWriteArrayList<Plant> listPlant = cell.listPlant;
            if (listPlant.isEmpty()) {
                return;
            }
            for (Plant plant : listPlant) {
                int weightPlant = Plant.weight;
                if (weightPlant > maxSatiety) {
                    actualSatiety = maxSatiety;
                    cell.listPlant.remove(plant);
                } else {
                    actualSatiety = actualSatiety + weightPlant;
                    cell.listPlant.remove(plant);
                }
                return;
            }
        }finally {
            lock.unlock();
        }
    }
}
