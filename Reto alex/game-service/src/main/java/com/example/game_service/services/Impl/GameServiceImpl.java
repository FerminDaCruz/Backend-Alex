package com.example.game_service.services.Impl;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.commons.exceptions.GameException;
import com.example.game_service.repositories.GameRepository;
import com.example.game_service.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest) {
        Game gameCreatedInDatabase = this.gameRepository.save(gameRequest);
        return gameCreatedInDatabase;
    }

    @Override
    public Game getGameById(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Error finding game"));
    }

    @Override
    public Game updateGame(Long id, Game updatedGame) {
        Game existingGame = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        existingGame.setName(updatedGame.getName());
        existingGame.setId(updatedGame.getId());

        return gameRepository.save(existingGame);
    }

    @Override
    public void deleteGame(Long id) {
        Game existingGame = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found"));
        gameRepository.delete(existingGame);

    }
}
