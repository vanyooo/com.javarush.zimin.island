package entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Entity {

    public double weight;
    public int maxSpeed;
    public double maxSatiety;
    public double actualSatiety;
    public int countOnOneCell;
    public Map<String, Integer> probabilityEaten;

    Island island = new Island();
    Cell cell = new Cell();

    public void setProbabilityEaten(Map<String, Integer> probabilityEaten) {
        this.probabilityEaten = probabilityEaten;
    }

    public void setCountOnOneCell(int countOnOneCell) {
        this.countOnOneCell = countOnOneCell;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setMaxSatiety(double maxSatiety) {
        this.maxSatiety = maxSatiety;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getActualSatiety() {
        return actualSatiety;
    }

    public void setActualSatiety(double actualSatiety) {
        this.actualSatiety = actualSatiety;
    }

    public void worker() {
//        System.out.println("Работает " + this.getClass().getSimpleName());
        actualSatiety = actualSatiety - (actualSatiety * 0.8) - 1;
    }

    public void eat(ConcurrentLinkedQueue<Entity> queueEntity) {
        if (actualSatiety >= maxSatiety) {
            actualSatiety = maxSatiety;
            System.out.println("Я ссыт ");
        }
    }

    public void move(Island island, ConcurrentLinkedQueue<Entity> queueEntity) {
        int randomStep = ThreadLocalRandom.current().nextInt(1, maxSpeed + 1);
        for (int i = 0; i < maxSpeed; i++) {
            for (int j = 0; j < maxSpeed; j++) {
                island.islandArrays[i][j].queueEntity.remove(this);
                island.islandArrays[i+1][j+2].queueEntity.add(this);
            }
        }
    }

    public void searchLocationAnimal(Island island){

    }

    public void reproduce(ConcurrentLinkedQueue<Entity> queueEntity) {
//        System.out.println("Пробует родить " + this.getClass().getSimpleName());
        int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
        if (randomNum >= 50) {
            int sizeIndividual = queueEntity.stream().filter(count -> this.getClass().equals(count.getClass())).toList().size();
            List<Entity> animalForMating = queueEntity.stream().filter(c -> this.getClass().equals(c.getClass())).toList();
            if (animalForMating.isEmpty() || sizeIndividual == 1) {
//            System.out.println("Пары нет");
                return;
            }
            if (sizeIndividual >= countOnOneCell) {
//            System.out.println("Вас и так много");
                return;
            }
//        System.out.println(sizeIndividual);
//        System.out.println(this.getClass().getSimpleName());
            String simpleName = this.getClass().getSimpleName();

//            System.out.println("Создали еще одного " + animal.getClass().getSimpleName());
            queueEntity.add(AnimalFactory.giveBirthAnimal(simpleName));
//            System.out.println(cellList.stream().filter(count -> this.getClass().equals(count.getClass())).toList().size());
            return;

        }
    }

    public void dei(ConcurrentLinkedQueue<Entity> queueEntity) {
//        System.out.println("Пробуем умереть " + this.getClass().getSimpleName());
//        System.out.println(actualSatiety);
        if (actualSatiety <= 0) {
            queueEntity.remove(this);
//            System.out.println("Die");
        }
    }
}
