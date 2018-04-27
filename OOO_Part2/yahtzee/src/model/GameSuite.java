package model;

public class GameSuite
{
    private PlayerGroup playerGroup = new PlayerGroup();

    public void createPlayer(String username)
    {
        playerGroup.addPlayer(new Player(username));
    }
}
