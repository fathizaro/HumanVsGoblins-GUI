package java.Managers;

import Listeners.EventListener;
import Listeners.EventListenerBase;
import Utils.Events;

import java.util.*;

//Handles listening and triggering of events
public class EventManager{

    //list of all active event listeners
    private static Map<Events, List<EventListenerBase>> listenersList;

    //static singleton instance of EventManager
    private static EventManager instance = new EventManager();

    //returns instance
    public static EventManager getInstance() {
        return instance;
    }

    //initializes EventListener list on creation
    private EventManager() {
        listenersList = new HashMap<>();
    }

    //Adds an event listener
    public static <Even> void AddListener(EventListener<Even> e, Events eName) {

        //Check if listener contains a list of listeners for the corresponding event
        if(!listenersList.containsKey(eName)) {
            listenersList.put(eName, new ArrayList<>()); //create new list for the event
        }

        //Check if event's list of listeners contains added listener
        if(!listenersList.get(eName).contains(e)) {
            listenersList.get(eName).add(e);
        }
    }

    //Removes an event listener
    public static <Event> void RemoveListener(EventListener<Event> e, Events eName) {

        //Exit if list does not contain a list for the supplied event
        if(!listenersList.containsKey(eName)){
            return;
        }

        //Get the list of listeners for corresponding event
        List<EventListenerBase> listenList = listenersList.get(eName);

        //Iterate through listeners and remove the event that matches
        for(EventListenerBase event : listenList) {
            if(event == e) {
                listenList.remove(event);
            }
            if(listenList.size() == 0) {
                listenersList.remove(eName); //remove list if empty
            }
        }
    }

    //Triggers events for each active eventlistener for the corresponding event
    public static <E> void TriggerEvent(E e, Events eName){

        //Do nothing if there are no listeners for the event
        if(!listenersList.containsKey(eName)){
            return;
        }

        //Get list of listeners for the event
        List<EventListenerBase> eventList = listenersList.get(eName);

        //Iterate through listeners and run their onEvent methods
        for(EventListenerBase event : eventList){
            EventListener<E> eventChild = (EventListener<E>) event;
            eventChild.onEvent(e);
        }
    }
}


