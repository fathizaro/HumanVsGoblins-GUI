package java.Entities.items;

import Events.ItemPickupEvent;
import Managers.InventoryManager;

//Treasure chest gives a random item when picked up
public class TreasureChest extends Item{

    @Override
    public String toString() {
        return "T ";
    }

    //On pickup event, randomly adds a sword or armor to inventory
    @Override
    public void onEvent(ItemPickupEvent eventType) {
        super.onEvent(eventType);
        int roll = (int)(Math.random() * 100);
        if(roll < 50)
            InventoryManager.getInstance().addItem(new LongSword());
        else
            InventoryManager.getInstance().addItem(new LeatherArmor());
    }
}