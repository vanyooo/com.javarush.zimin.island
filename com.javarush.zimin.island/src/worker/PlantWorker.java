package worker;

import entity.Location.Island;
import entity.Plant;
import entity.Settings;

public class PlantWorker implements Runnable {
    Island island;
    int maxCountPlant = Settings.maxCountPlant;

    public PlantWorker(Island island) {
        this.island = island;
    }

    @Override
    public void run() {
        try {
            plantGrowth();
        } catch (Exception e) {
            System.err.println("OMG. Debug it!");
            System.exit(0);
        }
    }

    public void plantGrowth() {
        for (int i = 0; i < island.islandArrays.length; i++) {
            for (int j = 0; j < island.islandArrays[i].length; j++) {
                if (island.islandArrays[i][j].listPlant.size() <= maxCountPlant) {
                    island.islandArrays[i][j].listPlant.add(new Plant());
                } else {
                    return;
                }
            }
        }
    }
}
