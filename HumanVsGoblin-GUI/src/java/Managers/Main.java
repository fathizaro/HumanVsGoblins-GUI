package java.Managers;


public class Main {
    public static void main(String[] args) {

        //Gets singleton instance of GameManager
        GameManager gm = GameManager.getInstance();
        //Initializes GameManager
        gm.init();

        //gm.run();

        GUI.Application.launchApp();
    }
}