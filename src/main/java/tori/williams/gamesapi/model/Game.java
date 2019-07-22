package tori.williams.gamesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Game {

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("by")
    private String gameCreator;

    @JsonProperty("platform")
    private String[] platform;

    @JsonProperty("age_rating")
    private int age;

    @JsonProperty("likes")
    private int likes;

    @JsonProperty("comments")
    private Comment[] comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGameCreator() {
        return gameCreator;
    }

    public void setGameCreator(String gameCreator) {
        this.gameCreator = gameCreator;
    }

    public String[] getPlatform() {
        return platform;
    }

    public void setPlatform(String[] platform) {
        this.platform = platform;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Comment[] getComments() {
        return comments;
    }

    public void setComments(Comment[] comments) {
        this.comments = comments;
    }
}

