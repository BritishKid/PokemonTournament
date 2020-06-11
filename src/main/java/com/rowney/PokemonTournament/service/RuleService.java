package com.rowney.PokemonTournament.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.rowney.PokemonTournament.model.Rule;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RuleService {
    public List<Rule> getDefaultRules() {

        List<Rule> rules = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = ResourceUtils.getFile("classpath:json/SSRule.json");
            CollectionType listType = mapper.getTypeFactory()
                        .constructCollectionType(ArrayList.class, Rule.class);
            rules = mapper.readValue(file, listType);
        } catch (FileNotFoundException e) {
            e.printStackTrace(); //todo handle
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rules;
    }
}
