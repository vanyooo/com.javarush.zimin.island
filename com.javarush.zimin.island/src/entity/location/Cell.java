package entity.location;

import entity.animal.Animal;
import entity.plant.Plant;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Cell {
    public Lock lock = new ReentrantLock();

    private static final CountDownLatch START = new CountDownLatch(4);

    public CopyOnWriteArrayList<Animal> listAnimal = new CopyOnWriteArrayList<>();
    public CopyOnWriteArrayList<Plant> listPlant = new CopyOnWriteArrayList<>();
}

