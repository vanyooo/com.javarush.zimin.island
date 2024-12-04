package entity.herbivore;

import entity.Animal;
import entity.Location.Cell;
import entity.Plant;
import entity.Settings;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Duck extends Herbivore {

    public Duck() {
        super.setWeight(Settings.weightDuck);
        super.setMaxSpeed(Settings.maxSpeedDuck);
        super.setMaxSatiety(Settings.maxSatietyDuck);
        super.setActualSatiety(Settings.actualSatietyDuck);
        super.setCountOnOneCell(Settings.countDuckOnOneCell);
    }

    @Override
    public void eat(Cell cell) {
        lock.lock();
        try {
            if (actualSatiety >= maxSatiety) {
                actualSatiety = maxSatiety;
                return;
            }
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            List<Animal> listCaterpillar = listAnimal.stream().filter(animal -> animal instanceof Caterpillar).toList();
            if (!listCaterpillar.isEmpty()) {
                Animal first = listCaterpillar.getFirst();
                int probability = Settings.chanceEatCaterpillarDuck;
                int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
                if (probability >= randomNum) {
                    Double weightFood = Settings.weightOfAllEdibleAnimals.get(first.getClass().getSimpleName());
                    if (weightFood > maxSatiety) {
                        actualSatiety = maxSatiety;
                    } else {
                        actualSatiety += weightFood;
                    }
                    cell.listAnimal.remove(first);
                }
            }
            if (actualSatiety >= maxSatiety) {
                actualSatiety = maxSatiety;
                return;
            }
            CopyOnWriteArrayList<Plant> listPlant = cell.listPlant;
            if (listPlant.isEmpty()) {
                return;
            }
            Plant firstPlant = listPlant.getFirst();
            int weightPlant = Plant.weight;
            if (weightPlant > maxSatiety) {
                actualSatiety = maxSatiety;
                cell.listPlant.remove(firstPlant);
            } else {
                actualSatiety = actualSatiety + weightPlant + (maxSatiety * 0.3);
                cell.listPlant.remove(firstPlant);
            }
        } finally {
            lock.unlock();
        }
    }
}
