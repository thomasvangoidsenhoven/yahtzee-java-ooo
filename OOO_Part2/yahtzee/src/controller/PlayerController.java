package controller;

import model.Dice;
import model.DiceCup;
import model.GameSuite;

import model.Player;
import ui.GameScreen;

import java.util.List;

public class PlayerController {
    private Player player;

    private GameSuite suite;
    private GameScreen screen;


    public PlayerController(Player player, GameSuite suite)
    {
        this.player = player;
        this.suite = suite;
        screen = new GameScreen(this);

    }

    public Player getPlayer()
    {
        return player;
    }


    public String getPlayerName() {
        return player.getUsername();
    }

    public GameSuite getSuite()
    {
        return this.suite;
    }

    public void roll(){
        suite.getYahtzeeGame().roll();
    }

    public void lock(int dice){
        suite.getYahtzeeGame().lock(dice);
    }

    public List<Dice> getDices(){
        return suite.getYahtzeeGame().getDiceCup();
    }

}
