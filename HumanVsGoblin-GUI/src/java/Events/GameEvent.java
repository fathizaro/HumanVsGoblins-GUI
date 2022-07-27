package java.Events;

import Managers.EventManager;
import Utils.Events;

//Event triggered for specific game events
//Event name: "Game End" terminates game loop
public class GameEvent {
    public String name;

    //Initialize with event name
    public GameEvent (String name) {
        this.name = name;
    }

    //Static Event Object
    static GameEvent e;

    //called to trigger this event
    public static void Trigger(String name) {
        e = new GameEvent(name);
        EventManager.TriggerEvent(e, Events.GameEvent);
    }
}