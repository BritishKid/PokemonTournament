package com.rowney.PokemonTournament.controller.pokemonSwish;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PokemonSSController {

    @RequestMapping("/pokemonss")
    public String getSelectionPage() {
        return "pokemonss";
    }

}
