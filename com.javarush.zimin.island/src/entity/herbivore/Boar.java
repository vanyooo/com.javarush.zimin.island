package entity.herbivore;

import entity.Settings;

public class Boar extends Herbivore {

    public Boar() {
        super.setActualSatiety(Settings.actualSatietyBoar);
        super.setWeight(Settings.weightBoar);
        super.setMaxSpeed(Settings.maxSpeedBoar);
        super.setMaxSatiety(Settings.maxSatietyBoar);
        super.setCountOnOneCell(Settings.countBoarOnOneCell);
    }
}
