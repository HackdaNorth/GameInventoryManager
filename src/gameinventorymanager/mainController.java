/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinventorymanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
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
