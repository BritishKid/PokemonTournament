package com.rowney.PokemonTournament.model;

import lombok.Getter;

@Getter
public class Pokemon {

    private String pokemonId;
    private String pokemonName;

    public String getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(String pokemonId) {
        this.pokemonId = pokemonId;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }
}
