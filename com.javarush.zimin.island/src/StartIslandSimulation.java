import entity.*;
import entity.herbivore.*;
import entity.predator.*;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartIslandSimulation {
    public static void main(String[] args) {

        Island island = new Island();

        Cell[][] islandArrays = new Cell[Settings.widthIsland][Settings.lengthIsland];

        Cell cell = new Cell();
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Wolf());
        cell.queueEntity.add(new Wolf());
        cell.queueEntity.add(new Sheep());
        cell.queueEntity.add(new Sheep());
        cell.queueEntity.add(new Deer());
        cell.queueEntity.add(new Deer());
        cell.queueEntity.add(new Rabbit());
        cell.queueEntity.add(new Rabbit());
        cell.queueEntity.add(new Mouse());
        cell.queueEntity.add(new Mouse());
        cell.queueEntity.add(new Goat());
        cell.queueEntity.add(new Goat());
        cell.queueEntity.add(new Buffalo());
        cell.queueEntity.add(new Buffalo());
        cell.queueEntity.add(new Bear());
        cell.queueEntity.add(new Bear());
        cell.queueEntity.add(new Duck());
        cell.queueEntity.add(new Duck());
        cell.queueEntity.add(new Boa());
        cell.queueEntity.add(new Boa());
        cell.queueEntity.add(new Fox());
        cell.queueEntity.add(new Fox());
        cell.queueEntity.add(new Eagle());
        cell.queueEntity.add(new Eagle());
        cell.queueEntity.add(new Bear());
        cell.queueEntity.add(new Bear());

        islandArrays[0][0] = cell;

        for (int i = 0; i < islandArrays.length; i++) {
            for (int j = 0; j < islandArrays[i].length; j++) {
                islandArrays[i][j] = new Cell();
            }
        }
        islandArrays[0][0] = cell;

//        ScheduledExecutorService executorStatistic = Executors.newScheduledThreadPool(1);
//        ScheduledExecutorService executorPlant = Executors.newScheduledThreadPool(1);
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//
//        executorStatistic.scheduleAtFixedRate(new Statistics(cell), 0, 1000, TimeUnit.MILLISECONDS);
//        executorPlant.scheduleAtFixedRate(new Plant(cell), 0, 70, TimeUnit.MILLISECONDS);
//
//        System.out.println("---------------");
//
//        executorStatistic.shutdown();
//        executorService.shutdown();
//        executorPlant.shutdown();

    }
}
