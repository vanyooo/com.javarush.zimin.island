package entity;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;



public class Cell implements Runnable {

    Island island = new Island();

    private static final CountDownLatch START = new CountDownLatch(4);

//    public List<Entity> countEntity = Collections.synchronizedList(new ArrayList<>());
    public ConcurrentLinkedQueue<Entity> queueEntity = new ConcurrentLinkedQueue<>();

    @Override
    public void run() {
        List<Animal> list = queueEntity.stream().filter(cell -> cell instanceof Animal).map(animal -> (Animal) animal).toList();
        for (Animal animal : list) {
            animal.worker();
            START.countDown();
            animal.eat(queueEntity);
            START.countDown();
            animal.reproduce(queueEntity);
            START.countDown();
            animal.dei(queueEntity);
            START.countDown();
        }
    }
}

