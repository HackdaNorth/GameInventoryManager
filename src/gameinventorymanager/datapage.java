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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 *
 * @author Conman
 */
public class datapage
{

   TextField tf;
   Group root = new Group();
   HBox pane = new HBox();
   Color backgroundColor = Color.web("#FBDF55");
   Color blueAccent = Color.web("#669CF5");
   Scene scene = new Scene(root, 1400, 900, backgroundColor);
   Button btn = new Button();
   displayPage secondPage = new displayPage();
   Stage primaryStage;
   String nameText, descText, pubText, datePubText, devText, genreText, francText, platText = "";
   double costDouble, achivDouble = 12 / 45, ratingDouble = 59, campDouble = 00.0, hoursDouble = 0.0;
   int lengthInt = 0;
   boolean multiplayer;

   public void start (Stage primaryStage) throws FileNotFoundException, IOException, ClassNotFoundException
   {

      buildStage();
      primaryStage.setTitle("Game Inventory Manager");
      primaryStage.setScene(scene);
      primaryStage.show();
   }

   public void buildStage () throws IOException, ClassNotFoundException
   {

      root.getChildren().add(pane);
      //new textFields for the inventory search.
      StackPane userOptions = new StackPane();

      userOptions.setLayoutX(600);
      userOptions.setLayoutY(50);

      GridPane textBoxes = new GridPane();
      textBoxes.setPadding(new Insets(10));
      textBoxes.setHgap(10);
      textBoxes.setVgap(10);

      Image imgLogo = new Image("file:Images/Capture3.PNG");

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

      btn.setText("OK");

      //btn.setText("OKTest");
      Button btnSearch = new Button();
      btnSearch.setText("Search");
      btnSearch.setLayoutX(100);
      btnSearch.setLayoutY(400);

      tf = new TextField();
      tf.setPromptText("Search...");
      tf.setLayoutX(160);
      tf.setLayoutY(400);
      root.getChildren().add(tf);

      TextField dbName = new TextField(nameText);
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
      TextField dbPublisher = new TextField(pubText);
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
      TextField dbDeveloper = new TextField(devText);
      textBoxes.add(lbDeveloper, 1, 4);
      textBoxes.add(dbDeveloper, 1, 5);
      dbDeveloper.setPromptText("Developer...");

      Label lbRating = new Label("Rating");
      TextField dbRating = new TextField();
      textBoxes.add(lbRating, 2, 4);
      textBoxes.add(dbRating, 2, 5);
      dbRating.setPromptText("Rating...");

      Label lbDatePurchased = new Label("Date Purchased");
      TextField dbDatePurchased = new TextField(datePubText);
      textBoxes.add(lbDatePurchased, 3, 4);
      textBoxes.add(dbDatePurchased, 3, 5);
      dbDatePurchased.setPromptText("Date Purchased...");

      Label lbAchievements = new Label("Achievements");
      TextField dbAchievements = new TextField();

      textBoxes.add(lbAchievements, 1, 6);
      textBoxes.add(dbAchievements, 1, 7);
      dbAchievements.setPromptText("Achievements...");

      Label lbGenre = new Label("Genre");
      TextField dbGenre = new TextField(genreText);
      textBoxes.add(lbGenre, 2, 6);
      textBoxes.add(dbGenre, 2, 7);
      dbGenre.setPromptText("Genre...");

      Label lbPlatform = new Label("Platform");
      TextField dbPlatform = new TextField(platText);
      textBoxes.add(lbPlatform, 3, 6);
      textBoxes.add(dbPlatform, 3, 7);
      dbPlatform.setPromptText("Platform...");

      Button addGame = new Button("Add Game");
      textBoxes.add(addGame, 4, 3);
      Library lB = new Library();
      TableView table = new TableView();
      table.setEditable(true);


      TableColumn<Game, Integer> position = new TableColumn<>("position");
      position.setCellValueFactory(new PropertyValueFactory<>("position"));
      position.setCellFactory(TextFieldTableCell.<Game, Integer>forTableColumn(new IntegerStringConverter()));
      position.setOnEditCommit((TableColumn.CellEditEvent<Game, Integer> event) -> {
         TablePosition<Game, Integer> pos = event.getTablePosition();

         Integer newValue = event.getNewValue();

         int row = pos.getRow();
         Game game = event.getTableView().getItems().get(row);
         game.setPosition(newValue);
         try {
            lB.writeObject(lB.games);
         }
         catch (IOException ex) {
            Logger.getLogger(datapage.class.getName()).log(Level.SEVERE, null, ex);
         }
      });

      TableColumn<Game, String> title = new TableColumn<>("Title");
      title.setCellValueFactory(new PropertyValueFactory<>("Title"));
      title.setCellFactory(TextFieldTableCell.<Game>forTableColumn());
      title.setOnEditCommit((TableColumn.CellEditEvent<Game, String> event) -> {
         TablePosition<Game, String> pos = event.getTablePosition();

         String newGameTitle = event.getNewValue();

         int row = pos.getRow();
         Game game = event.getTableView().getItems().get(row);
         game.setTitle(newGameTitle);
         try {
            lB.writeObject(lB.games);
         }
         catch (IOException ex) {
            Logger.getLogger(datapage.class.getName()).log(Level.SEVERE, null, ex);
         }
      });

      TableColumn< Game, String> discription = new TableColumn("Discription");
      discription.setCellValueFactory(new PropertyValueFactory<>("Discription"));
      discription.setCellFactory(TextFieldTableCell.<Game>forTableColumn());
      discription.setOnEditCommit((TableColumn.CellEditEvent<Game, String> event) -> {
         TablePosition<Game, String> pos = event.getTablePosition();

         String newValue = event.getNewValue();

         int row = pos.getRow();
         Game game = event.getTableView().getItems().get(row);
         game.setDiscription(newValue);
         try {
            lB.writeObject(lB.games);
         }
         catch (IOException ex) {
            Logger.getLogger(datapage.class.getName()).log(Level.SEVERE, null, ex);
         }
      });
      TableColumn<Game, Double> cost = new TableColumn("Cost");
      cost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
      cost.setCellFactory(TextFieldTableCell.<Game, Double>forTableColumn((new DoubleStringConverter())));
      cost.setOnEditCommit((TableColumn.CellEditEvent<Game, Double> event) -> {
         TablePosition<Game, Double> pos = event.getTablePosition();

         Double newValue = event.getNewValue();

         int row = pos.getRow();
         Game game = event.getTableView().getItems().get(row);
         game.setCost(newValue);
         try {
            lB.writeObject(lB.games);
         }
         catch (IOException ex) {
            Logger.getLogger(datapage.class.getName()).log(Level.SEVERE, null, ex);
         }
      });

      TableColumn< Game, String> publisher = new TableColumn("Publisher");
      publisher.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
      publisher.setCellFactory(TextFieldTableCell.<Game>forTableColumn());
      publisher.setOnEditCommit((TableColumn.CellEditEvent<Game, String> event) -> {
         TablePosition<Game, String> pos = event.getTablePosition();

         String newValue = event.getNewValue();

         int row = pos.getRow();
         Game game = event.getTableView().getItems().get(row);
         game.setPublisher(newValue);

         try {
            lB.writeObject(lB.games);
         }
         catch (IOException ex) {
            Logger.getLogger(datapage.class.getName()).log(Level.SEVERE, null, ex);
         }
      });

      TableColumn<Game, String> publishedIn = new TableColumn("Date Published");
      publishedIn.setCellValueFactory(new PropertyValueFactory<>("PublishedIn"));
      publishedIn.setCellFactory(TextFieldTableCell.<Game>forTableColumn());
      publishedIn.setOnEditCommit((TableColumn.CellEditEvent<Game, String> event) -> {
         TablePosition<Game, String> pos = event.getTablePosition();

         String newValue = event.getNewValue();

         int row = pos.getRow();
         Game game = event.getTableView().getItems().get(row);
         game.setPublishedIn(newValue);
         try {
            lB.writeObject(lB.games);
         }
         catch (IOException ex) {
            Logger.getLogger(datapage.class.getName()).log(Level.SEVERE, null, ex);
         }
      });
      TableColumn campaign = new TableColumn("Campaign");
      campaign.setCellValueFactory(new PropertyValueFactory<>("Campaign"));

      TableColumn developer = new TableColumn("Developer");
      developer.setCellValueFactory(new PropertyValueFactory<>("Developer"));

      TableColumn rating = new TableColumn("Rating");
      rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));

      TableColumn achivements = new TableColumn("Achivements");
      achivements.setCellValueFactory(new PropertyValueFactory<>("Achivements"));

      TableColumn multiplayer = new TableColumn("Multiplayer");
      multiplayer.setCellValueFactory(new PropertyValueFactory<>("Multiplayer"));

      TableColumn genre = new TableColumn("Genre");
      genre.setCellValueFactory(new PropertyValueFactory<>("Genre"));

      TableColumn franchise = new TableColumn("Franchise");
      franchise.setCellValueFactory(new PropertyValueFactory<>("Franchise"));

      table.getColumns().addAll(position, title, discription, cost, publisher, publishedIn, campaign, developer, rating, achivements, multiplayer, genre, franchise);
      table.getItems().addAll(lB.games);
