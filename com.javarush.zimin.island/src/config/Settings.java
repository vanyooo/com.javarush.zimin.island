package config;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Settings {

    /* Настройки острова*/
    public static int lengthIsland = 5;
    public static int widthIsland = 5;
    public static int longCycle = 20;
    public static int countThread = 4;
    public static int countThreadShed = 2;
    public static int countThreadShedPlant = 2;
    /* Настройки размножения и поедания*/
    public static int randomMating = 10;
    public static double onTopWeightAnimalAndPlant = 0.1;
    public static double workerPercent = 0.1;
    /*Настройка растений*/
    public static int weightPlant = 1;
    public static int maxCountPlant = 200;
    /*Настройка Хищников*/
    public static double weightWolf = 50;
    public static int maxSpeedWolf = 3;
    public static double maxSatietyWolf = 8;
    public static double actualSatietyWolf = 8;
    public static int countWolfOnOneCell = 30;
    public static Map<String, Integer> ProbabilityBeingEatenWolf = Stream.of(
                    new Object[][]{
                            {"Boa", 0}, {"Fox", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 10}, {"Deer", 15},
                            {"Rabbit", 60}, {"Mouse", 80}, {"Goat", 60}, {"Sheep", 70}, {"Boar", 15}, {"Buffalo", 10},
                            {"Duck", 40}, {"Caterpillar", 0}, {"Wolf", 0}})
            .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    public static double weightBoa = 15;
    public static int maxSpeedBoa = 1;
    public static double maxSatietyBoa = 3;
    public static double actualSatietyBoa = 3;
    public static int countBoaOnOneCell = 30;
    public static Map<String, Integer> ProbabilityBeingEatenBoa = Stream.of(
                    new Object[][]{
                            {"Wolf", 0}, {"Fox", 15}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                            {"Rabbit", 20}, {"Mouse", 40}, {"Goat", 0}, {"Sheep", 0}, {"Boar", 0}, {"Buffalo", 0},
                            {"Duck", 10}, {"Caterpillar", 0}, {"Boa", 0}})
            .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));

    public static double weightFox = 8;
    public static int maxSpeedFox = 2;
    public static double maxSatietyFox = 2;
    public static double actualSatietyFox = 2;
    public static int countFoxOnOneCell = 30;
    public static Map<String, Integer> ProbabilityBeingEatenFox = Stream.of(
                    new Object[][]{
                            {"Wolf", 0}, {"Boa", 0}, {"Bear", 0}, {"Eagle", 0}, {"Horse", 0}, {"Deer", 0},
                            {"Rabbit", 70}, {"Mouse", 90}, {"Goat", 0}, {"Sheep", 0}, {"Boar", 0}, {"Buffalo", 0},
                            {"Duck", 60}, {"Caterpillar", 40}, {"Fox", 0}})
            .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));


    public static double weightEagle = 6;
    public static int maxSpeedEagle = 3;
    public static double maxSatietyEagle = 1;
    public static double actualSatietyEagle = 1;
    public static int countEagleOnOneCell = 20;
    public static Map<String, Integer> ProbabilityBeingEatenEagle = Stream.of(
                    new Object[][]{
                            {"Wolf", 0}, {"Boa", 0}, {"Fox", 10}, {"Bear", 0}, {"Horse", 0}, {"Deer", 0},
                            {"Rabbit", 90}, {"Mouse", 90}, {"Goat", 0}, {"Sheep", 0}, {"Boar", 0}, {"Buffalo", 0},
                            {"Duck", 80}, {"Caterpillar", 0}, {"Eagle", 0}})
            .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));


    public static double weightBear = 500;
    public static int maxSpeedBear = 2;
    public static double maxSatietyBear = 60;
    public static double actualSatietyBear = 60;
    public static int countBearOnOneCell = 5;
    public static Map<String, Integer> ProbabilityBeingEatenBear = Stream.of(
                    new Object[][]{
                            {"Wolf", 0}, {"Boa", 80}, {"Fox", 0}, {"Eagle", 0}, {"Horse", 40}, {"Deer", 80},
                            {"Rabbit", 80}, {"Mouse", 90}, {"Goat", 70}, {"Sheep", 70}, {"Boar", 50}, {"Buffalo", 20},
                            {"Duck", 10}, {"Caterpillar", 0}, {"Bear", 0}})
            .collect(Collectors.toMap(data -> (String) data[0], data -> (Integer) data[1]));


    /*Настройка Травоядных*/
    public static double weightSheep = 70;
    public static int maxSpeedSheep = 3;
    public static double maxSatietySheep = 15;
    public static double actualSatietySheep = 15;
    public static int countSheepOnOneCell = 140;

    public static double weightBoar = 400;
    public static int maxSpeedBoar = 2;
    public static double maxSatietyBoar = 50;
    public static double actualSatietyBoar = 50;
    public static int countBoarOnOneCell = 50;
    public static int chanceEatCaterpillarBoar = 90;

    public static double weightBuffalo = 700;
    public static int maxSpeedBuffalo = 3;
    public static double maxSatietyBuffalo = 100;
    public static double actualSatietyBuffalo = 100;
    public static int countBuffaloOnOneCell = 10;

    public static double weightCaterpillar = 0.01;
    public static int maxSpeedCaterpillar = 0;
    public static double maxSatietyCaterpillar = 0;
    public static double actualSatietyCaterpillar = 0;
    public static int countCaterpillarOnOneCell = 1000;

    public static double weightDeer = 300;
    public static int maxSpeedDeer = 4;
    public static double maxSatietyDeer = 60;
    public static double actualSatietyDeer = 60;
    public static int countDeerOnOneCell = 20;

    public static double weightDuck = 1;
    public static int maxSpeedDuck = 4;
    public static double maxSatietyDuck = 0.15;
    public static double actualSatietyDuck = 0.15;
    public static int countDuckOnOneCell = 200;
    public static int chanceEatCaterpillarDuck = 90;

    public static double weightGoat = 60;
    public static int maxSpeedGoat = 3;
    public static double maxSatietyGoat = 10;
    public static double actualSatietyGoat = 10;
    public static int countGoatOnOneCell = 140;

    public static double weightHorse = 400;
    public static int maxSpeedHorse = 4;
    public static double maxSatietyHorse = 60;
    public static double actualSatietyHorse = 60;
    public static int countHorseOnOneCell = 20;

    public static double weightMouse = 0.05;
    public static int maxSpeedMouse = 1;
    public static double maxSatietyMouse = 0.15;
    public static double actualSatietyMouse = 0.15;
    public static int countMouseOnOneCell = 500;
    public static int chanceEatCaterpillarMouse = 90;

    public static double weightRabbit = 2;
    public static int maxSpeedRabbit = 2;
    public static double maxSatietyRabbit = 0.45;
    public static double actualSatietyRabbit = 0.45;
    public static int countRabbitOnOneCell = 150;


    public static Map<String, Double> weightOfAllEdibleAnimals = Stream.of(
                    new Object[][]{
                            {"Wolf", 50.0}, {"Boa", 15.0}, {"Fox", 8.0}, {"Eagle", 6.0}, {"Horse", 400.0}, {"Deer", 300.0},
                            {"Rabbit", 2.0}, {"Mouse", 0.05}, {"Goat", 60.0}, {"Sheep", 70.0}, {"Boar", 400.0}, {"Buffalo", 700.0},
                            {"Duck", 1.0}, {"Caterpillar", 0.01}, {"Bear", 500.0}})
            .collect(Collectors.toMap(data -> (String) data[0], data -> (Double) data[1]));
}
