package tori.williams.gamesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tori.williams.gamesapi.controller.constant.EndPoint;
import tori.williams.gamesapi.model.Game;
import tori.williams.gamesapi.model.GameReport;
import tori.williams.gamesapi.service.GamesService;

@RestController
@RequestMapping(value = EndPoint.GAMES, produces = MediaType.APPLICATION_JSON_VALUE)
public class GamesController {

    private static final Logger logger = LogManager.getLogger(GamesController.class);

    @Autowired
    private GamesService gamesService;

    /**
     * Retrieves data for a specific game ID
     * @param gameId
     * @return
     */
    @GetMapping(value = EndPoint.GAME_BY_ID)
    public ResponseEntity<Game> getGameById(@PathVariable("id") int gameId) {

        logger.info("Fetching game with id: {}", gameId);

        Game game = gamesService.getGameById(gameId);

        if (game == null) {
            logger.warn("Game with id {} does not exist", gameId);
            return ResponseEntity.notFound().build();
        } else {
            logger.info("Game with id {} has been retrieved successfully", gameId);
            return ResponseEntity.ok().body(game);
        }
    }

    /**
     * Retrieves game report data
     * @return
     */
    @GetMapping(value = EndPoint.GAME_REPORT)
    public ResponseEntity<GameReport> getGameReport() {

        logger.info("Fetching game report");
        return ResponseEntity.ok().body(gamesService.getGameReport());
    }

}
