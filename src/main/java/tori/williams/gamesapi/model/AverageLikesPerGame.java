package tori.williams.gamesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageLikesPerGame {

    @JsonProperty("title")
    private String title;

    @JsonProperty("average_likes")
    private int averageLikes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAverageLikes() {
        return averageLikes;
    }

    public void setAverageLikes(int averageLikes) {
        this.averageLikes = averageLikes;
    }
}
