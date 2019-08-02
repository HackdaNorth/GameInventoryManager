package gameinventorymanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Conman
 */
public class displayPage extends mainController {

    TextField tf;
    Group rootTwo = new Group();
    HBox pane = new HBox();
    Color backgroundBlue = Color.web("#0086FF");
    Color goldAccent = Color.web("#FFAA00");
    Color darkBlueAccent = Color.web("#2D59BF");
    Scene sceneTwo;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        buildStage();
        Scene sceneTwo = new Scene(rootTwo, 1400, 900, backgroundBlue);
        primaryStage.setTitle("Current Game:");
        primaryStage.setScene(sceneTwo);
        primaryStage.show();
    }

    public void buildStage() {
        StackPane displayInfo = new StackPane();
        VBox extraInfo = new VBox();

        //background Rec for DisplayInfo
        Rectangle rec1 = new Rectangle(600, 700, goldAccent);
        rec1.setArcWidth(30.0);
        rec1.setArcHeight(20.0);
        displayInfo.setLayoutX(90);
        displayInfo.setLayoutY(90);
        displayInfo.getChildren().add(rec1);

        Rectangle rec2 = new Rectangle(500, 425, darkBlueAccent);
        rec2.setArcWidth(30.0);
        rec2.setArcHeight(20.0);

        extraInfo.setLayoutX(800);
        extraInfo.setLayoutY(90);

        

        Rectangle metaRec = new Rectangle(400, 100, goldAccent);
        Image imgMeta = new Image("Images/metacritic.png");
        //Image imgLogo = new Image();
        ImageView iV = new ImageView(imgMeta);
        iV.setImage(imgMeta);
        iV.setFitHeight(80);
        iV.setFitWidth(300);
        iV.setX(1070);
        iV.setY(560);
        
        //reviewRec.getChildren().addAll(metaRec, iV);   
        metaRec.setLayoutX(975);
        metaRec.setLayoutY(550);

        Rectangle recDesc = new Rectangle(200, 50, goldAccent);
        recDesc.setArcWidth(30.0);
        recDesc.setArcHeight(20.0);
        recDesc.setX(750);
        recDesc.setY(550);

        Rectangle descripRec = new Rectangle(625, 200, darkBlueAccent);
        descripRec.setArcWidth(30.0);
        descripRec.setArcHeight(20.0);
        descripRec.setX(750);
        descripRec.setY(675);

        TextField tfSearch = new TextField();
        tfSearch.setPromptText("Search...");
        tfSearch.setPrefWidth(300);
        tfSearch.setLayoutX(150);
        tfSearch.setLayoutY(825);

        Button btnSearch = new Button("Search");
        btnSearch.setPrefWidth(100);
        btnSearch.setLayoutX(455);
        btnSearch.setLayoutY(825);

  

        //adding nodes to scenes
        extraInfo.getChildren().add(rec2);
        rootTwo.getChildren().addAll(displayInfo, extraInfo, recDesc, 
                descripRec, tfSearch, btnSearch, metaRec, iV);

    }
}
