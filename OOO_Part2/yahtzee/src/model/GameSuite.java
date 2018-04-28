package model;

import java.util.List;

public class GameSuite
{
    private PlayerGroup playerGroup = new PlayerGroup();

    public void createPlayer(String username)
    {
        playerGroup.addPlayer(new Player(username));
    }
    public List<Player> getPlayers(){ return  playerGroup.getPlayers(); }
}
