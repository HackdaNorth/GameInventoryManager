package gameinventorymanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Conman
 */
public class databaseInteraction {
//google what msot of this shit means lul

    public static ArrayList<String> gameList = new ArrayList<>();
    public static List<databaseInteraction> listRows = new ArrayList<>();
    public static String[] cell = new String[13];
    public static int num = 0;
    public static BufferedReader fileReader = null;
    public static List<List<String>> database = new ArrayList<>();
    public static String csvFile = ("src\\Databases\\gameList.csv");

    public databaseInteraction() throws FileNotFoundException, IOException {
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

    public boolean dataBaseSearch(String keyword) throws IOException {
        for (int i = 0; i < databaseInteraction.gameList.size(); i++) {
            String temp = gameList.get(i);
            temp = temp.toLowerCase();
            keyword = keyword.toLowerCase();
            if (temp.contains(keyword)) {
                System.out.println(temp);
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

