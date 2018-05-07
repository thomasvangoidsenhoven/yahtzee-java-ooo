package controller;

import model.GameSuite;

import model.Player;
import ui.GameScreen;

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


    public String getPlayerName() {
        return player.getUsername();
    }


}
