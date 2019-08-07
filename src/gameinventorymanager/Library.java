package gameinventorymanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.TextField;

/**
 *
 * @author Ian Ibrahim @ Zeinith.com
 */
public class Library {

    public ArrayList<Game> games = new ArrayList<>();
    public int gamePos = 0;

    private RandomAccessFile database;

    public Library() throws IOException {
        try {
            this.database = new RandomAccessFile("Games.dat", "rw");

        } catch (FileNotFoundException e) {
            System.out.println("File Can't be found");
        }

    }

    /**
     * @return the games
     */
    public ArrayList<Game> getGames() {
        return games;
    }

    public void addAGame(Game game) {
        games.add(game);
    }

    /**
     * @param games the games to set
     */
    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public void readObject() throws IOException, ClassNotFoundException {
        ObjectInputStream ois;
        ois = new ObjectInputStream(new FileInputStream("Games.dat"));
        setGames((ArrayList<Game>) ois.readObject());
        ois.close();

    }

    public void writeObject(ArrayList<Game> games) throws IOException {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Games.dat"))) {
            output.writeObject(games);
            output.close();
        }

    }

    public boolean dataBaseSearch(String keyword) throws IOException, ClassNotFoundException {
        for (int i = 0; i < getGames().size(); i++) {
            Game temp = getGames().get(i);
            String sTemp = temp.toString();
            String toLowerCase = sTemp.toLowerCase();
            keyword = keyword.toLowerCase();
            if (toLowerCase.contains(keyword)) {
                setGamePos(getGames().indexOf(temp)); 
                return true;
            }
        }
        return false;
    }
    public int getSearch(String keyword, Library lB) throws IOException, ClassNotFoundException {
        for (int i = 0; i < getGames().size(); i++) {
            Game temp = getGames().get(i);
            String sTemp = temp.toString();
            String toLowerCase = sTemp.toLowerCase();
            keyword = keyword.toLowerCase();
            if (toLowerCase.contains(keyword)) {
                setGamePos(getGames().indexOf(temp));
                return lB.getGamePos();
            }
        }
        return lB.getGamePos();
    }
    public int getGamePos() {
        return gamePos;
    }

 

    public void setGamePos(int gamePos) {
        this.gamePos = gamePos;
    }
}
