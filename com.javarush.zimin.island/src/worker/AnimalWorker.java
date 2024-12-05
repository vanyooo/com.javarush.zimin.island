package worker;

import entity.Location.Cell;
import entity.Location.Island;
import entity.Statistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AnimalWorker implements Runnable {
    Island island;
    public static final AtomicInteger countDay = new AtomicInteger(1);
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public AnimalWorker(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        Cell[][] cell = island.islandArrays;
        for (Cell[] cells : cell) {
            for (Cell cell1 : cells) {
                CountDownLatch latch = new CountDownLatch(1);
                try {
                    processOneCell(cell1);
                } catch (Exception e) {
                    System.err.println("Error");
                    System.exit(0);
                } finally {
                    latch.countDown();
                }
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("День: " + countDay.getAndIncrement());
        Statistics.collectingStatistics(island);
        System.out.println();
    }

    public void processOneCell(Cell cell) {
        cell.lock.lock();
        try {
            cell.listAnimal.forEach(animal -> tasks.add(new Task(animal, cell, island)));
        } finally {
            cell.lock.unlock();
        }
        tasks.forEach(Task::doTask);
        tasks.clear();
    }
}
