package entity.animal.herbivore;

import config.Settings;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super.setWeight(Settings.weightRabbit);
        super.setMaxSpeed(Settings.maxSpeedRabbit);
        super.setMaxSatiety(Settings.maxSatietyRabbit);
        super.setActualSatiety(Settings.actualSatietyRabbit);
        super.setCountOnOneCell(Settings.countRabbitOnOneCell);
    }
}
