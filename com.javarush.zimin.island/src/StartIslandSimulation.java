import entity.*;
import entity.Location.Cell;
import entity.Location.Island;
import entity.herbivore.*;
import entity.predator.*;
import worker.AnimalWorker;
import worker.PlantWorker;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartIslandSimulation {
    public static void main(String[] args) {
        Island island = new Island();
        IslandInitialization.in(island);
        Statistics statistics = new Statistics();
        statistics.collectingStatistics(island);

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(new PlantWorker(island), 0, 5, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < island.islandArrays.length; j++) {
                for (int k = 0; k < island.islandArrays[j].length; k++) {
                    AnimalWorker organismWorker = new AnimalWorker(island.islandArrays[j][k]);
                    organismWorker.processOneCell(island.islandArrays[j][k]);
                }
            }
        }
        executorService.shutdown();
        statistics.collectingStatistics(island);
    }
}
