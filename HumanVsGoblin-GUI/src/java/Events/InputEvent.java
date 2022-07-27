package java.Events;


import Utils.Events;
import Utils.Inputs;
import Managers.EventManager;

//Event triggered upon receiving user input
public class InputEvent{
    public Inputs input;

    //Initialize with user input
    public InputEvent (Inputs input) {
        this.input = input;
    }

    //Static Event Object
    public static InputEvent e;

    //called to trigger this event
    public static void Trigger(Inputs input) {
        e = new InputEvent(input);
        EventManager.TriggerEvent(e, Events.InputEvent);
    }
}