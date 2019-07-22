package tori.williams.gamesapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Games {

    @JsonProperty("games")
    private Game[] games;

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }
}
