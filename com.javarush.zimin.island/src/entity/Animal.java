package entity;

import entity.Location.Cell;
import entity.Location.Island;
import lombok.Data;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@Data
public abstract class Animal {

    public double weight;
    public int maxSpeed;
    public double maxSatiety;
    public double actualSatiety;
    public int countOnOneCell;
    public Map<String, Integer> probabilityEaten;

    Lock lock = new ReentrantLock();

    public void worker() {
        lock.lock();
        this.actualSatiety = this.actualSatiety - (this.maxSatiety * 0.2) - 0.1;
        lock.unlock();
    }

    public boolean eat(Cell cell) {
        return true;
    }

    public void move(Island island) {
        lock.lock();
        try {
            Cell[][] islandArrays = island.islandArrays;
            for (int i = 0; i < islandArrays.length; i++) {
                for (int j = 0; j < islandArrays.length; j++) {
                    if (islandArrays[i][j].listAnimal.contains(this)) {
                        int randomStep = ThreadLocalRandom.current().nextInt(0, this.maxSpeed + 1);
                        int randomDirection = ThreadLocalRandom.current().nextInt(1, 9);
                        int newI = i;
                        int newJ = j;
                        switch (randomDirection) {
                            case 1 -> newI -= randomStep; // Вверх
                            case 2 -> {
                                newI -= randomStep;
                                newJ += randomStep;
                            } // Вверх вправо
                            case 3 -> newJ += randomStep; // Вправо
                            case 4 -> {
                                newI += randomStep;
                                newJ += randomStep;
                            } // Вниз вправо
                            case 5 -> newI += randomStep; // Вниз
                            case 6 -> {
                                newI += randomStep;
                                newJ -= randomStep;
                            } // Вниз влево
                            case 7 -> newJ -= randomStep; // Влево
                            case 8 -> {
                                newI -= randomStep;
                                newJ -= randomStep;
                            } // Вверх влево
                        }
                        newI = (newI + islandArrays.length) % islandArrays.length;
                        newJ = (newJ + islandArrays[i].length) % islandArrays[i].length;
                        int sizeAnimal = islandArrays[newI][newJ].listAnimal.stream().filter(animal -> this.getClass()
                                .equals(animal.getClass())).toList().size();
                        if (sizeAnimal >= this.countOnOneCell) {
                            return;
                        }
                        islandArrays[newI][newJ].listAnimal.add(this);
                        islandArrays[i][j].listAnimal.remove(this);
                        return;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException _) {
        } finally {
            lock.unlock();
        }
    }

    public void reproduce(Cell cell) {
        lock.lock();
        try {
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
            if (randomNum >= Settings.randomMating) {
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
