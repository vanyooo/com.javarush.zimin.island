
import entity.Location.Island;
import entity.predator.Wolf;

public class StartIslandSimulation {
    public static void main(String[] args) {
        Island island = new Island();
        IslandInitialization.start(island);
        CreatingMultithreading creatingMultithreading = new CreatingMultithreading(island);
        creatingMultithreading.islandStartLive();

    }
}
