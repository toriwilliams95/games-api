package tori.williams.gamesapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tori.williams.gamesapi.model.Game;
import tori.williams.gamesapi.model.GameReport;
import tori.williams.gamesapi.service.GamesService;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GamesControllerTest {

    @Mock
    private GamesService gamesService;

    @InjectMocks
    private GamesController gamesController;

    @Mock
    private Game game;

    @Mock
    private GameReport gameReport;

    @Test
    void testRetrievingGameByIdSuccessfully() {

        int gameId = 1;

        when(gamesService.getGameById(gameId)).thenReturn(game);

        ResponseEntity<Game> response = gamesController.getGameById(gameId);

        assertEquals(game, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void testRetrievingGamesReportSuccessfully() {

        when(gamesService.getGameReport()).thenReturn(gameReport);

        ResponseEntity<GameReport> response = gamesController.getGameReport();

        assertEquals(gameReport, response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testReponseWhenGameByIdIsNull() {

        int gameId = 1;

        when(gamesService.getGameById(gameId)).thenReturn(null);

        ResponseEntity<Game> response = gamesController.getGameById(gameId);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }
}
