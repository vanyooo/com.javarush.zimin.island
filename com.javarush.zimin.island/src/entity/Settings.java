package entity;

import java.util.HashMap;
import java.util.Map;

public final class Settings {
    /* Настройки острова*/
    public static int lengthIsland = 5;
    public static int widthIsland = 5;
    public static int longCycle = 5;
    /*Настройка Хищников*/
    public static double weightWolf = 50;
    public static int maxSpeedWolf = 3;
    public static double maxSatietyWolf = 8;
    public static double actualSatietyWolf = 8;
    public static int countWolfOnOneCell = 30;
    public static Map<String, Integer> ProbabilityBeingEatenWolf = Map.of("Sheep", 70, "Horse", 10, "Deer", 15,
            "Rabbit", 60, "Mouse", 80, "Goat", 60, "Boar", 15, "Buffalo", 10,
            "Duck", 40, "Caterpillar", 0);

    public static double weightBoa = 15;
    public static int maxSpeedBoa = 1;
    public static double maxSatietyBoa = 3;
    public static double actualSatietyBoa = 3;
    public static int countBoaOnOneCell = 30;
    public static Map<String, Integer> ProbabilityBeingEatenBoa = Map.of("Fox", 15, "Rabbit", 20, "Mouse", 40,
            "Duck", 10);

    public static double weightFox = 8;
    public static int maxSpeedFox = 2;
    public static double maxSatietyFox = 2;
    public static double actualSatietyFox = 2;
    public static int countFoxOnOneCell = 30;
    public static Map<String, Integer> ProbabilityBeingEatenFox = Map.of("Rabbit", 70, "Mouse", 90, "Duck", 80,
            "Caterpillar", 40);

    public static double weightEagle = 6;
    public static int maxSpeedEagle = 3;
    public static double maxSatietyEagle = 1;
    public static double actualSatietyEagle = 1;
    public static int countEagleOnOneCell = 20;
    public static Map<String, Integer> ProbabilityBeingEatenEagle = Map.of("Rabbit", 90, "Mouse", 90, "Duck", 80,
            "Fox", 10);

    public static double weightBear = 500;
    public static int maxSpeedBear = 2;
    public static double maxSatietyBear = 60;
    public static double actualSatietyBear = 60;
    public static int countBearOnOneCell = 5;
    public static Map<String, Integer> ProbabilityBeingEatenBear = Map.of("Horse", 40, "Deer", 80,
            "Rabbit", 80, "Mouse", 90, "Goat", 70, "Boar", 50, "Buffalo", 20,
            "Duck", 10, "Boa", 80, "Sheep", 70);
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

    public static double weightRabbit = 2;
    public static int maxSpeedRabbit = 2;
    public static double maxSatietyRabbit = 0.45;
    public static double actualSatietyRabbit = 0.45;
    public static int countOnOneCellRabbit = 150;


    public static Map<String, Double> weightOfAllEdibleAnimals = Map.of("Sheep", 70.0, "Horse", 400.0, "Deer", 300.0,
            "Rabbit", 2.0, "Mouse", 0.1, "Goat", 60.0, "Boar", 400.0, "Buffalo", 700.0,
            "Duck", 1.0, "Caterpillar", 0.01);
//    public static Map<String, Double> weightOfAllEdibleAnimals = Map.of("Sheep", 35.0, "Horse", 200.0,"Deer",150.0,
//            "Rabbit", 1.0, "Mouse", 0.05, "Goat", 30.0, "Boar", 200.0, "Buffalo", 350.0,
//            "Duck", 0.5, "Caterpillar", 0.01);


}
