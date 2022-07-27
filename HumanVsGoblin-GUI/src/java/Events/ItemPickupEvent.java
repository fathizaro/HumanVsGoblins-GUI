package java.Events;

import Entities.Items.Item;
import Managers.EventManager;
import Utils.Events;

public class ItemPickupEvent {
    public Item item;

    //Initialize with user input
    public ItemPickupEvent(Item item) {
        this.item = item;
    }

    //Static Event Object
    public static ItemPickupEvent e;

    //called to trigger this event
    public static void Trigger(Item item) {
        e = new ItemPickupEvent(item);
        EventManager.TriggerEvent(e, Events.ItemPickupEvent);
    }
}