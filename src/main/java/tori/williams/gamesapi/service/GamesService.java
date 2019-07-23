package tori.williams.gamesapi.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tori.williams.gamesapi.controller.GamesController;
import tori.williams.gamesapi.exception.GamesJsonMappingException;
import tori.williams.gamesapi.model.*;

import java.io.IOException;
import java.util.*;

@Service
public class GamesService {

    private static final Logger logger = LogManager.getLogger(GamesController.class);

    private Game[] cachedGames;

    public GamesService() {

        try {
            this.cachedGames = new ObjectMapper().readValue(getClass().getClassLoader()
                    .getResourceAsStream("games.json"), Game[].class);
        } catch (IOException e) {
            throw new GamesJsonMappingException(e);
        }
    }

    /**
     * Method to loop through all cached games and get game by ID
     * @param gameId
     * @return game
     */
    public Game getGameById(int gameId) {

        for (Game game : cachedGames) {

            if (game.getId() == gameId) {

                return game;
            }
        }

        return null;
    }

    /**
     * Method to get all relevant information via a games report
     * @return gameReport
     */
    public GameReport getGameReport() {

        GameReport gameReport = new GameReport();
        gameReport.setUserWithMostComments(getUserWithMostComments());
        gameReport.setHighestRatedGame(getHighestRatedGame());
        gameReport.setAverageLikes(getAverageLikesPerGames());

        return gameReport;
    }

    /**
     * Maps through each user comment per game
     * @return user with the most comments
     */
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

        logger.info("User with the most comments: {}", Collections.max(userComments.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey());
        return Collections.max(userComments.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    /**
     * Loops through cachedGames to find the highest rated game
     * @return highestRatedGame
     */
    private String getHighestRatedGame() {

        int highestNumberOfLikes = 0;
        String highestRatedGame = "";

        for (Game game : cachedGames) {
            if (game.getLikes() > highestNumberOfLikes) {
                highestNumberOfLikes = game.getLikes();
                highestRatedGame = game.getTitle();
            }
        }

        logger.info("Highest rated game: {}", highestRatedGame);
        return highestRatedGame;
    }

    /**
     * Loops through cachedGames to find the average likes per game
     * @return averageLikesPerGame
     */
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

            logger.info("Average likes of {}: {}", game.getTitle(), averageCommentLikes);
        }

        return averageLikesPerGames;
    }
}
