package java.Managers;

import Entities.Items.Item;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {

    //static singleton instance of InventoryManager
    private static InventoryManager instance = new InventoryManager();
    //returns singleton instance
    public static InventoryManager getInstance() {
        return instance;
    }

    //Holds a list of all equipment in inventory
    private List<Item> equipmentList;

    //Initialize equipment list
    private InventoryManager() {
        equipmentList = new ArrayList<>();
    }

    //Add item to equipmentList and run autoequip on player
    public void addItem(Item item) {
        equipmentList.add(item);
        item.disableListener();
        GameManager.getInstance().getPlayer().autoEquip(equipmentList);

    }

    //Returns equipment list
    public List<Item> getEquipment() {
        return equipmentList;
    }
}