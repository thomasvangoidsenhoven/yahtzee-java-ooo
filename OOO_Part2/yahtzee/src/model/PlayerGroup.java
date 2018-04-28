package model;


import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

public class PlayerGroup
{
    private Map<String,Player> players;


    public PlayerGroup()
    {
        players = new HashMap<>();
    }

    public void addPlayer(Player player)
    {
        //TODO what if 2 players have the same name?
        players.put(player.getUsername(),player);
    }

    public Player getPlayer(String username)
    {
        return players.get(username);
    }

    public List<Player> getPlayers()
    {
        return new ArrayList<>(players.values());
    }
}
