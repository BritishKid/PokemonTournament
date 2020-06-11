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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getPlayerList() {
        return playerList;
    }

    public void setPlayerList(String playerList) {
        this.playerList = playerList;
    }

    public String getRuleList() {
        return ruleList;
    }

    public void setRuleList(String ruleList) {
        this.ruleList = ruleList;
    }
}
