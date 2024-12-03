package worker;

import entity.Location.Cell;
import entity.Location.Island;
import entity.herbivore.*;
import entity.predator.*;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AnimalWorker implements Runnable{
    Island island;
    public Cell cell;
    private final Queue<Task> tasks = new ConcurrentLinkedQueue<>();

    public AnimalWorker(Island island, Cell cell) {
        this.island = island;
        this.cell = cell;
    }

    @Override
    public void run() {
        try {
            processOneCell(cell);
//            printStat(cell);
        } catch (Exception e) {
            //TODO replace it -> throw...
            e.printStackTrace();
            System.err.println("OMG. Debug it!");
            System.exit(0);
        }
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

    public void printStat (Cell cell) {
        int sizePlant = cell.listPlant.size();
        int sizeWolf = cell.listAnimal.stream().filter(c -> c instanceof Wolf).map(c -> (Wolf) c).toList().size();
        int sizeBear = cell.listAnimal.stream().filter(c -> c instanceof Bear).map(c -> (Bear) c).toList().size();
        int sizeBoa = cell.listAnimal.stream().filter(c -> c instanceof Boa).map(c -> (Boa) c).toList().size();
        int sizeFox = cell.listAnimal.stream().filter(c -> c instanceof Fox).map(c -> (Fox) c).toList().size();
        int sizeEagle = cell.listAnimal.stream().filter(c -> c instanceof Eagle).map(c -> (Eagle) c).toList().size();
        int sizeSheep = cell.listAnimal.stream().filter(c -> c instanceof Sheep).map(c -> (Sheep) c).toList().size();
        int sizeDeer = cell.listAnimal.stream().filter(c -> c instanceof Deer).map(c -> (Deer) c).toList().size();
        int sizeBuf = cell.listAnimal.stream().filter(c -> c instanceof Buffalo).map(c -> (Buffalo) c).toList().size();
        int sizeRabbit = cell.listAnimal.stream().filter(c -> c instanceof Rabbit).map(c -> (Rabbit) c).toList().size();
        int sizeGoat = cell.listAnimal.stream().filter(c -> c instanceof Goat).map(c -> (Goat) c).toList().size();
        int sizeMouse = cell.listAnimal.stream().filter(c -> c instanceof Mouse).map(c -> (Mouse) c).toList().size();
        int sizeDuck = cell.listAnimal.stream().filter(c -> c instanceof Duck).map(c -> (Duck) c).toList().size();
        int sizeHorse = cell.listAnimal.stream().filter(c -> c instanceof Horse).map(c -> (Horse) c).toList().size();
        System.out.print("Wolf: " + sizeWolf + "||" + "Sheep: " + sizeSheep + "||" + "Plant: " + sizePlant + "||" + "Bear: " + sizeBear
                + "||" + "Boa: " + sizeBoa + "||" + "Fox: " + sizeFox + "||" + "Eagle: " + sizeEagle + "||" + "Deer: " + sizeDeer
                + "||" + "Buf: " + sizeBuf + "||" + "Rabbit: " + sizeRabbit + "||" + "Goat: " + sizeGoat + "||" + "Mouse: " + sizeMouse
                + "||" + "Duck: " + sizeDuck + "||" + "Horse: " + sizeHorse);
        System.out.println();
    }
}
