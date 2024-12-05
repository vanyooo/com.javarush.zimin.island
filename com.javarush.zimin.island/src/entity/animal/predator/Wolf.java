package entity.animal.predator;


import config.Settings;

public class Wolf extends Predator {

    public Wolf() {
        super.setWeight(Settings.weightWolf);
        super.setMaxSpeed(Settings.maxSpeedWolf);
        super.setMaxSatiety(Settings.maxSatietyWolf);
        super.setActualSatiety(Settings.actualSatietyWolf);
        super.setCountOnOneCell(Settings.countWolfOnOneCell);
        super.setProbabilityEaten(Settings.ProbabilityBeingEatenWolf);
    }
}
