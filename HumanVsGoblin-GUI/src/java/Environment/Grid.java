package java.Environment;


import Utils.Position;

import java.util.Arrays;

//Handles grid generation and display
public class Grid {

    private GridTiles[][] map; //Holds a grid of tile objects
    private int tileSize; //Size of individual tiles, odd numbers recommended
    private int sizeX; //size of grid along X axis
    private int sizeY; //size of grid along Y axis

    //Initializes grid and fills with grass tiles TODO implement other tiles
    public Grid(int sizeX, int sizeY, int tileSize) {
        this.tileSize = tileSize;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        map = new GridTiles[sizeY][sizeX]; //initialize grid
        for(int i = 0; i < sizeY; i++) {
            for(int j = 0; j < sizeX; j++) {
                map[i][j] = new GridTiles(tileSize, Tiles.GRASS, new Position(i, j)); //fill grid with tiles
            }
        }
    }

    //returns a tile at given position, returns null if position is invalid
    public GridTiles getTileAtPosition(Position pos) {
        try {
            return map[pos.posY()][pos.posX()];
        }
        catch(IndexOutOfBoundsException e) {
            return null;
        }
    }

    //displays grid to the terminal
    public void displayMap() {
        int displaySize = map.length * tileSize; //size required to display each character
        String[] mapString = new String[displaySize]; //string array holds horizontal lines of tile data in each element
        Arrays.fill(mapString, "");

        //Iterate through each grid tile
        for(int i = 0; i < sizeY; i++) {
            for(int j = 0; j < sizeX; j++) {
                String[][] currentTile = map[i][j].toStringArray(); //load tile data of the grid tile
                //Iterate through each tile element
                for(int k = 0; k < tileSize; k++) {
                    for(int l = 0; l < tileSize; l++){
                        mapString[i*tileSize + k] += currentTile[k][l]; //add tile string representation to display string
                    }
                }
            }
        }

        //Iterate through each line of the display string
        for (String s : mapString) {
            System.out.println(s); //display line
        }
    }
}