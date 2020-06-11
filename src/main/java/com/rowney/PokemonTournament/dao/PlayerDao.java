package com.rowney.PokemonTournament.dao;

import com.rowney.PokemonTournament.model.Player;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class PlayerDao extends CommonDao {

    private Statement statement;

    public Player getPlayerFromId(String playerId) throws SQLException {
        statement = createConnection();

        Player player = new Player();

        String sql = String.format("SELECT * FROM player WHERE id='%s'", playerId);

        statement.execute(sql);
        ResultSet resultSet = statement.getResultSet();

        while(resultSet.next()) {
            player.setPlayerId(playerId);
            player.setPlayerName(resultSet.getString("name"));
            player.setPlayerScore(resultSet.getInt("score"));
            //todo add teams
        }
        return player;
    }

    public void addPlayer(Player player) throws SQLException {
        statement = createConnection();

        String sql = String.format("INSERT INTO player (ID, NAME, SCORE) VALUES ('%s', '%s', '%s')", player.getPlayerId(), player.getPlayerName(), player.getPlayerScore());

        statement.execute(sql);
    }
}
