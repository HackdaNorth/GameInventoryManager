package gameinventorymanager;

import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author Ian Ibrahim @ Zeinith.com
 */
public class Game implements Serializable {

    private static long serialVersionUID = 1L;

    private Integer position;
    private String title;
    private String discription;
    private Double cost;
    private String publisher;
    private String publishedIn;
    private int campaign;
    private String developer;
    private double rating;
    private double achievements;
    private boolean multiplayer;
    private String genre;
    private String franchise;

    public Game(int position, String title, String discription, double cost,
            String publisher, String publishedIn, int campaign, String developer,
            double rating, double achivements, boolean multiplayer, String genre, String franchise) {
        this.position = (position);
        this.title = (title);
        this.discription = (discription);
        this.cost = cost;
        this.publisher = (publisher);
        this.publishedIn = (publishedIn);
        this.campaign = campaign;
        this.developer = (developer);
        this.rating = rating;
        this.achievements = achivements;
        this.multiplayer = multiplayer;
        this.genre = (genre);
        this.franchise = (franchise);

    }

    @Override
    public String toString() {
        return new StringBuffer(" Game Title: ").append(this.getTitle())
                .append(" Discription : ").append(this.getDiscription())
                .append(" Cost : ").append(this.getCost())
                .append(" Publisher : ").append(this.getPublisher())
                .append(" Published in : ").append(this.getPublishedIn())
                .append(" Campaign : ").append(this.getCampaign())
                .append(" Developer : ").append(this.getDeveloper())
                .append(" Rating : ").append(this.getRating())
                .append(" Achievements : ").append(this.getAchievements())
                .append(" Multiplayer : ").append(this.isMultiplayer())
                .append(" Genre : ").append(this.getGenre())
                .append(" Franchise : ").append(this.getFranchise())
                .toString();
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the discription
     */
    public String getDiscription() {
        return discription;
    }

    /**
     * @param discription the discription to set
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    /**
     * @return the cost
     */
    public Double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(Double cost) {
        this.cost = cost;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the publishedIn
     */
    public String getPublishedIn() {
        return publishedIn;
    }

    /**
     * @param publishedIn the publishedIn to set
     */
    public void setPublishedIn(String publishedIn) {
        this.publishedIn = publishedIn;
    }

    /**
     * @return the campaign
     */
    public int getCampaign() {
        return campaign;
    }

    /**
     * @param campaign the campaign to set
     */
    public void setCampaign(int campaign) {
        this.campaign = campaign;
    }

    /**
     * @return the developer
     */
    public String getDeveloper() {
        return developer;
    }

    /**
     * @param developer the developer to set
     */
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    /**
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @return the achievements
     */
    public double getAchievements() {
        return achievements;
    }

    /**
     * @param achievements the achievements to set
     */
    public void setAchievements(double achievements) {
        this.achievements = achievements;
    }

    /**
     * @return the multiplayer
     */
    public boolean isMultiplayer() {
        return multiplayer;
    }

    /**
     * @param multiplayer the multiplayer to set
     */
    public void setMultiplayer(boolean multiplayer) {
        this.multiplayer = multiplayer;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the franchise
     */
    public String getFranchise() {
        return franchise;
    }

    /**
     * @param franchise the franchise to set
     */
    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public void addGame(int pos, String title, String desc, double Cost, String pub, String datePub, int campaignLength, String dev, double rating, int achivements, boolean Multiplayer, String genre, String Franc) throws IOException, ClassNotFoundException {
        Library lB = new Library();
        Game addGame = new Game(pos, title, desc, Cost, pub, datePub, campaignLength, dev, rating, achivements, Multiplayer, genre, Franc);
        lB.games.add(addGame);
        lB.writeObject(lB.games);
        lB.readObject();
    }
}
