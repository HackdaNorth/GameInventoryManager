//package gameinventorymanager;
//
//import javafx.application.Application;
//import javafx.beans.property.SimpleBooleanProperty;
//import javafx.beans.property.SimpleObjectProperty;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.TableCell;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableColumn.CellDataFeatures;
//import javafx.scene.control.TableColumn.CellEditEvent;
//import javafx.scene.control.TablePosition;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.CheckBoxTableCell;
//import javafx.scene.control.cell.ComboBoxTableCell;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.control.cell.TextFieldTableCell;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;
//import javafx.util.Callback;
//import javafx.util.converter.IntegerStringConverter;
//
///**
// *
// * @author Ian Ibrahim @ Zeinith.com
// */
//public class TableViewBottom extends Application {
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        TableView table = new TableView();
//        table.setEditable(true);
//
//        TableColumn<Game, Integer> position = new TableColumn<>("position");
//        position.setCellValueFactory(new PropertyValueFactory<>("position"));
//        position.setCellFactory(TextFieldTableCell.<Game, Integer>forTableColumn(new IntegerStringConverter()));;
//
//        TableColumn<Game, String> title = new TableColumn<>("Title");
//        title.setCellValueFactory(new PropertyValueFactory<>("Title"));
//        title.setCellFactory(TextFieldTableCell.<Game>forTableColumn());
//        title.setOnEditCommit((CellEditEvent<Game, String> event) -> {
//            TablePosition<Game, String> pos = event.getTablePosition();
//            
//            String newGameTitle = event.getNewValue();
//            
//            int row = pos.getRow();
//            Game game = event.getTableView().getItems().get(row);
//            game.setTitle(newGameTitle);
//        });
//
//        TableColumn< Game, String> discription = new TableColumn("Discription");
//        discription.setCellValueFactory(new PropertyValueFactory<>("Discription"));
//        TableColumn cost = new TableColumn("Cost");
//        cost.setCellValueFactory(new PropertyValueFactory<>("Cost"));
//        TableColumn publisher = new TableColumn("Publisher");
//        publisher.setCellValueFactory(new PropertyValueFactory<>("Publisher"));
//        TableColumn publishedIn = new TableColumn("Date Published");
//        publishedIn.setCellValueFactory(new PropertyValueFactory<>("PublishedIn"));
//        TableColumn campaign = new TableColumn("Campaign");
//        campaign.setCellValueFactory(new PropertyValueFactory<>("Campaign"));
//        TableColumn developer = new TableColumn("Developer");
//        developer.setCellValueFactory(new PropertyValueFactory<>("Developer"));
//        TableColumn rating = new TableColumn("Rating");
//        rating.setCellValueFactory(new PropertyValueFactory<>("Rating"));
//        TableColumn achivements = new TableColumn("Achivements");
//        achivements.setCellValueFactory(new PropertyValueFactory<>("Achivements"));
//        TableColumn multiplayer = new TableColumn("Multiplayer");
//        multiplayer.setCellValueFactory(new PropertyValueFactory<>("Multiplayer"));
//        TableColumn genre = new TableColumn("Genre");
//        genre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
//        TableColumn franchise = new TableColumn("Franchise");
//        franchise.setCellValueFactory(new PropertyValueFactory<>("Franchise"));
//        table.getColumns().addAll(position, title, discription, cost, publisher, publishedIn, campaign, developer, rating, achivements, multiplayer, genre, franchise);
////        table.getItems().addAll(dB.getGames());
//
//    }
//
//}
