package tori.williams.gamesapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import tori.williams.gamesapi.exception.GamesJsonMappingException;
import tori.williams.gamesapi.model.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Service
public class GamesService {

    private Game[] cachedGames;

    public GamesService() {

        try {
            this.cachedGames = new ObjectMapper().readValue(getClass().getClassLoader()
                    .getResourceAsStream("games.json"), Game[].class);
        } catch (IOException e) {
            throw new GamesJsonMappingException(e);
        }
    }

    public Game getGameById(int gameId) {

        for (Game game : cachedGames) {

            if (game.getId() == gameId) {

                return game;
            }
        }

        return null;
    }

    public GameReport getGameReport() {

        GameReport gameReport = new GameReport();
        gameReport.setUserWithMostComments(getUserWithMostComments());
        gameReport.setHighestRatedGame(getHighestRatedGame());
        gameReport.setAverageLikes(getAverageLikesPerGames());

        return gameReport;
    }

    private String getUserWithMostComments() {

        Map<String, Integer> userComments = new HashMap<>();

        for (Game game : cachedGames) {
            for (Comment comment : game.getComments()) {
                if (userComments.containsKey(comment.getUser())) {
                    userComments.put(comment.getUser(), userComments.get(comment.getUser()) + 1);
                } else {
                    userComments.put(comment.getUser(), 1);
                }
            }
        }

        return Collections.max(userComments.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    private String getHighestRatedGame() {

        int highestNumberOfLikes = 0;
        String highestRatedGame = "";

        for (Game game : cachedGames) {
            if (game.getLikes() > highestNumberOfLikes) {
                highestNumberOfLikes = game.getLikes();
                highestRatedGame = game.getTitle();
            }
        }

        return highestRatedGame;
    }

    private AverageLikesPerGame[] getAverageLikesPerGames() {

        AverageLikesPerGame[] averageLikesPerGames = new AverageLikesPerGame[cachedGames.length];

        for (int i = 0; i < cachedGames.length; i++) {
            Game game = cachedGames[i];

            AverageLikesPerGame averageLikesPerGame = new AverageLikesPerGame();
            averageLikesPerGame.setTitle(game.getTitle());

            double totalCommentLikes = 0;

            for (Comment comment : game.getComments()) {
                totalCommentLikes += comment.getRating();
            }

            int averageCommentLikes = (int) Math.ceil(totalCommentLikes / game.getComments().length);
            averageLikesPerGame.setAverageLikes(averageCommentLikes);
            averageLikesPerGames[i] = averageLikesPerGame;
        }

        return averageLikesPerGames;
    }
}
