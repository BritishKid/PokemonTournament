package com.rowney.PokemonTournament.dao;

import com.rowney.PokemonTournament.model.Player;
import com.rowney.PokemonTournament.model.Rule;
import com.rowney.PokemonTournament.model.TournamentO;
import com.rowney.PokemonTournament.model.tables.Tournament;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class TournamentDao extends CommonDao {

    private Statement statement;

    public Tournament getTournamentFromId(String tournamentId) throws SQLException {
        statement = createConnection();

        Tournament tournament = new Tournament();

        String sql = String.format("Select * FROM tournament WHERE ID='%s';", tournamentId);
        statement.execute(sql);
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            tournament.setId(resultSet.getString("id"));
            tournament.setName(resultSet.getString("name"));
            tournament.setCreationDate(resultSet.getDate("creation_Date"));
            tournament.setPlayerList(resultSet.getString("player_list"));
            tournament.setRuleList(resultSet.getString("rule_list"));
        }

        return tournament;
    }

    public void newTournament(TournamentO tournamentO) throws SQLException {
        statement = createConnection();

        String sql = String.format("INSERT INTO tournament (ID, NAME) VALUES ('%s', '%s')", tournamentO.getId(), tournamentO.getName());
        statement.execute(sql);
    }

    public void updateRulesForTournament(TournamentO tournamentO, String ruleString) throws SQLException {
        statement = createConnection();

        String sql = String.format("UPDATE tournament SET rule_list = '%s' WHERE id = '%s'", ruleString, tournamentO.getId());
        statement.executeUpdate(sql);
    }

    public void addPlayer(String id, String playerIds) throws SQLException {
        statement = createConnection();

        String sql = String.format("UPDATE tournament SET player_list = '%s' WHERE id = '%s'", playerIds, id); //todo generic update?
        statement.executeUpdate(sql);
    }
}

