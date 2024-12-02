package entity.Location;

import entity.Settings;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Island {
    public Cell[][] islandArrays = new Cell[Settings.lengthIsland][Settings.widthIsland];
}
