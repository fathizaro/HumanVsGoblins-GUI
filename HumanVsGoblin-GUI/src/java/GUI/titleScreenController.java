package java.GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class titleScreenController {

    @FXML
    private ImageView exit;

    @FXML
    private AnchorPane root;

    @FXML
    private ImageView startGame;

    @FXML
    void exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    void startGame(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/screens/gameScreen.fxml"));
        AnchorPane pane= fxmlLoader.load();
        root.getChildren().setAll(pane);
    }

}