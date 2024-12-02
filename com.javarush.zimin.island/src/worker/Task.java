package worker;

import entity.Animal;
import entity.Location.Cell;

public class Task {
    private final Animal animal;
    private final Cell cell;

    public Task(Animal animal, Cell cell) {
        this.animal = animal;
        this.cell = cell;
    }

    public void doTask() {
        animal.reproduce(cell);
        animal.eat(cell);
        animal.worker();
        animal.dei(cell);

    }
}
