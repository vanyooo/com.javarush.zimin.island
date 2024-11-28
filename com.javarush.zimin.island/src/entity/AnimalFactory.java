package entity;

import entity.herbivore.*;
import entity.predator.*;

public class AnimalFactory {
    public static Animal giveBirthAnimal(String simpleName) {
        Animal animalBaby = null;
        switch (simpleName) {
            case "Boa" -> animalBaby = new Boa();
            case "Wolf" -> animalBaby = new Wolf();
            case "Sheep" -> animalBaby = new Sheep();
            case "Rabbit" -> animalBaby = new Rabbit();
            case "Fox" -> animalBaby = new Fox();
            case "Bear" -> animalBaby = new Bear();
            case "Eagle" -> animalBaby = new Eagle();
            case "Boar" -> animalBaby = new Boar();
            case "Buffalo" -> animalBaby = new Buffalo();
            case "Caterpillar" -> animalBaby = new Caterpillar();
            case "Deer" -> animalBaby = new Deer();
            case "Duck" -> animalBaby = new Duck();
            case "Goat" -> animalBaby = new Goat();
            case "Horse" -> animalBaby = new Horse();
            case "Mouse" -> animalBaby = new Mouse();
        }
        return animalBaby;
    }
}
