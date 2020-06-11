package com.rowney.PokemonTournament.service;

import com.rowney.PokemonTournament.dao.PlayerDao;
import com.rowney.PokemonTournament.dao.TournamentDao;
import com.rowney.PokemonTournament.model.Player;
import com.rowney.PokemonTournament.model.Rule;
import com.rowney.PokemonTournament.model.RuleConverter;
import com.rowney.PokemonTournament.model.TournamentO;
import com.rowney.PokemonTournament.model.tables.Tournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

@Service
public class TournamentService {

    @Autowired
    private TournamentDao tournamentDao;

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private RuleConverter ruleConverter;

    public TournamentO getTournamentFromId(String tournamentId) throws SQLException {

        Tournament tournament = tournamentDao.getTournamentFromId(tournamentId); //Player ids but not full player objects

        TournamentO tournamentO = new TournamentO();
        tournamentO.setId(tournament.getId());
        tournamentO.setName(tournament.getName());
        tournamentO.setCreationDate(tournament.getCreationDate());
        tournamentO.setPlayerList(convertPlayers(tournament));
        tournamentO.setRuleList(convertRule(tournament));

        return tournamentO;
    }

    private List<Rule> convertRule(Tournament tournament) {
        List<Rule> ruleList = new ArrayList<>();
        List<String> ruleIds = Arrays.asList(tournament.getRuleList().split(","));
        for (String ruleId : ruleIds) {
            ruleList.add(ruleConverter.convert(ruleId));
        }
        return ruleList;
    }

    private List<Player> convertPlayers(Tournament tournament) throws SQLException {
        List<Player> playerList = new ArrayList<>();
        List<String> playerIds = Arrays.asList(tournament.getPlayerList().split(","));
        for (String playerId : playerIds) {
            Player player = new Player();
            player.setPlayerId(playerId);
            playerList.add(player);
        }
        List<Player> correctedPlayerList = new ArrayList<>(); //todo fix

        for (int i = 0; i < playerList.size(); i++) {
            Player player = playerList.get(i);
            correctedPlayerList.add(playerDao.getPlayerFromId(player.getPlayerId()));
        }

        correctedPlayerList.sort(Comparator.comparingInt(Player::getPlayerScore)); //todo look into comparitors and invert order
        return correctedPlayerList;
    }

    public TournamentO createTournament(TournamentO tournamentO) {

        tournamentO.setId(UUID.randomUUID().toString());

        try {
            tournamentDao.newTournament(tournamentO);
        } catch (SQLException e) {
            e.printStackTrace(); //todo better handling
        }

        return tournamentO;
    }

    public void updateRulesForTournament(TournamentO tournamentO) {
        try {
            String ruleString = convertToSingleString(tournamentO.getRuleList());
            tournamentDao.updateRulesForTournament(tournamentO, ruleString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String convertToSingleString(List<Rule> ruleList) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(ruleList.get(0).getId());

        for (int i = 1; i < ruleList.size(); i++) {
            stringBuffer.append(","+ruleList.get(i).getId());
        }

        return stringBuffer.toString();
    }

    public void addNewPlayers(Tournament tournament) {
        String[] playerNames = tournament.getPlayerList().split(",");
        List<Player> playerList = new ArrayList<>();

        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (String playerName : playerNames) {
                Player player = new Player();
                player.setPlayerName(playerName);
                player.setPlayerId(UUID.randomUUID().toString());
                player.setPlayerScore(0);
                playerDao.addPlayer(player);
                stringBuffer.append(player.getPlayerId() + ",");
                playerList.add(player);
            }
            tournamentDao.addPlayer(tournament.getId(), stringBuffer.toString());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}