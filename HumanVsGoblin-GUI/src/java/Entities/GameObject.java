package java.Entities;
import Environment.GridTiles;

//Abstract parent class of all spawnable objects within the game environment
public abstract class GameObject {

    //Holds the instance of GridTile the GameObject is located in
    //and X,Y position of the tile
    protected GridTiles currentTile;
    protected int posX;
    protected int posY;

    //Spawns the GameObject on supplied tile
    public void spawn(GridTiles tile) {
        tile.setGridObject(this);
        currentTile = tile;
        posX = tile.getPosition().posX();
        posY = tile.getPosition().posY();
    }

    //toString method to be overrided with each object's string representation
    public String toString() {
        return "C";
    }
}
