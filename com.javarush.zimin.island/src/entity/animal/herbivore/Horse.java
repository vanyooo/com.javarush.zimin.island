package entity.animal.herbivore;

import config.Settings;

public class Horse extends Herbivore {

    public Horse() {
        super.setWeight(Settings.weightHorse);
        super.setMaxSpeed(Settings.maxSpeedHorse);
        super.setMaxSatiety(Settings.maxSatietyHorse);
        super.setActualSatiety(Settings.actualSatietyHorse);
        super.setCountOnOneCell(Settings.countHorseOnOneCell);
    }
}
