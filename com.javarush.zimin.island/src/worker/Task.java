package worker;

import entity.Animal;
import entity.Location.Cell;
import entity.Location.Island;

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
        animal.reproduce(cell);
        animal.eat(cell);
        animal.worker();
        animal.dei(cell);
        animal.move(island);
    }
}
