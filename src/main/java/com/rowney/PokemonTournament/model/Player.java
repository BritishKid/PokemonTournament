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
}
