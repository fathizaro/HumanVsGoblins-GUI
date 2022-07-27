package java.GUI;

import Utils.Position;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {

    private static final int WIDTH = 752;
    private static final int HEIGHT = 720;

    private static final int PLAYER_HEIGHT = 25;
    private static final int PLAYER_WIDTH = 15;
    private Position playerTransform;

    private static final int GOBLIN_HEIGHT = 25;
    private static final int GOBLIN_WIDTH = 15;
    private Position goblinTransform;

    boolean running = true;

    @Override
    public void start(Stage stage) throws IOException {

        Parent titleScreen = FXMLLoader.load(getClass().getResource("/screens/titleScreen.fxml"));

        Scene scene = new Scene(titleScreen, WIDTH, HEIGHT);
        stage.setTitle("Humans Vs Goblins");
        stage.setScene(scene);
        stage.show();
    }

    public static void launchApp() {
        launch();
    }
}