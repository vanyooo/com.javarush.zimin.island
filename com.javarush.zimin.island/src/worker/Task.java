package worker;

import entity.animal.Animal;
import entity.location.Cell;
import entity.location.Island;

public class Task {
    private final Animal animal;
    private final Cell cell;
    private final Island island;

    public Task(Animal animal, Cell cell, Island island) {
        this.animal = animal;
        this.cell = cell;
        this.island = island;
    }

    public void doTask() {
        animal.worker();
        if (animal.eat(cell)){
            animal.reproduce(cell);
        }
        animal.dei(cell);
        animal.move(island);
    }
}
