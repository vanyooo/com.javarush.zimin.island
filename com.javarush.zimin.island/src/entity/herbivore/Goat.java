package entity.herbivore;

import entity.Settings;

public class Goat extends Herbivore {

    public Goat() {
        super.setWeight(Settings.weightGoat);
        super.setMaxSpeed(Settings.maxSpeedGoat);
        super.setMaxSatiety(Settings.maxSatietyGoat);
        super.setActualSatiety(Settings.actualSatietyGoat);
        super.setCountOnOneCell(Settings.countGoatOnOneCell);
    }
}
