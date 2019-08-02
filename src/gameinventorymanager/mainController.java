/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinventorymanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

/**
 *
 * @author Conman
 */
public class mainController extends Application {

    Stage secondaryStage;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        datapage mainPage = new datapage();
        displayPage secondPage = new displayPage();

        mainPage.start(primaryStage);
        //display secondPage
        //this is an example of how to switch between stages. You can cut and paste this method in order to switch.
        //It takes the secondary stage form displayPage.
        mainPage.btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("working");
                try {
                    secondPage.start(primaryStage);
                } catch (IOException ex) {
                    Logger.getLogger(datapage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    //this takes the arraylist and removes brackets and still working on proper format
    public static String formattedList() {
        int num = 0, pos1 = 0, rows = 0;
        String temp = Arrays.toString(
                databaseInteraction.getGameList().toArray());
        String sbTemp = temp.replace("[", "").replace("]", "");
        temp = sbTemp;
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
