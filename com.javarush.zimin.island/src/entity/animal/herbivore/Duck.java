package entity.animal.herbivore;

import entity.animal.Animal;
import entity.location.Cell;
import entity.plant.Plant;
import config.Settings;

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
    public boolean eat(Cell cell) {
        lock.lock();
        try {
            if (actualSatiety >= maxSatiety) {
                actualSatiety = maxSatiety;
                return true;
            }
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            List<Animal> listCaterpillar = listAnimal.stream().filter(animal -> animal instanceof Caterpillar).toList();
            if (!listCaterpillar.isEmpty()) {
                for (Animal cater : listCaterpillar) {
                    int probability = Settings.chanceEatCaterpillarDuck;
                    int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
                    if (probability >= randomNum) {
                        Double weightFood = Settings.weightOfAllEdibleAnimals.get(cater.getClass().getSimpleName());
                        if (weightFood > maxSatiety) {
                            actualSatiety = maxSatiety;
                        } else {
                            actualSatiety += weightFood;
                        }
                        cell.listAnimal.remove(cater);
                    }
                }
            }
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
                    actualSatiety = actualSatiety + weightPlant + (maxSatiety * 0.3);
                    cell.listPlant.remove(plant);
                }
                return false;
            }
        } finally {
            lock.unlock();
        }
        return false;
    }
}
