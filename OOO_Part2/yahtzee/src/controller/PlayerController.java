package controller;

import model.CategoryType;
import model.Dice;
import model.GameSuite;

import model.Player;
import model.observer.ScreenObserver;
import ui.GameScreen;

import java.util.List;

public class PlayerController {
    private Player yourPlayer;

    private GameSuite suite;
    private GameScreen screen;


    public PlayerController(Player currentPlayer, GameSuite suite)
    {
        this.yourPlayer = currentPlayer;
        this.suite = suite;
        screen = new GameScreen(this);

    }

    public void registerObserver(ScreenObserver observer)
    {
        suite.registerYahtzeeObserver(observer);
    }

    public void chooseCategory(String playerId, String category)
    {
        suite.getYahtzeeGame().play(playerId, CategoryType.valueOf(category.toUpperCase()));
    }

    //player who's currently playing
    public Player getCurrentPlayer()
    {
        return suite.getYahtzeeGame().getCurrentPlayer();
    }

    public Player goNextPlayer()
    {
        return suite.getYahtzeeGame().goNextPlayer();
    }

    public Player getYourPlayer()
    {
        return yourPlayer;
    }

    public boolean isDiceLocked(int index)
    {
        return suite.getYahtzeeGame().isLocked(index);
    }

    public String getPlayerName() {
        return yourPlayer.getUsername();
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
