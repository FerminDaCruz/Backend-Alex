package com.example.game_service.controllers.impl;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.controllers.GameApi;
import com.example.game_service.services.GameService;
import com.example.game_service.services.Impl.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController implements GameApi {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    @Override
    public ResponseEntity<Game> saveGame(@RequestHeader String userId, @RequestBody Game game) {
        System.out.println(userId);

        Game gamecreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gamecreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return  ResponseEntity.ok(this.gameService.getGameById(id));
    }

    @Override
    public ResponseEntity<Game> updateGame(Long id, Game updatedGame) {
        Game game = gameService.updateGame(id, updatedGame);
        return ResponseEntity.ok(game);
    }

    @Override
    public ResponseEntity<Void> deleteGame(Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}
