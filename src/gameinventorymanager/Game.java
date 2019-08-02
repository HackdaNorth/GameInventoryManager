package gameinventorymanager;

import java.io.Serializable;

/**
 *
 * @author Ian Ibrahim @ Zeinith.com
 */
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;
    private int position;
    private String title;
    private String discription;
    private double cost;
    private String publisher;
    private String publishedIn;
    private int campaign;
    private String developer;
    private double rating;
    private double achievements;
    private boolean multiplayer;
    private String genre;
    private String franchise;
    
    public Game(int position,String title,String discription, double cost,
            String publisher,String publishedIn, int campaign, String developer
            , double rating,double achivements,boolean multiplayer, String genre,String franchise) {
        this.position = position;
        this.title = title;
        this.discription=discription;
        this.cost =cost;
        this.publisher =publisher;
        this.publishedIn = publishedIn;
        this.campaign = campaign;
        this.developer = developer;
        this.rating = rating;
        this.achievements = achivements;
        this.multiplayer =multiplayer;
        this.genre= genre;
        this.franchise = franchise;
        
        
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
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
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
    @Override
    public String toString() {
        return new StringBuffer(" Game Title: ").append(this.title)
                .append(" Discription : ").append(this.discription)
                .append(" Cost : ").append(this.cost)
                .append(" Publisher : ").append(this.publisher)
                .append(" Published in : ").append(this.publishedIn)
                .append(" Campaign : ").append(this.campaign)
                .append(" Developer : ").append(this.developer)
                .append(" Rating : ").append(this.rating)
                .append(" Achievements : ").append(this.achievements)
                .append(" Multiplayer : ").append(this.multiplayer)
                .append(" Genre : ").append(this.genre)
                .append(" Franchise : ").append(this.franchise)
                .toString();
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }
}

