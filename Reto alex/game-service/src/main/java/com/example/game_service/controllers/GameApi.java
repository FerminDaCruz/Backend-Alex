package com.example.game_service.controllers;

import com.example.game_service.commons.constants.ApiPathVariables;
import com.example.game_service.commons.entities.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathVariables.V1_ROUTE + ApiPathVariables.GAME_ROUTE)
public interface GameApi {
    @PostMapping
    ResponseEntity<Game> saveGame(@RequestHeader("userIdRequest") String userId, @RequestBody Game game);
    @GetMapping("/{id}")
    ResponseEntity<Game> getGameById(@PathVariable String id);
    @PutMapping("/{id}")
    ResponseEntity<Game> updateGame(@PathVariable Long id, @RequestBody Game updatedGame);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGame(@PathVariable Long id);

}
