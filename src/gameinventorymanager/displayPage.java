package gameinventorymanager;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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

    Group rootTwo = new Group();

    Color backgroundBlue = Color.web("#011C42");
    Color goldAccent = Color.web("#FFFFFF");
    Color darkBlueAccent = Color.web("#6EBAB6");
    Color darkGrey = Color.web("#6EBAB6");
    Scene sceneTwo = new Scene(rootTwo, 1400, 900, backgroundBlue);
    Button btnSwitch = new Button("<-- Go Back");

    StackPane displayInfo = new StackPane();
    GridPane textBoxes;

    Label dbName, dbCost, dbDateMade, dbPublisher, dbDatePub, dbDeveloper, dbGenre,
            dbFranchise, dbPlatform, dbMP, dbHoursPlayed, dbLength, dbRating,
            dbDatePurchased, dbAchievements, dbDesc;
  
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        rootTwo.getChildren().clear();
        buildStage();
        primaryStage.setTitle("Current Game:");
        primaryStage.setScene(sceneTwo);
        primaryStage.show();

    }

    public void populateData(Library lB, int pos) throws IOException, ClassNotFoundException {
        int lengthInt;
        String achText, ratingText, campText, hoursText;
        String nameText, costText, descText, pubText, datePubText, devText, genreText, francText, platText, mpText = "";

        nameText = lB.getGames().get(pos).getTitle();
        costText = String.valueOf(lB.getGames().get(pos).getCost());
        descText = lB.getGames().get(pos).getTitle();
        hoursText = String.valueOf(lB.getGames().get(pos).getPosition());
        pubText = lB.getGames().get(pos).getPublisher();
        datePubText = String.valueOf(lB.getGames().get(pos).getDiscription());
        campText = String.valueOf(lB.getGames().get(pos).getCampaign());
        devText = lB.getGames().get(pos).getDeveloper();
        ratingText = String.valueOf(lB.getGames().get(pos).getRating());
        platText = lB.getGames().get(pos).getFranchise();
        genreText = lB.getGames().get(pos).getGenre();
        achText = String.valueOf(lB.getGames().get(pos).getAchievements());

        dbName.setText(nameText);
        dbCost.setText(costText);
        dbDateMade.setText(datePubText);
        dbDesc.setText(descText);
        dbHoursPlayed.setText(hoursText);
        dbPublisher.setText(pubText);
        dbLength.setText(campText);
        dbDeveloper.setText(devText);
        dbRating.setText(ratingText);
        dbPlatform.setText(platText);
        dbGenre.setText(genreText);
        dbAchievements.setText(achText);
    }

    public void buildStage() throws IOException, ClassNotFoundException {
        Library lB = new Library();
        lB.readObject();

        //Stack for information display
        VBox extraInfo = new VBox();

        //background Rec for DisplayInfo
        Rectangle infoRec = new Rectangle(600, 700, goldAccent);
        infoRec.setArcWidth(30.0);
        infoRec.setArcHeight(20.0);

        infoRec.setLayoutX(90);
        infoRec.setLayoutY(90);
        displayInfo.setLayoutX(90);
        displayInfo.setLayoutY(90);

        //Image rec display 
        Rectangle recPicture = new Rectangle(500, 425, darkBlueAccent);
        recPicture.setArcWidth(30.0);
        recPicture.setArcHeight(20.0);
        extraInfo.setLayoutX(800);
        extraInfo.setLayoutY(90);
        extraInfo.getChildren().add(recPicture);

        //creating Metacritic review info
        Rectangle metaRec = new Rectangle(400, 100, darkGrey);
        metaRec.setLayoutX(975);
        metaRec.setLayoutY(540);
        Image imgMeta = new Image("file:Images/metacritic.png");
        ImageView iV = new ImageView(imgMeta);
        iV.setImage(imgMeta);
        iV.setFitHeight(80);
        iV.setFitWidth(300);
        iV.setX(1070);
        iV.setY(550);
        //Creating gameLogo display
        Image imgLogo = new Image("file:Images/Overwatch.png");
        ImageView logoView = new ImageView(imgLogo);
        logoView.setImage(imgLogo);
        logoView.setFitHeight(250);
        logoView.setFitWidth(250);
        logoView.setX(925);
        logoView.setY(180);

        //Metacritic background
        Rectangle reviewBox = new Rectangle(75, 75, darkBlueAccent);
        reviewBox.setX(990);
        reviewBox.setY(550);
        //label "Description" background
        Rectangle recDesc = new Rectangle(200, 50, goldAccent);
        recDesc.setX(750);
        recDesc.setY(550);
        //description paragraph background
        Rectangle descripRec = new Rectangle(625, 200, darkBlueAccent);
        descripRec.setArcWidth(30.0);
        descripRec.setArcHeight(20.0);
        descripRec.setX(750);
        descripRec.setY(675);


        btnSwitch.setPrefWidth(150);
        btnSwitch.setLayoutX(20);
        btnSwitch.setLayoutY(20);

        //Creating info display
        textBoxes = new GridPane();
        textBoxes.setPadding(new Insets(40));
        textBoxes.setHgap(40);
        textBoxes.setVgap(40);

        Label lbName = new Label("Name:");
        dbName = new Label();
        textBoxes.add(lbName, 1, 0);
        textBoxes.add(dbName, 1, 1);
        //dbName.setPromptText("Name...");

        Label lbCost = new Label("Cost:");
        dbCost = new Label();
        textBoxes.add(lbCost, 3, 0);
        textBoxes.add(dbCost, 3, 1);
        //dbCost.setPromptText("Cost...");

        Label lbHoursPlayed = new Label("Hours played:");
        dbHoursPlayed = new Label();
        textBoxes.add(lbHoursPlayed, 1, 8);
        textBoxes.add(dbHoursPlayed, 1, 9);
        //dbHourPlayed.setPromptText("Hours Played...");

        Label lbMP = new Label("Multiplayer:");
        dbMP = new Label("false");
        textBoxes.add(lbMP, 5, 0);
        textBoxes.add(dbMP, 5, 1);
        //dbMP.setPromptText("Multiplayer...");

        Label lbPublisher = new Label("Publisher:");
        dbPublisher = new Label();
        textBoxes.add(lbPublisher, 1, 2);
        textBoxes.add(dbPublisher, 1, 3);
        //dbPublisher.setPromptText("Publisher...");

        Label lbDateMade = new Label("Date Made:");
        dbDateMade = new Label();
        textBoxes.add(lbDateMade, 3, 2);
        textBoxes.add(dbDateMade, 3, 3);
        //dbDateMade.setPromptText("Date Made...");

        Label lbLength = new Label("Length:");
        dbLength = new Label();
        textBoxes.add(lbLength, 3, 8);
        textBoxes.add(dbLength, 3, 9);
        //dbLength.setPromptText("Length...");

        Label lbDeveloper = new Label("Developer:");
        dbDeveloper = new Label();
        textBoxes.add(lbDeveloper, 1, 4);
        textBoxes.add(dbDeveloper, 1, 5);
        //dbDeveloper.setPromptText("Developer...");


        dbRating = new Label();
        dbRating.setLayoutX(990);
        dbRating.setLayoutY(550);

        //dbRating.setPromptText("Rating...");

        Label lbDatePurchased = new Label("Date Purchased:");
        dbDatePurchased = new Label();
        textBoxes.add(lbDatePurchased, 3, 10);
        textBoxes.add(dbDatePurchased, 3, 11);
        //dbDatePurchased.setPromptText("Date Purchased...");

        Label lbPlatform = new Label("Platform:");
        dbPlatform = new Label();
        textBoxes.add(lbPlatform, 1, 10);
        textBoxes.add(dbPlatform, 1, 11);
        //dbPlatform.setPromptText("Platform...");

        Label lbAchievements = new Label("Achievements:");
        dbAchievements = new Label();
        textBoxes.add(lbAchievements, 1, 6);
        textBoxes.add(dbAchievements, 1, 7);
        //dbAchievements.setPromptText("Achievements...");

        Label lbGenre = new Label("Genre:");
        dbGenre = new Label();
        textBoxes.add(lbGenre, 3, 6);
        textBoxes.add(dbGenre, 3, 7);
        //dbGenre.setPromptText("Genre...");

        Label lbDesc = new Label("Description:");
        dbDesc = new Label();
        //lbDesc.setFont(50);
        lbDesc.setLayoutX(820);
        lbDesc.setLayoutY(560);
        dbDesc.setLayoutX(750);
        dbDesc.setLayoutY(675);

        displayInfo.getChildren().clear();
        displayInfo.getChildren().add(textBoxes);
        //adding nodes to scenes
        rootTwo.getChildren().addAll(infoRec, displayInfo, extraInfo, recDesc,
                descripRec, metaRec, iV, reviewBox,
                logoView, lbDesc, btnSwitch, dbRating);
    }
}