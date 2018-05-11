package model;

import java.util.List;

public class GameSuite
{
    private YahtzeeGame yahtzeeGame;
    private PlayerGroup playerGroup = new PlayerGroup();

    public void createPlayer(String username)
    {
        playerGroup.addPlayer(new Player(username));
    }
    public List<Player> getPlayers(){ return  playerGroup.getPlayers(); }

    public void playYahtzee()
    {
        yahtzeeGame = new YahtzeeGame(playerGroup);
    }

    public YahtzeeGame getYahtzeeGame() {
        return yahtzeeGame;
    }
}
