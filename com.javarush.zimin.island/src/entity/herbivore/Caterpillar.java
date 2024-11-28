package entity.herbivore;

import entity.Settings;

public class Caterpillar extends Herbivore {
    public Caterpillar() {
        super.setWeight(Settings.weightCaterpillar);
        super.setMaxSpeed(Settings.maxSpeedCaterpillar);
        super.setMaxSatiety(Settings.maxSatietyCaterpillar);
        super.setActualSatiety(Settings.actualSatietyCaterpillar);
        super.setCountOnOneCell(Settings.countCaterpillarOnOneCell);
    }
}
