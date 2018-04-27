package model;

public class Player
{
    private String username;

    public Player(String username)
    {
        setUsername(username);
    }

    public String getUsername()
    {
        return  username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
