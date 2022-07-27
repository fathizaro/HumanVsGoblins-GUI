package java.Entities;

import Entities.Items.*;
import Entities.Items.LeatherArmor;
import Environment.GridTiles;
import Events.InputEvent;
import Listeners.EventListener;
import Utils.Colors;
import Utils.Events;
import Utils.ItemTypes;

import java.util.List;

//Human object controlled by the player, implements eventlistener to handle player input
public class Human extends Character implements EventListener<InputEvent> {

    int currentWeapon = 0;
    int currentArmor = 0;

    //Initialize Human with health, strength, defense and accuracy stats
    public Human(int health, int strength, int defense, int accuracy) {
        this.health = health;
        this.strength = strength;
        this.defense = defense;
        this.accuracy = accuracy;

    }

    //Automatically equips best equipment and adjusts stats
    public void autoEquip(List<Item> equipment) {
        for(Item item : equipment) {
            if(item.getType() == ItemTypes.Armor) {
                if(item.getItemValue() > currentArmor) { //Equip armor if armor is better than current armor
                    defense -= currentArmor;
                    currentArmor = item.getItemValue();
                    defense += currentArmor;
                }
            }
            else if(item.getType() == ItemTypes.Weapon) {
                if(item.getItemValue() > currentWeapon) { //Equip weapon if weapon is better than current weapon
                    strength -= currentWeapon;
                    currentWeapon = item.getItemValue();
                    strength += currentWeapon;
                }
            }
        }
    }

    //calls onEnable() method whenever this object is spawned on the map
    @Override
    public void spawn(GridTiles tile) {
        super.spawn(tile);

        onEnable();
    }

    //calls onDisable() method whenever this object is killed
    @Override
    protected void kill() {
        super.kill();

        onDisable();
    }

    //Overrides toString with a yellow "H " to represent Human objects
    @Override
    public String toString() {
        return Colors.ANSI_YELLOW + "H " + Colors.ANSI_RESET;
    }

    //called when InputEvent is triggered, supplies input to movement method
    @Override
    public void onEvent(InputEvent eventType) {
        moveTo(eventType.input);
    }

    //Adds this object to the eventlistener, listening for InputEvent
    private void onEnable() {
        EventListener.EventStartListening(this, Events.InputEvent);
    }

    //Removes this object from eventlistener, no longer listening for InputEvent
    private void onDisable() {
        EventListener.EventStopListening(this, Events.InputEvent);
    }

}