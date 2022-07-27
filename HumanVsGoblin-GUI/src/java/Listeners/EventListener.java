package java.Listeners;

import Managers.EventManager;
import Utils.Events;

//Handles EventListener functionality when implemented
public interface EventListener<T> extends EventListenerBase {
    void onEvent(T eventType); //Called by the listening object when event is triggered

    //Adds object and event it is listening for to the EventListener list
    static <T> void EventStartListening(EventListener<T> caller, Events eventName) {
        EventManager.AddListener(caller, eventName);
    }
    //Removes object and event it is listening for to the EventListener list
    static <T> void EventStopListening(EventListener<T> caller, Events eventName) {
        EventManager.RemoveListener(caller, eventName);
    }
}