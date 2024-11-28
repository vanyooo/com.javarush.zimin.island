import entity.Cell;
import entity.Plant;
import entity.herbivore.*;
import entity.predator.*;

import java.util.List;
import java.util.concurrent.Future;

public class Statistics implements Runnable {
    Cell cell;

    public Statistics(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void run() {
        int sizePlant = cell.queueEntity.stream().filter(c -> c instanceof Plant).map(c -> (Plant) c).toList().size();
        int sizeWolf = cell.queueEntity.stream().filter(c -> c instanceof Wolf).map(c -> (Wolf) c).toList().size();
        int sizeBear = cell.queueEntity.stream().filter(c -> c instanceof Bear).map(c -> (Bear) c).toList().size();
        int sizeBoa = cell.queueEntity.stream().filter(c -> c instanceof Boa).map(c -> (Boa) c).toList().size();
        int sizeFox = cell.queueEntity.stream().filter(c -> c instanceof Fox).map(c -> (Fox) c).toList().size();
        int sizeEagle = cell.queueEntity.stream().filter(c -> c instanceof Eagle).map(c -> (Eagle) c).toList().size();
        int sizeSheep = cell.queueEntity.stream().filter(c -> c instanceof Sheep).map(c -> (Sheep) c).toList().size();
        int sizeDeer = cell.queueEntity.stream().filter(c -> c instanceof Deer).map(c -> (Deer) c).toList().size();
        int sizeBuf = cell.queueEntity.stream().filter(c -> c instanceof Buffalo).map(c -> (Buffalo) c).toList().size();
        int sizeRabbit = cell.queueEntity.stream().filter(c -> c instanceof Rabbit).map(c -> (Rabbit) c).toList().size();
        int sizeGoat = cell.queueEntity.stream().filter(c -> c instanceof Goat).map(c -> (Goat) c).toList().size();
        int sizeMouse = cell.queueEntity.stream().filter(c -> c instanceof Mouse).map(c -> (Mouse) c).toList().size();
        int sizeDuck = cell.queueEntity.stream().filter(c -> c instanceof Duck).map(c -> (Duck) c).toList().size();
        int sizeHorse = cell.queueEntity.stream().filter(c -> c instanceof Horse).map(c -> (Horse) c).toList().size();
        System.out.print("Wolf: " + sizeWolf + "||" + "Sheep: " + sizeSheep + "||" + "Plant: " + sizePlant + "||" + "Bear: " + sizeBear
                + "||" + "Boa: " + sizeBoa + "||" + "Fox: " + sizeFox + "||" + "Eagle: " + sizeEagle + "||" + "Deer: " + sizeDeer
                + "||" + "Buf: " + sizeBuf + "||" + "Rabbit: " + sizeRabbit + "||" + "Goat: " + sizeGoat + "||" + "Mouse: " + sizeMouse
                + "||" + "Duck: " + sizeDuck + "||" + "Horse: " + sizeHorse);
        System.out.println();
    }
}
