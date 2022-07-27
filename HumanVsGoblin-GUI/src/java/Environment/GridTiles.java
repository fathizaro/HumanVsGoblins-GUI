package java.Environment;

import Entities.GameObject;
import Utils.Colors;
import Utils.Position;
import java.util.Arrays;

//Handles each individual tile on the grid
public class GridTiles {

    private Tiles[][] tile; //Tile data
    private GameObject currentObj; //Occupying Object TODO change to list, implement multiple object occupation (ex: player & item)
    private Position position; //Holds tile position on the grid

    //initializes tile based on supplied tilesize, type and position
    public GridTiles(int size, Tiles type, Position position) {
        //create new tile based on size, may cause logic issues if size is an even number
        tile = new Tiles[size][size];
        this.position = position; //store tile position on grid
        Arrays.stream(tile).forEach(x -> Arrays.fill(x, type)); //fill each tile with the specified tile type
    }

    //returns string representation of the tile in 2D array format
    public String[][] toStringArray() {
        String[][] stringGrid = new String[tile.length][tile.length]; //2D string array to hold string representation of tile data
        //iterate through each element of 2D tile array
        for(int i = 0; i < tile.length; i++) {
            for(int j = 0; j < tile.length; j++){
                stringGrid[i][j] = getTileString(tile[i][j]); //add string representation of tile element to string array
            }
        }

        //Perform object check, represent on the tile if present
        if(currentObj != null) {
            int centerPosition = tile.length / 2;
            //overwrites center of tile data with object's string representation
            stringGrid[centerPosition][centerPosition] = currentObj.toString();
        }

        return stringGrid;
    }

    //position getter
    public Position getPosition() {
        return position;
    }

    //Occupying object setter
    public void setGridObject(GameObject obj) {
        currentObj = obj;
    }

    //Occupying object remover
    public void removeGridObject() {
        currentObj = null;
    }

    //Occupying object getter
    public GameObject getGridObject() {
        return currentObj;
    }

    //bool determines if tile string representation has colors
    private boolean colors = true;

    //colors setter
    public void setColors(boolean colors) {
        this.colors = colors;
    }

    //returns string representation of tile based on tile type
    private String getTileString(Tiles tile) {
        if(colors) {
            return switch (tile) {
                case DIRT -> Colors.ANSI_RED + "+ " + Colors.ANSI_RESET;
                case GRASS -> Colors.ANSI_GREEN + "+ " + Colors.ANSI_RESET;
                case ROCK -> Colors.ANSI_CYAN + "+ " + Colors.ANSI_RESET;
            };
        }
        else
            return "+ ";
    }
}