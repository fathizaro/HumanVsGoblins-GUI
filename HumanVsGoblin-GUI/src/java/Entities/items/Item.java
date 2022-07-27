package java.Entities.items;
import Events.ItemPickupEvent;
import Entities.GameObject;
import Environment.GridTiles;
import Listeners.EventListener;
import Utils.Events;
import Utils.ItemTypes;
public class Item extends GameObject implements EventListener<ItemPickupEvent> {

    protected ItemTypes itemType;
    protected int itemValue;

    public ItemTypes getType() {
        return itemType;
    }

    public int getItemValue() {
        return itemValue;
    }

    @Override
    public void spawn(GridTiles tile) {
        super.spawn(tile);
        onEnable();
    }
    @Override
    public String toString() {
        return "I ";
    }

    @Override
    public void onEvent(ItemPickupEvent eventType) {

    }

    //Adds this object to the eventlistener, listening for ItemPickupEvent
    private void onEnable() {
        EventListener.EventStartListening(this, Events.ItemPickupEvent);
    }

    //Removes this object from eventlistener, no longer listening for ItemPickupEvent
    private void onDisable() {
        EventListener.EventStopListening(this, Events.ItemPickupEvent);
    }

    public void disableListener() {
        onDisable();
    }

}