package com.rowney.PokemonTournament.model;

import com.rowney.PokemonTournament.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RuleConverter implements Converter<String, Rule> {


    @Autowired
    private RuleService ruleService;

    @Override
    public Rule convert(String id) {

        List<Rule> defaultRules = ruleService.getDefaultRules();
        return defaultRules.get(Integer.parseInt(id));
    }
}
