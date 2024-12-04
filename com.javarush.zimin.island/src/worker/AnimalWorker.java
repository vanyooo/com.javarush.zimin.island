package worker;

import entity.Location.Cell;
import entity.Location.Island;
import entity.Statistics;
import entity.herbivore.*;
import entity.predator.*;

import java.util.Arrays;
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
                    //TODO replace it -> throw...
                    e.printStackTrace();
                    System.err.println("OMG. Debug it!");
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

    public void printStat(Island island) {

        int sizePlant = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).mapToInt(cell -> cell.listPlant.size()).sum();
        int sizeWolf = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Wolf).map(c -> (Wolf) c).toList().size();
        int sizeBear = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Bear).map(c -> (Bear) c).toList().size();
        int sizeBoa = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Boa).map(c -> (Boa) c).toList().size();
        int sizeFox = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Fox).map(c -> (Fox) c).toList().size();
        int sizeEagle = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Eagle).map(c -> (Eagle) c).toList().size();
        int sizeSheep = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Sheep).map(c -> (Sheep) c).toList().size();
        int sizeDeer = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Deer).map(c -> (Deer) c).toList().size();
        int sizeBuf = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Buffalo).map(c -> (Buffalo) c).toList().size();
        int sizeRabbit = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream()).
                filter(c -> c instanceof Rabbit).map(c -> (Rabbit) c).toList().size();
        int sizeGoat = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Goat).map(c -> (Goat) c).toList().size();
        int sizeMouse = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Mouse).map(c -> (Mouse) c).toList().size();
        int sizeDuck = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Duck).map(c -> (Duck) c).toList().size();
        int sizeHorse = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Horse).map(c -> (Horse) c).toList().size();
        int sizeCaterpillar = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Caterpillar).map(c -> (Caterpillar) c).toList().size();
        int sizePredator = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Predator).map(c -> (Predator) c).toList().size();
        int sizeHerbivore = Arrays.stream(island.islandArrays).flatMap(Arrays::stream).flatMap(cell -> cell.listAnimal.stream())
                .filter(c -> c instanceof Herbivore).map(c -> (Herbivore) c).toList().size();
        System.out.print("Wolf: " + sizeWolf + "||" + "Sheep: " + sizeSheep + "||" + "||" + "Bear: " + sizeBear
                + "||" + "Boa: " + sizeBoa + "||" + "Fox: " + sizeFox + "||" + "Eagle: " + sizeEagle + "||" + "Deer: " + sizeDeer
                + "||" + "Buf: " + sizeBuf + "||" + "Rabbit: " + sizeRabbit + "||" + "Goat: " + sizeGoat + "||" + "Mouse: " + sizeMouse
                + "||" + "Duck: " + sizeDuck + "||" + "Horse: " + sizeHorse + "||" + "Caterpillar: " + sizeCaterpillar + "\n");
        System.out.print( "Plant: " + sizePlant + "||" + "Herbivore: " + sizeHerbivore + "||" + "Predator: " + sizePredator + "\n");
    }
}
