package java.Managers;


import Environment.Grid;
import Utils.Config;

//Handles map setup
public class GridManager {

    //static singleton instance of GridManager
    private static GridManager instance = new GridManager();
    //returns singleton instance
    public static GridManager getInstance() {
        return instance;
    }

    //Holds map data
    private Grid map;

    private int tileSize = Config.tileSize; //Size of each individual tile, may cause logic errors when using even numbers
    private int mapSizeX = Config.gridSizeX; //Size of grid on X axis
    private int mapSizeY = Config.gridSizeY; //Size of grid on Y axis

    //Generates new map based on config settings
    private GridManager() {
        map = new Grid(mapSizeX, mapSizeY, tileSize);
    }

    //returns map object
    public Grid getMap() { return map;}

    //displays string representation of map and occupying objects to terminal
    public void displayMap() {
        map.displayMap();
    }
}