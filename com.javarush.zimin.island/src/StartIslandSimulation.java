
import entity.Location.Island;
import entity.herbivore.*;
import entity.predator.*;
import worker.AnimalWorker;
import worker.PlantWorker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartIslandSimulation {
    public static void main(String[] args) {
        Island island = new Island();
        IslandInitialization.start(island);
        Statistics statistics = new Statistics();
        statistics.collectingStatistics(island);
        AnimalWorker animalWorker = new AnimalWorker(island);

        ScheduledExecutorService executorServicePlant = Executors.newScheduledThreadPool(2);
        ExecutorService serviceForCreaturesWorker = Executors.newFixedThreadPool(4);
        while (true) {
            serviceForCreaturesWorker.execute(animalWorker);
            executorServicePlant.scheduleAtFixedRate(new PlantWorker(island), 0, 500, TimeUnit.MILLISECONDS);
            int i = AnimalWorker.countDay.get();
            if (i > 10) {
                break;
            }
        }


        executorServicePlant.shutdown();
        serviceForCreaturesWorker.shutdown();



        //        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < island.islandArrays.length; j++) {
//                for (int k = 0; k < island.islandArrays[j].length; k++) {
//                    AnimalWorker organismWorker = new AnimalWorker(island,island.islandArrays[j][k]);
//                    organismWorker.processOneCell(island.islandArrays[j][k]);
//                }
//            }
//        }
    }
}