//      Game g1 = new Game(0, "saw", "alber", 40.00, "aa", "aa", 20, "aa", 30.00, 40.00, "true", "alfa", "beta");
//      lB.games.add(g1);
//      lB.writeObject(lB.games);
      lB.readObject();
      table.getItems().addAll(lB.games);



      listDisplay.getChildren().add(table);
      listDisplay.setLayoutX(100);
      listDisplay.setLayoutY(430);

      root.getChildren().add(listDisplay);
      userOptions.getChildren().add(textBoxes);
      root.getChildren().add(btn);
      root.getChildren().add(btnSearch);

      addGame.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent event)
         {
            try {
//               Library lB = new Library();

               int hours = Integer.parseInt(dbHourPlayed.getText());
               costDouble = Double.parseDouble(dbCost.getText());
               lengthInt = Integer.parseInt(dbLength.getText());
               achivDouble = Double.parseDouble(dbAchievements.getText());
               ratingDouble = Double.parseDouble(dbRating.getText());
               Game addGame = new Game(hours, dbName.getText(), dbDateMade.getText(), costDouble, dbPublisher.getText(), dbDatePurchased.getText(), lengthInt, dbDeveloper.getText(), ratingDouble, achivDouble, dbMP.getText(), dbGenre.getText(), dbPlatform.getText());
               lB.games.add(addGame);

//               lB.readObject();

               lB.writeObject(lB.games);
//                    listDisplay.getChildren().add(table);
               table.getItems().clear();
               table.getItems().addAll(lB.games);
            }
            catch (IOException ex) {
               Logger.getLogger(datapage.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (ClassNotFoundException ex) {
//                    Logger.getLogger(datapage.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
      });

//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                try {
//                    if (data.dataBaseSearch(tf.getText()) == true) {
//                        System.out.println("found");
//                    }
//                } catch (IOException ex) {
//                    Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
      btnSearch.setOnAction(new EventHandler<ActionEvent>()
      {
         @Override
         public void handle (ActionEvent event)
         {
            String keyword = tf.getText();
            try {
               if (lB.dataBaseSearch(keyword) == true) {
                  System.out.println("true");
               }
               else {
                  System.out.println("false");
               }
            }
            catch (IOException ex) {
               Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            }

         }
      });

   }

   public void refreshTable ()
   {

   }

   public TextField getTextField ()
   {
      return tf;
   }

   public Group getGroup ()
   {
      return root;
   }

   public void hideStage (Stage primaryStage)
   {
      primaryStage.hide();
   }

}
