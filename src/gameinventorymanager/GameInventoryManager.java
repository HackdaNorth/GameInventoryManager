/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinventorymanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Conman
 */
public class GameInventoryManager extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Group root = new Group();
        HBox pane = new HBox();
        Scene scene = new Scene(root, 1400, 900, Color.LIGHTSALMON);

        root.getChildren().add(pane);

        Image imgLogo = new Image("Images/Capture.PNG");

        //Image imgLogo = new Image();
        ImageView iV = new ImageView(imgLogo);
        iV.setImage(imgLogo);
        iV.setFitHeight(300);
        iV.setFitWidth(360);
        iV.setY(50);
        iV.setX(100);

        root.getChildren().add(iV);

        Rectangle rec1 = new Rectangle(650, 300, Color.LIGHTSKYBLUE);
        rec1.setY(50);
        rec1.setX(600);
        root.getChildren().add(rec1);

        Rectangle rec2 = new Rectangle(1200, 450, Color.LIGHTSKYBLUE);
        rec2.setY(430);
        rec2.setX(100);
        root.getChildren().add(rec2);

        Button btn = new Button();
        btn.setText("OK");
     
        Button btnSearch = new Button();
        btnSearch.setText("Search");
        btnSearch.setLayoutX(100);
        btnSearch.setLayoutY(400);

        TextField tf = new TextField();
        tf.setPromptText("Search...");
        tf.setLayoutX(160);
        tf.setLayoutY(400);
        root.getChildren().add(tf);

//        tf.onAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                
//            }        
//        });
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("OK Button clicked!");
            }
        });

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String userSearch = tf.getText();
                
                
            }
        });

        root.getChildren().add(btn);
        root.getChildren().add(btnSearch);

        //root.getChildren().add(gp);
        primaryStage.setTitle("Game Inventory Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
