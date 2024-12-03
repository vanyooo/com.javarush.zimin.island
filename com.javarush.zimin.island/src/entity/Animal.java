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

    public void setActualSatiety(double actualSatiety) {
        this.actualSatiety = actualSatiety;
    }

    public void setMaxSatiety(double maxSatiety) {
        this.maxSatiety = maxSatiety;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    Lock lock = new ReentrantLock();


    public void worker() {
        lock.lock();
        this.actualSatiety = this.actualSatiety - (this.maxSatiety * 0.4);
        lock.unlock();
    }

    public void eat(Cell cell) {

    }

    public void move(Island island) {
        Cell[][] islandArrays = island.islandArrays;
        for (int i = 0; i < islandArrays.length; i++) {
            for (int j = 0; j < islandArrays.length; j++) {
                if (islandArrays[i][j].listAnimal.contains(this)) {
                    try {
                        int randomStep = ThreadLocalRandom.current().nextInt(0, this.maxSpeed + 1);
                        int randomDirection = ThreadLocalRandom.current().nextInt(1, 9);
                        islandArrays[i][j].listAnimal.remove(this);
                        int newI = i;
                        int newJ = j;
                        switch (randomDirection) {
                            case 1 -> newI -= randomStep; // Вверх
                            case 2 -> {newI -= randomStep; newJ += randomStep;} // Вверх вправо
                            case 3 -> newJ += randomStep; // Вправо
                            case 4 -> {newI += randomStep; newJ += randomStep;} // Вниз вправо
                            case 5 -> newI += randomStep; // Вниз
                            case 6 -> {newI += randomStep; newJ -= randomStep;} // Вниз влево
                            case 7 -> newJ -= randomStep; // Влево
                            case 8 -> {newI -= randomStep; newJ -= randomStep;} // Вверх влево
                        }
                        newI = (newI + islandArrays.length) % islandArrays.length;
                        newJ = (newJ + islandArrays[i].length) % islandArrays[i].length;
                        islandArrays[newI][newJ].listAnimal.add(this);
                        return;
                    } catch (ArithmeticException ae) {
                        return;
                    }
                }
            }
        }
    }

    public void reproduce(Cell cell) {
        lock.lock();
        try {
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
            if (randomNum >= 60) {
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
