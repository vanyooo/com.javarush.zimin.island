import entity.Animal;
import entity.Location.Cell;
import entity.Location.Island;
import entity.Plant;
import entity.herbivore.*;
import entity.predator.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class IslandInitialization {
    public static void in (Island island) {
        int size = island.islandArrays.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < island.islandArrays[i].length; j++) {
                Cell cell = new Cell();
                cell.listAnimal.addAll(createAnimals());
                cell.listPlant.addAll(createPlants());
                island.islandArrays[i][j] = cell;
            }
        }
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
        return List.of(new Plant(), new Plant(), new Plant(), new Plant() ,new Plant(), new Plant(), new Plant(), new Plant(),
                new Plant(), new Plant());
    }

}
