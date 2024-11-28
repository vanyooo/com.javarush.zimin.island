package entity.herbivore;

import entity.Settings;

public class Mouse extends Herbivore{

    public Mouse() {
        super.setWeight(Settings.weightMouse);
        super.setMaxSpeed(Settings.maxSpeedMouse);
        super.setMaxSatiety(Settings.maxSatietyMouse);
        super.setActualSatiety(Settings.actualSatietyMouse);
        super.setCountOnOneCell(Settings.countMouseOnOneCell);
    }
}
