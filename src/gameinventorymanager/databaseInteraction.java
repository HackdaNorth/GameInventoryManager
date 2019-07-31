package gameinventorymanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author Conman
 */
public class databaseInteraction {
//google what msot of this shit means lul

    public static ArrayList<String> gameList = new ArrayList<>();
    public static String[] cell = new String[13];
    public static int num = 0;
    public static BufferedReader fileReader = null;
    public static List<List<String>> database = new ArrayList<>();
    public static String csvFile = ("C:\\Users\\heckd\\OneDrive\\Documents\\Sheridan College\\Object Oriented Programming 2\\GameInventoryManager\\src\\Databases\\gameList.csv");

    public databaseInteraction() throws FileNotFoundException, IOException {
        //Set the delimiter used in file
        //buildCSV();
        //Get scanner instance
        //rrayList<String> gameList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(csvFile));
        //Set the delimiter used in file
        scanner.useDelimiter(",");
        //Get all tokens and store them in some data structure
        //I am just printing them
        while (scanner.hasNext()) {
            gameList.add(scanner.next());
        }
        //Do not forget to close the scanner
        scanner.close();

        String csvFilename = "C:\\sample.csv";
 

    }

    public static List<List<String>> getDatabase() {
        return database;
    }

    public static void setDatabase(List<List<String>> database) {
        databaseInteraction.database = database;
    }

    public static ArrayList<String> getGameList() {
        return gameList;
    }

    public static void setGameList(ArrayList<String> gameList) {
        databaseInteraction.gameList = gameList;
    }

    public static void buildCSV() throws FileNotFoundException, IOException {
        try (Scanner scanner = new Scanner(new File(csvFile))) {
            while (scanner.hasNextLine()) {
                //getGameList().add(getDatafromCell(scanner.nextLine()));
            }
        }
    }

    public static List<String> getDatafromCell(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());

            }
        }
        return values;
    }

//  public static ListView<String> displayData() throws FileNotFoundException {
// 
//        Scanner scanner = new Scanner(new File(csvFile));
//        
//        ObservableList<String> items;
//        items = FXCollections.observableArrayList(database);
//        data.setItems(items);
//        return data;
//    }
    //teach saying there is a "hidden" line character so if we say "at end of line" add it into a specific spot that we can then edit.
//    public ArrayList buildData() throws FileNotFoundException, IOException {
//        //Get scanner instance
//      
//        //rrayList<String> gameList = new ArrayList<>();
//        Scanner scanner = new Scanner(new File(csvFile));
//        //Set the delimiter used in file
//        scanner.useDelimiter(",");
//        //Get all tokens and store them in some data structure
//        //I am just printing them     
//        while (scanner.hasNext()) {
//            gameList.add(scanner.next());
//           
//        }
////        for (int i = 0; i < num; i++) {
////            gameList.add(scanner.next());
////        }
//        //Do not forget to close the scanner 
//        scanner.close();
//        return gameList;
//    }
    public boolean dataBaseSearch(String keyword) throws IOException {
        for (int i = 0; i < databaseInteraction.gameList.size(); i++) {
            System.out.println(gameList.get(i) + "|");
            String temp = gameList.get(i);
            temp = temp.toLowerCase();
            keyword = keyword.toLowerCase();
            if (temp.contains(keyword)) {
                //grabDataCell();
                return true;
            }
        }
        return false;
    }

}
//   @Override
//   public String toString() {
//      
//       return output;
//   }

