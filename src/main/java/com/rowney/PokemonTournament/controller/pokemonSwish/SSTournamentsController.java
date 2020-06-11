package com.rowney.PokemonTournament.controller.pokemonSwish;

import com.rowney.PokemonTournament.controller.common.TournamentController;
import com.rowney.PokemonTournament.model.Player;
import com.rowney.PokemonTournament.model.Rule;
import com.rowney.PokemonTournament.model.TournamentO;
import com.rowney.PokemonTournament.model.tables.Tournament;
import com.rowney.PokemonTournament.service.RuleService;
import com.rowney.PokemonTournament.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
public class SSTournamentsController implements TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private RuleService ruleService;

    @Override
    @RequestMapping("/pokemonss/view")
    public String getSelectionPage() {
        return "findsstournament";
    }

    @Override
    @RequestMapping("/pokemonss/find")
    public String getTournament(Model model, @RequestParam String tournamentId) {

        TournamentO tournamentO = null;
        try {
            tournamentO = tournamentService.getTournamentFromId(tournamentId);
        } catch (SQLException e) {
            e.printStackTrace();

            //todo handle
        }
        model.addAttribute("tournamentO", tournamentO);

        return "viewsstournament";
    }

    @Override
    @RequestMapping("/pokemonss/create")
    public String createTournament(Model model, @ModelAttribute TournamentO tournamentO) {
        tournamentService.createTournament(tournamentO);
        List<Rule> rules = ruleService.getDefaultRules();


        model.addAttribute("tournamentO", tournamentO);
        model.addAttribute("rules", rules);

        return "addrules";
    }

    @Override
    @RequestMapping("/pokemonss/new")
    public String newTournament(Model model) {
        model.addAttribute("tournamentO", new TournamentO());
        return "newtournament";
    }

    @Override
    @RequestMapping("/pokemonss/addrules")
    public String addRules(Model model, @ModelAttribute("tournamentO") TournamentO tournamentO) {
        model.addAttribute("player", new Player());
        tournamentService.updateRulesForTournament(tournamentO);
        model.addAttribute("tournament", new TournamentO());


        return "addplayers";
    }

    @PostMapping("/pokemonss/addplayers")
    public String addPlayers(Model model, @ModelAttribute("tournament") TournamentO tournament) {
        Tournament tournament1 = new Tournament();
        tournament1.setId(tournament.getId());
        tournament1.setPlayerList(tournament.getName());
        tournamentService.addNewPlayers(tournament1);
        model.addAttribute("tournamentO", tournament);
        return "tournamentcreated";
    }
}