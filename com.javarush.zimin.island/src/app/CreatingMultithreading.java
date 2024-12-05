package app;

import entity.location.Island;
import config.Settings;
import worker.AnimalWorker;
import worker.PlantWorker;
import statistic.Statistics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CreatingMultithreading {
    public ScheduledExecutorService executorSimulationService;
    public ExecutorService serviceForCreaturesWorker;
    public ScheduledExecutorService executorServicePlant;
    Island island;

    public CreatingMultithreading(Island island) {
        this.island = island;
        this.executorSimulationService = Executors.newScheduledThreadPool(Settings.countThreadShed);
        this.serviceForCreaturesWorker = Executors.newFixedThreadPool(Settings.countThread);
        this.executorServicePlant = Executors.newScheduledThreadPool(Settings.countThreadShedPlant);
    }

    public void islandStartLive() {
        executorSimulationService.scheduleWithFixedDelay(this::lifeCycle, 0, 1000, TimeUnit.MILLISECONDS);
        executorServicePlant.scheduleWithFixedDelay(new PlantWorker(island), 0, 800, TimeUnit.MILLISECONDS);
    }

    private void lifeCycle() {
        AnimalWorker animalWorker = new AnimalWorker(island);
        serviceForCreaturesWorker.execute(animalWorker);
        int stop = Settings.longCycle;
        if (Statistics.countNumberAnimal(island) == 0 || AnimalWorker.countDay.get() == stop) {
            stopSimulation();
        }
    }

    public void stopSimulation() {
        serviceForCreaturesWorker.shutdown();
        try {
            if (!serviceForCreaturesWorker.awaitTermination(1, TimeUnit.SECONDS)) {
                serviceForCreaturesWorker.shutdownNow();
            }
        } catch (InterruptedException e) {
            serviceForCreaturesWorker.shutdownNow();
        }
        executorSimulationService.shutdown();
        try {
            if (!executorSimulationService.awaitTermination(1, TimeUnit.SECONDS)) {
                executorSimulationService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorSimulationService.shutdownNow();
        }
        try {
            if (!executorServicePlant.awaitTermination(2, TimeUnit.SECONDS)) {
                executorServicePlant.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorServicePlant.shutdownNow();
        }
    }
}
