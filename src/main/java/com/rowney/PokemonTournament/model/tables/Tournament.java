package com.rowney.PokemonTournament.model.tables;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@Entity
public class Tournament {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private Date creationDate;
    private String playerList;
    private String ruleList; //1 for true 0 for active, in a single string which will hook them up
}
