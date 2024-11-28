package entity.herbivore;

import entity.Settings;

public class Buffalo extends Herbivore {

    public Buffalo() {
        super.setWeight(Settings.weightBuffalo);
        super.setMaxSpeed(Settings.maxSpeedBuffalo);
        super.setMaxSatiety(Settings.maxSatietyBuffalo);
        super.setActualSatiety(Settings.actualSatietyBuffalo);
        super.setCountOnOneCell(Settings.countBuffaloOnOneCell);
    }
}