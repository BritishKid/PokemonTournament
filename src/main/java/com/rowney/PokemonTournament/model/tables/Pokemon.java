package com.rowney.PokemonTournament.model.tables;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Pokemon {

    @Id
    @GeneratedValue
    private String pokemonId;
    private String pokemonName;
}
