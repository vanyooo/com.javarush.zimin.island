package app;

import entity.animal.Animal;
import entity.location.Cell;
import entity.location.Island;
import entity.plant.Plant;
import config.Settings;
import entity.animal.herbivore.*;
import entity.animal.predator.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IslandInitialization {
    public static void start (Island island) {
        int size = island.islandArrays.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < island.islandArrays[i].length; j++) {
                Cell cell = new Cell();
                cell.listPlant.addAll(createPlants());
                island.islandArrays[i][j] = cell;
            }
        }
        island.islandArrays[0][0].listAnimal.addAll(createAnimals());
        island.islandArrays[Settings.lengthIsland-1][Settings.widthIsland-1].listAnimal.addAll(createAnimals());
        island.islandArrays[Settings.lengthIsland / 2][Settings.widthIsland / 2].listAnimal.addAll(createAnimals());
    }
    public static List<Animal> createAnimals() {
        List<Animal> animals = new CopyOnWriteArrayList<>();
        animals.add(new Wolf());
        animals.add(new Wolf());
        animals.add(new Bear());
        animals.add(new Bear());
        animals.add(new Boa());
        animals.add(new Boa());
        animals.add(new Fox());
        animals.add(new Fox());
        animals.add(new Eagle());
        animals.add(new Eagle());
        animals.add(new Buffalo());
        animals.add(new Buffalo());
        animals.add(new Sheep());
        animals.add(new Sheep());
        animals.add(new Rabbit());
        animals.add(new Rabbit());
        animals.add(new Mouse());
        animals.add(new Mouse());
        animals.add(new Boar());
        animals.add(new Boar());
        animals.add(new Deer());
        animals.add(new Deer());
        animals.add(new Goat());
        animals.add(new Goat());
        animals.add(new Horse());
        animals.add(new Horse());
        animals.add(new Duck());
        animals.add(new Duck());
        animals.add(new Caterpillar());
        animals.add(new Caterpillar());
        return animals;
    }

    public static List<Plant> createPlants() {
        return List.of(new Plant(), new Plant(), new Plant());
    }

}
