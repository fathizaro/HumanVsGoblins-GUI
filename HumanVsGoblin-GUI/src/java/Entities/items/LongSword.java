package java.Entities.items;

import Events.ItemPickupEvent;
import Managers.InventoryManager;
import Utils.Config;
import Utils.ItemTypes;

//Longsword item object increases player strength when picked up
public class LongSword extends Item{

    private int damageValue = Config.LongSwordDamage;

    //Initialize item properties with longsword values
    public LongSword() {
        itemType = ItemTypes.Weapon;
        itemValue = damageValue;
    }
    @Override
    public String toString() {
        return "S ";
    }

    //Add this item to inventory when pickup event triggered
    @Override
    public void onEvent(ItemPickupEvent eventType) {
        super.onEvent(eventType);
        InventoryManager.getInstance().addItem(this);
    }

}