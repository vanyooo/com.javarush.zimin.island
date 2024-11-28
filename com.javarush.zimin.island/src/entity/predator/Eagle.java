package entity.predator;

import entity.Settings;

public class Eagle extends Predator{

    public Eagle() {
        super.setWeight(Settings.weightEagle);
        super.setMaxSpeed(Settings.maxSpeedEagle);
        super.setMaxSatiety(Settings.maxSatietyEagle);
        super.setActualSatiety(Settings.actualSatietyEagle);
        super.setCountOnOneCell(Settings.countEagleOnOneCell);
        super.setProbabilityEaten(Settings.ProbabilityBeingEatenEagle);
    }
}
