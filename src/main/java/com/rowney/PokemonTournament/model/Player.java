package com.rowney.PokemonTournament.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Player {

    private String playerId;
    private String playerName;
    private int playerScore;
    private List<Pokemon> playersPokemon;

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public List<Pokemon> getPlayersPokemon() {
        return playersPokemon;
    }

    public void setPlayersPokemon(List<Pokemon> playersPokemon) {
        this.playersPokemon = playersPokemon;
    }
}
