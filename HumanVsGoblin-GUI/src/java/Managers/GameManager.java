package java.Managers;


import Entities.Goblin;
import Entities.Human;
import Entities.Items.LongSword;
import Entities.Items.TreasureChest;
import Events.GameEvent;
import Listeners.EventListener;
import Utils.Colors;
import Utils.Config;
import Utils.Events;
import Utils.Position;

//Handles highest level of game management
public class GameManager implements EventListener<GameEvent>{

    //instance variables of all other managers
    private static EventManager eventManager;
    private static GridManager gridManager;
    private static InputManager inputManager;

    //static singleton instance of GameManager
    private static GameManager instance = new GameManager();
    //returns singleton instance
    public static GameManager getInstance() {
        return instance;
    }

    //Player object
    private Human player;

    //Gameloop boolean, terminates program when false
    private boolean running;

    //Initializes instance variables and adds EventListener
    public void init() {
        eventManager = EventManager.getInstance();
        gridManager = GridManager.getInstance();
        inputManager = InputManager.getInstance();

        //Add GameManager to the GameEvent listeners list
        EventListener.EventStartListening(this, Events.GameEvent);
    }

    //runs the gameloop
    public void run() {
        //Display title
        System.out.println(Colors.ANSI_CYAN + "Humans vs Goblins" + Colors.ANSI_RESET);

        //Spawn Player at top left of the map
        player = new Human(Config.playerHealth, Config.playerStrength, Config.playerDefense, Config.playerAccuracy);
        player.spawn(gridManager.getMap().getTileAtPosition(new Position(0, 0)));

        //Spawn Goblins
        Goblin enemy1 = new Goblin(Config.goblinHealth, Config.goblinStrength, Config.goblinDefense, Config.goblinAccuracy);
        enemy1.spawn(gridManager.getMap().getTileAtPosition(new Position(3, 3)));

        Goblin enemy2 = new Goblin(Config.goblinHealth, Config.goblinStrength, Config.goblinDefense, Config.goblinAccuracy);
        enemy2.spawn(gridManager.getMap().getTileAtPosition(new Position(3, 0)));

        Goblin enemy3 = new Goblin(Config.goblinHealth, Config.goblinStrength, Config.goblinDefense, Config.goblinAccuracy);
        enemy3.spawn(gridManager.getMap().getTileAtPosition(new Position(1, 4)));

        //Run the game loop while true
        running = true;
        while(running)
        {
            gridManager.displayMap(); //display map and objects to terminal
            System.out.println(Colors.ANSI_CYAN + "Controls: W - Move Up, S - Move Down, A - Move Left, D - Move Right, Q - Quit Game" + Colors.ANSI_RESET);
            System.out.print(Colors.ANSI_CYAN + "Enter command: " + Colors.ANSI_RESET);
            inputManager.getInput(); //wait for user input
        }
    }

    //Player Getter
    public Human getPlayer() {
        return player;
    }

    //GameEvent listener terminates the gameloop and exits the program when triggered
    @Override
    public void onEvent(GameEvent eventType) {
        if(eventType.name.equals("End Game")){
            running = false;
        }
    }
}