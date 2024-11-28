package entity;


public class Plant extends Entity implements Runnable {
    public static int weight = 1;
    public static int count = 0;
    volatile int maxCountPlant = 200;

    Cell cell;

    public Plant(Cell cell) {
        this.cell = cell;
    }
    public static int getCount() {
        return count;
    }

    @Override
    public void run() {
        int countPlant = cell.queueEntity.stream().filter(c -> c instanceof Plant).map(c -> (Plant) c).toList().size();
        if (countPlant >= maxCountPlant){
            return;
        }
        count++;
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
        cell.queueEntity.add(new Plant(cell));
    }
}
