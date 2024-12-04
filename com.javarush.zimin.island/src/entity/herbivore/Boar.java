package entity.herbivore;

import entity.Animal;
import entity.Location.Cell;
import entity.Plant;
import entity.Settings;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
@Data
public class Boar extends Herbivore {

    public Boar() {
        super.setActualSatiety(Settings.actualSatietyBoar);
        super.setActualSatiety(Settings.actualSatietyBoar);
        super.setWeight(Settings.weightBoar);
        super.setMaxSpeed(Settings.maxSpeedBoar);
        super.setMaxSatiety(Settings.maxSatietyBoar);
        super.setCountOnOneCell(Settings.countBoarOnOneCell);
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
                    int probability = Settings.chanceEatCaterpillarMouse;
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
