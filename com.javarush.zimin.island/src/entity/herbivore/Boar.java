package entity.herbivore;

import entity.Settings;

public class Boar extends Herbivore {

    public Boar() {
        super.setWeight(Settings.weightBoar);
        super.setMaxSpeed(Settings.maxSpeedBoar);
        super.setMaxSatiety(Settings.maxSatietyBoar);
        super.setActualSatiety(Settings.actualSatietyBoar);
        super.setCountOnOneCell(Settings.countBoarOnOneCell);
    }
}
