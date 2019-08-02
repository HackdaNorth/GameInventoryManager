package gameinventorymanager;

import static gameinventorymanager.mainController.formattedList;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Conman
 */
public class datapage extends mainController {

    TextField tf;
    Group root = new Group();
    HBox pane = new HBox();
    Color backgroundColor = Color.web("#FBDF55");
    Color blueAccent = Color.web("#669CF5");
    Scene scene = new Scene(root, 1400, 900, backgroundColor);

    public void buildStage() throws IOException {
        databaseInteraction data = new databaseInteraction();

        root.getChildren().add(pane);

        //new textFields for the inventory search.
        StackPane userOptions = new StackPane();
        userOptions.setLayoutX(600);
        userOptions.setLayoutY(50);

        GridPane textBoxes = new GridPane();
        textBoxes.setPadding(new Insets(10));
        textBoxes.setHgap(10);
        textBoxes.setVgap(10);

        Image imgLogo = new Image("Images/Capture3.PNG");

        //Image imgLogo = new Image();
        ImageView iV = new ImageView(imgLogo);
        iV.setImage(imgLogo);
        iV.setFitHeight(300);
        iV.setFitWidth(300);
        iV.setY(50);
        iV.setX(100);

        root.getChildren().add(iV);

        Rectangle rec1 = new Rectangle(650, 300, blueAccent);
        rec1.setY(50);
        rec1.setX(600);
        userOptions.getChildren().add(rec1);
        root.getChildren().add(userOptions);

        StackPane listDisplay = new StackPane();
        Rectangle rec2 = new Rectangle(1200, 450, blueAccent);
        rec2.setY(430);
        rec2.setX(100);
        listDisplay.getChildren().add(rec2);

        Button btn = new Button();
        btn.setText("OK");

        Button btnTest = new Button();
        btn.setText("OKTest");

        Button btnSearch = new Button();
        btnSearch.setText("Search");
        btnSearch.setLayoutX(100);
        btnSearch.setLayoutY(400);

        tf = new TextField();
        tf.setPromptText("Search...");
        tf.setLayoutX(160);
        tf.setLayoutY(400);
        root.getChildren().add(tf);

        TextField dbName = new TextField();
        Label lbName = new Label("Name:");
        textBoxes.add(lbName, 1, 0);
        textBoxes.add(dbName, 1, 1);
        dbName.setPromptText("Name...");

        Label lbCost = new Label("Cost:");
        TextField dbCost = new TextField();
        textBoxes.add(lbCost, 2, 0);
        textBoxes.add(dbCost, 2, 1);
        dbCost.setPromptText("Cost...");

        Label lbHoursPlayed = new Label("Hours played:");
        TextField dbHourPlayed = new TextField();
        textBoxes.add(lbHoursPlayed, 3, 0);
        textBoxes.add(dbHourPlayed, 3, 1);
        dbHourPlayed.setPromptText("Hours Played...");

        Label lbMP = new Label("Multiplayer");
        TextField dbMP = new TextField();
        textBoxes.add(lbMP, 4, 0);
        textBoxes.add(dbMP, 4, 1);
        dbMP.setPromptText("Multiplayer...");

        Label lbPublisher = new Label("Publisher");
        TextField dbPublisher = new TextField();
        textBoxes.add(lbPublisher, 1, 2);
        textBoxes.add(dbPublisher, 1, 3);
        dbPublisher.setPromptText("Publisher...");

        Label lbDateMade = new Label("Date Made");
        TextField dbDateMade = new TextField();
        textBoxes.add(lbDateMade, 2, 2);
        textBoxes.add(dbDateMade, 2, 3);
        dbDateMade.setPromptText("Date Made...");

        Label lbLength = new Label("Length");
        TextField dbLength = new TextField();
        textBoxes.add(lbLength, 3, 2);
        textBoxes.add(dbLength, 3, 3);
        dbLength.setPromptText("Length...");

        Label lbDeveloper = new Label("Developer");
        TextField dbDeveloper = new TextField();
        textBoxes.add(lbDeveloper, 1, 4);
        textBoxes.add(dbDeveloper, 1, 5);
        dbDeveloper.setPromptText("Developer...");

        Label lbRating = new Label("Rating");
        TextField dbRating = new TextField();
        textBoxes.add(lbRating, 2, 4);
        textBoxes.add(dbRating, 2, 5);
        dbRating.setPromptText("Rating...");

        Label lbDatePurchased = new Label("Date Purchased");
        TextField dbDatePurchased = new TextField();
        textBoxes.add(lbDatePurchased, 3, 4);
        textBoxes.add(dbDatePurchased, 3, 5);
        dbDatePurchased.setPromptText("Date Purchased...");

        Label lbAchievements = new Label("Achievements");
        TextField dbAchievements = new TextField();
        textBoxes.add(lbAchievements, 1, 6);
        textBoxes.add(dbAchievements, 1, 7);
        dbAchievements.setPromptText("Achievements...");

        Label lbGenre = new Label("Genre");
        TextField dbGenre = new TextField();
        textBoxes.add(lbGenre, 2, 6);
        textBoxes.add(dbGenre, 2, 7);
        dbGenre.setPromptText("Genre...");

        Label lbPlatform = new Label("Platform");
        TextField dbPlatform = new TextField();
        textBoxes.add(lbPlatform, 3, 6);
        textBoxes.add(dbPlatform, 3, 7);
        dbPlatform.setPromptText("Platform...");

        TextArea displayData = new TextArea(formattedList());
        listDisplay.getChildren().add(displayData);

        listDisplay.setLayoutX(100);
        listDisplay.setLayoutY(430);

        root.getChildren().add(listDisplay);
        userOptions.getChildren().add(textBoxes);
        root.getChildren().add(btn);
        root.getChildren().add(btnSearch);

        tf.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
//        btnTest.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                try {
//                    System.out.println(databaseInteraction.grabDataCell());
//                    //System.out.println(databaseInteraction.getGameList());
//                } catch (IOException ex) {
//                    Logger.getLogger(GameInventoryManager.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (data.dataBaseSearch(tf.getText()) == true) {
                        System.out.println("found");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyword = tf.getText();
                try {
                    if (data.dataBaseSearch(keyword) == true) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    public TextField getTextField() {
        return tf;
    }

    public Group getGroup() {
        return root;
    }
}
