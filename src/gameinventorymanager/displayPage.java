package gameinventorymanager;

import java.io.FileNotFoundException;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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


    Group rootTwo = new Group();

    Color backgroundBlue = Color.web("#0086FF");
    Color goldAccent = Color.web("#FFAA00");
    Color darkBlueAccent = Color.web("#2D59BF");
    Color darkGrey = Color.web("#9E9F9F");
    Scene sceneTwo = new Scene(rootTwo, 1400, 900, backgroundBlue);
    Button btnSwitch = new Button("Switch Scene");

    double costDouble, achivDouble, ratingDouble = 00, campDouble = 00.0, hoursDouble = 0.0;
    int lengthInt = 0;
    Label dbName, dbCost;
    Library lB;

    public void displayPage() throws IOException {
        lB = new Library();
        lB.games = lB.getGames();
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException, ClassNotFoundException {
        rootTwo.getChildren().clear();
        buildStage();    
        primaryStage.setTitle("Current Game:");
        primaryStage.setScene(sceneTwo);
        primaryStage.show();

    }

    public void populateData(Library lB) throws IOException {
        String nameText, costText, descText, pubText, datePubText, devText, genreText, francText, platText, mpText = "";

        //nameText = lB.getGames().get(lB.getGamePos()).getTitle();
        //costText = String.valueOf(lB.getGames().get(lB.getGamePos()).getCost());

        dbName.setText("");
        //dbCost.setText("99.00");

        hoursDouble = lB.getGames().get(lB.getGamePos()).getPosition();
        pubText = lB.getGames().get(lB.getGamePos()).getPublisher();
        datePubText = lB.getGames().get(lB.getGamePos()).getDiscription();
        lengthInt = lB.getGames().get(lB.getGamePos()).getCampaign();
        devText = lB.getGames().get(lB.getGamePos()).getDeveloper();
        ratingDouble = lB.getGames().get(lB.getGamePos()).getRating();
        datePubText = lB.getGames().get(lB.getGamePos()).getPublishedIn();
        platText = lB.getGames().get(lB.getGamePos()).getFranchise();
        genreText = lB.getGames().get(lB.getGamePos()).getGenre();
        achivDouble = lB.getGames().get(lB.getGamePos()).getAchievements();   
    }

    public void buildStage() throws IOException, ClassNotFoundException {
        Library lB = new Library();
        //Stack for information display
        StackPane displayInfo = new StackPane();
        VBox extraInfo = new VBox();
        Button btnPop = new Button("Populate");

        //background Rec for DisplayInfo
        Rectangle infoRec = new Rectangle(600, 700, goldAccent);
        infoRec.setArcWidth(30.0);
        infoRec.setArcHeight(20.0);
        displayInfo.setLayoutX(90);
        displayInfo.setLayoutY(90);
        displayInfo.getChildren().add(infoRec);

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

        //search text and button
        TextField tfSearch = new TextField();
        tfSearch.setPromptText("Search...");
        tfSearch.setPrefWidth(300);
        tfSearch.setLayoutX(150);
        tfSearch.setLayoutY(825);

        Button btnSearch = new Button("Search");
        btnSearch.setPrefWidth(100);
        btnSearch.setLayoutX(455);
        btnSearch.setLayoutY(825);

        btnPop.setPrefWidth(50);
        btnPop.setLayoutX(525);
        btnPop.setLayoutY(825);
        
        btnSwitch.setPrefWidth(50);
        btnSwitch.setLayoutX(20);
        btnSwitch.setLayoutY(20);

        //Creating info display
        GridPane textBoxes = new GridPane();
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
        Label dbHourPlayed = new Label(String.valueOf(hoursDouble));
        textBoxes.add(lbHoursPlayed, 1, 8);
        textBoxes.add(dbHourPlayed, 1, 9);
        //dbHourPlayed.setPromptText("Hours Played...");

        Label lbMP = new Label("Multiplayer:");
        Label dbMP = new Label("false");
        textBoxes.add(lbMP, 5, 0);
        textBoxes.add(dbMP, 5, 1);
        //dbMP.setPromptText("Multiplayer...");

        Label lbPublisher = new Label("Publisher:");
        Label dbPublisher = new Label();
        textBoxes.add(lbPublisher, 1, 2);
        textBoxes.add(dbPublisher, 1, 3);
        //dbPublisher.setPromptText("Publisher...");

        Label lbDateMade = new Label("Date Made:");
        Label dbDateMade = new Label();
        textBoxes.add(lbDateMade, 3, 2);
        textBoxes.add(dbDateMade, 3, 3);
        //dbDateMade.setPromptText("Date Made...");

        Label lbLength = new Label("Length:");
        Label dbLength = new Label(String.valueOf(lengthInt));
        textBoxes.add(lbLength, 3, 8);
        textBoxes.add(dbLength, 3, 9);
        //dbLength.setPromptText("Length...");

        Label lbDeveloper = new Label("Developer:");
        Label dbDeveloper = new Label();
        textBoxes.add(lbDeveloper, 1, 4);
        textBoxes.add(dbDeveloper, 1, 5);
        //dbDeveloper.setPromptText("Developer...");

        Label lbRating = new Label("Rating:");
        Label dbRating = new Label(String.valueOf(ratingDouble));
        textBoxes.add(lbRating, 3, 4);
        textBoxes.add(dbRating, 3, 5);
        //dbRating.setPromptText("Rating...");

        Label lbDatePurchased = new Label("Date Purchased:");
        Label dbDatePurchased = new Label();
        textBoxes.add(lbDatePurchased, 3, 10);
        textBoxes.add(dbDatePurchased, 3, 11);
        //dbDatePurchased.setPromptText("Date Purchased...");

        Label lbPlatform = new Label("Platform:");
        Label dbPlatform = new Label();
        textBoxes.add(lbPlatform, 1, 10);
        textBoxes.add(dbPlatform, 1, 11);
        //dbPlatform.setPromptText("Platform...");

        Label lbAchievements = new Label("Achievements:");
        Label dbAchievements = new Label(String.valueOf(achivDouble));
        textBoxes.add(lbAchievements, 1, 6);
        textBoxes.add(dbAchievements, 1, 7);
        //dbAchievements.setPromptText("Achievements...");

        Label lbGenre = new Label("Genre:");
        Label dbGenre = new Label();
        textBoxes.add(lbGenre, 3, 6);
        textBoxes.add(dbGenre, 3, 7);
        //dbGenre.setPromptText("Genre...");

        Label lbDesc = new Label("Description:");
        //lbDesc.setFont(50);
        lbDesc.setLayoutX(820);
        lbDesc.setLayoutY(560);
        
        btnPop.setOnAction((ActionEvent event) -> {
            try {
                populateData(lB);
                displayInfo.getChildren().clear();
                displayInfo.getChildren().add(textBoxes);
            } catch (IOException ex) {
                Logger.getLogger(displayPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String keyword = tfSearch.getText();
               
                try {
                   // System.out.println(lB.dataBaseSearch(keyword));
                    if (lB.dataBaseSearch(keyword) == true) {

                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
                }        
            }
        });

        //dbGenre.setPromptText("Genre...");
        //textBoxes.setGridLinesVisible(true);
        displayInfo.getChildren().add(textBoxes);

        //adding nodes to scenes
        rootTwo.getChildren().addAll(displayInfo, extraInfo, recDesc,
                descripRec, tfSearch, btnSearch, metaRec, iV, reviewBox,
                logoView, lbDesc, btnPop, btnSwitch);

    }

}
