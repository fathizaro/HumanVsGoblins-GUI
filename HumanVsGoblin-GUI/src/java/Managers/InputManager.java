package java.Managers;


import Events.GameEvent;
import Events.InputEvent;
import Utils.Inputs;

import java.util.Scanner;

//Handles user input
public class InputManager {

    //static singleton instance of InputManager
    private static InputManager instance = new InputManager();
    //returns singleton instance
    public static InputManager getInstance() {
        return instance;
    }

    private Scanner inputReader; //scanner object for reading user input

    //Initialize scanner object to read from System.in
    private InputManager() {
        inputReader = new Scanner(System.in);
    }

    //Retreives and validates user input, triggers events corresponding to valid input
    public void getInput() {
        String input;
        boolean invalid = false; //input validation bool
        do {
            input = inputReader.nextLine();
            //Triggers events based on user input, loops until input is valid
            switch (input.toLowerCase().charAt(0)) {
                case 'w' -> {
                    InputEvent.Trigger(Inputs.MOVE_UP);
                    invalid = false;
                }
                case 'a' -> {
                    InputEvent.Trigger(Inputs.MOVE_LEFT);
                    invalid = false;
                }
                case 's' -> {
                    InputEvent.Trigger(Inputs.MOVE_DOWN);
                    invalid = false;
                }
                case 'd' -> {
                    InputEvent.Trigger(Inputs.MOVE_RIGHT);
                    invalid = false;
                }
                case 'q' -> {
                    GameEvent.Trigger("End Game");
                    invalid = false;
                }
                default -> {
                    invalid = true;
                    System.out.println("Invalid entry");
                }
            }
        }while (invalid);
    }
}
