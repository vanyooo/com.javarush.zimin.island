package entity;

import entity.Location.Cell;
import entity.Location.Island;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Animal {

    public double weight;
    public int maxSpeed;
    public double maxSatiety;
    public double actualSatiety;
    public int countOnOneCell;
    public Map<String, Integer> probabilityEaten;

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setProbabilityEaten(Map<String, Integer> probabilityEaten) {
        this.probabilityEaten = probabilityEaten;
    }

    public void setCountOnOneCell(int countOnOneCell) {
        this.countOnOneCell = countOnOneCell;
    }

    public void setMaxSatiety(double maxSatiety) {
        this.maxSatiety = maxSatiety;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setActualSatiety(double actualSatiety) {
        this.actualSatiety = actualSatiety;
    }

    Lock lock = new ReentrantLock();


    public void worker() {
        System.out.println(1);
        lock.lock();
        this.actualSatiety = this.actualSatiety - (this.maxSatiety * 0.3);
        lock.unlock();
    }

    public void eat(Cell cell) {
        System.out.println(2);
        if (this.actualSatiety >= this.maxSatiety) {
            this.actualSatiety = this.maxSatiety;
            System.out.println("Я ссыт ");
        }
    }

    public String selectNumberSteps() {
        StringBuilder sb = new StringBuilder();
        int randomStep = ThreadLocalRandom.current().nextInt(0, this.maxSpeed + 1);
        System.out.println(randomStep);
        for (int i = 0; i < randomStep; i++) {
            int randomDirection = ThreadLocalRandom.current().nextInt(1, 5);
            sb.append(randomDirection).append("|");
        }
        System.out.println(sb);
        return sb.toString();
    }

    public void searchLocationAnimal(Island island) {
        Cell[][] islandArrays = island.islandArrays;
        for (int i = 0; i < islandArrays.length; i++) {
            for (int j = 0; j < islandArrays.length; j++) {
                if (islandArrays[i][j].listAnimal.contains(this)) {
                    System.out.println("Я тут " + i + j);
                    int randomStep = ThreadLocalRandom.current().nextInt(0, this.maxSpeed + 1);
                    System.out.println(randomStep);
                    for (int k = 0; k < randomStep; k++) {
                        int randomDirection = ThreadLocalRandom.current().nextInt(1, 5);
                        System.out.println(randomDirection);

                    }
                }
            }
        }
    }

    public void reproduce(Cell cell) {
        System.out.println(3);
        lock.lock();
        try {
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
            if (randomNum >= 50) {
                int sizeIndividual = listAnimal.stream().filter(count -> this.getClass()
                        .equals(count.getClass())).toList().size();
                if (sizeIndividual < 2) {
                    return;
                }
                if (sizeIndividual >= countOnOneCell) {
                    return;
                }
                String simpleName = this.getClass().getSimpleName();
                listAnimal.add(AnimalFactory.giveBirthAnimal(simpleName));
            }
        } finally {
            lock.unlock();
        }
    }

    public void dei(Cell cell) {
        System.out.println(4);
        lock.lock();
        try {
            if (actualSatiety <= 0) {
                cell.listAnimal.remove(this);
            }
        } finally {
            lock.unlock();
        }
    }
}
