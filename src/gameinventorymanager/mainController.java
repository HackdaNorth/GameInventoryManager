/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameinventorymanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

/**
 *
 * @author Conman
 */
public class mainController extends Application {

    Stage secondaryStage;

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException, ClassNotFoundException {
        datapage mainPage = new datapage();
        displayPage secondPage = new displayPage();

        //loads mainStage
        mainPage.start(primaryStage);
       
        //this is an example of how to switch between stages. You can cut and paste this method in order to switch.
        //It takes the secondary stage form displayPage.
        mainPage.btnSearch.setOnAction((ActionEvent event) -> {
            String keyword = mainPage.tf.getText();
            try {
                Library lB = new Library();
                lB.readObject();
                if (lB.getSearch(keyword, lB) == 0) {
                    System.out.println("No game Found!");
                } else {
                    int gamePos = lB.getSearch(keyword, lB);
                    secondPage.start(primaryStage);
                    secondPage.populateData(lB, gamePos);

                    secondPage.displayInfo.getChildren().clear();
                    secondPage.displayInfo.getChildren().add(secondPage.textBoxes);
                    System.out.println("true");
                }
            } catch (IOException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(displayPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        mainPage.removeGame.setOnAction((ActionEvent event) -> {
            String keyword = mainPage.tf.getText();
            try {
                Library lB = new Library();
                lB.readObject();
                if (lB.getSearch(keyword, lB) == 0) {
                    System.out.println("No game Found!");
                } else {
                    int gamePos = lB.getSearch(keyword, lB);
                    lB.games.remove(gamePos);
                    lB.writeObject(lB.games);
                }
            } catch (IOException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(displayPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        secondPage.btnSwitch.setOnAction((ActionEvent event) -> {
            System.out.println("back to main");
            try {
                mainPage.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
