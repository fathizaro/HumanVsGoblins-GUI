package java.Entities;

import Entities.Items.Item;
import Environment.GridTiles;
import Events.DamageEvent;
import Events.ItemPickupEvent;
import Managers.GridManager;
import Utils.Inputs;
import Utils.Position;

public class Character extends GameObject {
    protected int health; //will activate the kill() method when set to 0 or below
    protected int strength; //determines range of damage rolls during combat, minimum range of 20% current value
    protected int accuracy; //determines likelyhood of hitting target during combat, guaranteed at 100 or above
    protected int defense; //subtracts its value from any incoming damage amount. Reduces damage to 0 if higher than damage

    //handles combat upon given target initiated by the instigator
    public void attack(Character target, Character instigator) {
        int damage = rollDamage(target, instigator); //gets randomized damage value, -1 if attack missed
        if(damage > 0) //Only changes health if incoming damage > 0
            target.setHealth(target.getHealth() - strength);

        DamageEvent.Trigger(target, instigator, strength); //Triggers damage event for all listeners

        //Temporary combat results, to be implemented using DamageEvent listeners
        System.out.println(instigator.toString() + "attacked " + target.toString() + "for " + damage + " damage");

    }

    //handles combat damage randomization, returns -1 if attack missed
    private int rollDamage(Character target, Character instigator) {
        double hitChance = Math.random() * 100; //hit chance range 0 - 100
        //attack misses and returns -1 if hitchance roll is greater than attacking character's accuracy
        if(hitChance > instigator.accuracy)
            return -1;

        //rolls damage value between  20% of attacker's strength  to  100% of attacker's strength
        double damage = Math.max(Math.random() * instigator.strength, instigator.strength * 0.2);
        //returns damage after subtracting target's defense, min value of 0 to avoid healing
        return Math.max((int)damage - target.defense, 0);
    }

    //handles character movement inputs, calls context actions based on destination tile
    protected void moveTo(Inputs input) {
        int newX = posX, newY = posY; //holds position of new destination based on input

        //increments/decrements position variables based on input direction
        switch (input) {
            case MOVE_UP -> newY--;
            case MOVE_DOWN -> newY++;
            case MOVE_LEFT -> newX--;
            case MOVE_RIGHT -> newX++;
        }

        //Calls context actions on destination tile
        contextAction(GridManager.getInstance().getMap().getTileAtPosition(new Position(newY, newX)));

    }

    //handles context actions, does nothing if no tile exists, moves if tile is unoccupied, attacks if character present
    private void contextAction(GridTiles destination) {
        if(destination == null) {
            return; //does nothing when destination tile is null
        }


        if(destination.getGridObject() == null) //check if destination is unoccupied
            move(destination); //moves to unoccupied destination
        else if(destination.getGridObject() instanceof Character) //check if another character is occupying destination
            attack((Character)destination.getGridObject(), this); //attack if character is present
        else if(destination.getGridObject() instanceof Item) { //check if item is occupying destination
            ItemPickupEvent.Trigger((Item)destination.getGridObject()); //trigger itempickup event
            move(destination); //move to destination, overwriting item occupation
        }

    }

    //handles movement to supplied destination
    private void move(GridTiles destination) {
        destination.setGridObject(this); //occupies destination with this object
        currentTile.removeGridObject(); //removes object from previous location
        currentTile = destination; //set current tile to destination
        //update position variables
        posX = destination.getPosition().posX();
        posY = destination.getPosition().posY();

    }

    //returns character object's curent health
    public int getHealth() {
        return health;
    }

    //sets character object's health, kills character if health set to 0 or lower
    public void setHealth(int newHealth) {
        health = newHealth;
        if(health <= 0) {
            health = 0;
            kill();
        }
    }

    //removes character from map on death
    protected void kill() {
        currentTile.removeGridObject();
    }
}