package java.Entities;

import Entities.Items.TreasureChest;
import Utils.Colors;

public class Goblin extends Character{

    //Initialize goblin with health, strength, defense and accuracy stats
    public Goblin(int health, int strength, int defense, int accuracy) {
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.accuracy = accuracy;
    }

    //Overrides toString with a red "G " to represent goblin objects
    @Override
    public String toString() {
        return Colors.ANSI_RED + "G " + Colors.ANSI_RESET;
    }

    @Override
    protected void kill() {
        super.kill();

        TreasureChest tc = new TreasureChest();
        tc.spawn(currentTile);
    }
}