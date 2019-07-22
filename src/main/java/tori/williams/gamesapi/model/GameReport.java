package tori.williams.gamesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameReport {

    @JsonProperty("user_with_most_comments")
    private String userWithMostComments;

    @JsonProperty("highest_rated_game")
    private String highestRatedGame;

    @JsonProperty("average_likes_per_game")
    private AverageLikesPerGame[] averageLikes;

    public String getUserWithMostComments() {
        return userWithMostComments;
    }

    public void setUserWithMostComments(String userWithMostComments) {
        this.userWithMostComments = userWithMostComments;
    }

    public String getHighestRatedGame() {
        return highestRatedGame;
    }

    public void setHighestRatedGame(String highestRatedGame) {
        this.highestRatedGame = highestRatedGame;
    }

    public AverageLikesPerGame[] getAverageLikes() {
        return averageLikes;
    }

    public void setAverageLikes(AverageLikesPerGame[] averageLikes) {
        this.averageLikes = averageLikes;
    }
}
