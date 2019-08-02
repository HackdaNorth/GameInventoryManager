

package gameinventorymanager;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Conman
 */
public class displayPage extends mainController{

    TextField tf;
    Group root = new Group();
    HBox pane = new HBox();
    Color backgroundColor = Color.web("#FBDF55");
    Color blueAccent = Color.web("#669CF5");
    Scene scene = new Scene(root, 1400, 900, backgroundColor);
    public void buildStage() {
        
    }
}
