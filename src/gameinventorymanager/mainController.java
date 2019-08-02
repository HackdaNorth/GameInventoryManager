/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinventorymanager;

import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Conman
 */
public class mainController extends Application {
    Stage primaryStage;
    @Override
    public void start( Stage primaryStage) throws FileNotFoundException, IOException {
        //databaseInteraction data = new databaseInteraction();
        datapage mainPage = new datapage();
        mainPage.buildStage();
        
        

        System.out.println(formattedList());



        //root.getChildren().add(gp);
        primaryStage.setTitle("Game Inventory Manager");
        primaryStage.setScene(mainPage.scene);
        primaryStage.show();
 
    }

    //this takes the arraylist and removes brackets and still working on proper format
    public static String formattedList() {
        int num = 0, pos1 = 0, rows = 0;
        String temp = Arrays.toString(
                databaseInteraction.getGameList().toArray());
        StringBuilder sbTemp = new StringBuilder(temp.replace("[", "").replace("]", ""));
        temp = sbTemp.toString();
        //System.out.println(sbTemp);
        return temp;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
