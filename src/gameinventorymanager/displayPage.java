package gameinventorymanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Conman
 */
public class displayPage extends mainController {

    TextField tf;
    Group rootTwo = new Group();
    HBox pane = new HBox();
    Color backgroundColor = Color.web("#FBDF55");
    Color blueAccent = Color.web("#669CF5");
    Scene sceneTwo;

    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        buildStage();
        primaryStage.setTitle("Current Game:");
        primaryStage.setScene(sceneTwo);
        primaryStage.show();
    }

    public void buildStage() {
        sceneTwo = new Scene(rootTwo, 1400, 900, backgroundColor);
    }
}
