package java.Entities.items;

import java.Events.ItemPickupEvent;
import Managers.InventoryManager;
import Utils.Config;
import Utils.ItemTypes;

//Longsword item object increases player strength when picked up
public class LeatherArmor extends Item{

    private int defenseValue = Config.LeatherArmorDefense;

    //Initialize item properties with longsword values
    public LeatherArmor() {
        itemType = ItemTypes.Armor;
        itemValue = defenseValue;
    }

    @Override
    public String toString() {
        return "A ";
    }

    //Add this item to inventory when pickup event triggered
    @Override
    public void onEvent(ItemPickupEvent eventType) {
        super.onEvent(eventType);
        InventoryManager.getInstance().addItem(this);
    }
}
