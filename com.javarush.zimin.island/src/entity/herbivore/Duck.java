package entity.herbivore;

import entity.Settings;

public class Duck extends Herbivore {

    public Duck() {
        super.setWeight(Settings.weightDuck);
        super.setMaxSpeed(Settings.maxSpeedDuck);
        super.setMaxSatiety(Settings.maxSatietyDuck);
        super.setActualSatiety(Settings.actualSatietyDuck);
        super.setCountOnOneCell(Settings.countDuckOnOneCell);
    }
}
