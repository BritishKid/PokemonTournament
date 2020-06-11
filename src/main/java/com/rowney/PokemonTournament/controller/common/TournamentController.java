package com.rowney.PokemonTournament.controller.common;

import com.rowney.PokemonTournament.model.TournamentO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

public interface TournamentController {

    public String getSelectionPage();

    public String getTournament(Model model, @ModelAttribute String tournamentId);

    public String createTournament(Model model, @ModelAttribute TournamentO tournamentO);

    public String newTournament(Model model);

    public String addRules(Model model, @ModelAttribute("tournamentO") TournamentO tournamentO);
}
