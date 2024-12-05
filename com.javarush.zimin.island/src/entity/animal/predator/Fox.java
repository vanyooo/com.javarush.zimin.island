package entity.animal.predator;

import config.Settings;

public class Fox extends Predator{

    public Fox() {
        super.setWeight(Settings.weightFox);
        super.setMaxSpeed(Settings.maxSpeedFox);
        super.setMaxSatiety(Settings.maxSatietyFox);
        super.setActualSatiety(Settings.actualSatietyFox);
        super.setCountOnOneCell(Settings.countFoxOnOneCell);
        super.setProbabilityEaten(Settings.ProbabilityBeingEatenFox);
    }
}
