package com.rowney.PokemonTournament.model.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Player {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private int score;
//    private String playersPokemon;
}