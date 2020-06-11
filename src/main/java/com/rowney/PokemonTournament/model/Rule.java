package com.rowney.PokemonTournament.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rule {

    private int id;
    private String rule;
    private boolean active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
