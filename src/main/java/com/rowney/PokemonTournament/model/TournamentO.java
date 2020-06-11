package com.rowney.PokemonTournament.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TournamentO {

    private String id;
    private String name;
    private Date creationDate;
    private List<Player> playerList;
    private List<Rule> ruleList;
}
