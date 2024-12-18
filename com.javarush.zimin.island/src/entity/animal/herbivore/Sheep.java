package entity.animal.herbivore;


import config.Settings;
public class Sheep extends Herbivore {

    public Sheep() {
        super.setWeight(Settings.weightSheep);
        super.setMaxSpeed(Settings.maxSpeedSheep);
        super.setMaxSatiety(Settings.maxSatietySheep);
        super.setActualSatiety(Settings.actualSatietySheep);
        super.setCountOnOneCell(Settings.countSheepOnOneCell);
    }
}
