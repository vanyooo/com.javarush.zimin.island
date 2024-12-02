package entity;

import entity.Location.Cell;
import entity.Location.Island;
import lombok.Data;
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
        lock.lock();
//        System.out.println("Method worker");
//        System.out.println("Работает " + this.getClass().getSimpleName());
        this.actualSatiety = this.actualSatiety - (this.maxSatiety * 0.3);
        lock.unlock();
    }

    public void eat(Cell cell) {
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
        lock.lock();
//        System.out.println("Method reproduce");
        try {
//            System.out.println("Пробует родить " + this.getClass().getSimpleName());
            CopyOnWriteArrayList<Animal> listAnimal = cell.listAnimal;
            int randomNum = ThreadLocalRandom.current().nextInt(1, 101);
            if (randomNum >= 50) {
                int sizeIndividual = listAnimal.stream().filter(count -> this.getClass().equals(count.getClass())).toList().size();
//            List<Animal> animalForMating = listAnimal.stream().filter(c -> this.getClass().equals(c.getClass())).toList();
                if (sizeIndividual < 2) {
//                animalForMating.isEmpty() || sizeIndividual == 1
//                    System.out.println("Пары нет");
                    return;
                }
                if (sizeIndividual >= countOnOneCell) {
//                    System.out.println("Вас и так много");
                    return;
                }
//                System.out.println(sizeIndividual);
//                System.out.println(this.getClass().getSimpleName());
                String simpleName = this.getClass().getSimpleName();

//                System.out.println("Создали еще одного " + simpleName);
                listAnimal.add(AnimalFactory.giveBirthAnimal(simpleName));
//                System.out.println(cell.listAnimal.stream().filter(count -> this.getClass().equals(count.getClass())).toList().size());

            }
        } finally {
            lock.unlock();
        }
    }

    public void dei(Cell cell) {
        lock.lock();
//        System.out.println("Method die");
        try {
//            System.out.println("Пробуем умереть " + this.getClass().getSimpleName());
//            System.out.println(actualSatiety);
            if (actualSatiety <= 0) {
                cell.listAnimal.remove(this);
//                System.out.println("Die");
            }
        } finally {
            lock.unlock();
        }
    }
}
