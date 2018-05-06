package model.categories;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Yatzee implements Category {
    private DiceCollection diceCollection;
    private PlayerGroup playerGroup;
    private Player player;

    public Yatzee(DiceCollection diceCollection, PlayerGroup playerGroup, String username){
        setDiceCollection(diceCollection);
        setPlayerGroup(playerGroup);
        setPlayer(username);

    }

    @Override
    public void setDiceCollection(DiceCollection diceCollection) {
        if(diceCollection.getDices().isEmpty() || diceCollection == null){
            throw new IllegalArgumentException("Dice Collection is empty or does not exist");
        } else {
            this.diceCollection = diceCollection;
        }
    }

    @Override
    public void setPlayerGroup(PlayerGroup playerGroup) {
        if(playerGroup.getPlayers().isEmpty() || playerGroup == null){
            throw new IllegalArgumentException("Player Group is empty or does not exist");
        } else {
            this.playerGroup = playerGroup;
        }
    }

    @Override
    public void setPlayer(String username) {
        if(username.trim().isEmpty() || username == null){
            throw new IllegalArgumentException("playername can't be empty");
        } else {
            player = playerGroup.getPlayer(username);
        }
    }

    public void add() {
        player.getCatogories().add(this);
    }

    @Override
    public int getScore() {
        int firstDice = diceCollection.getDices().get(0).getEyes();
        for(Dice dice : diceCollection.getDices()) {
            if(firstDice != dice.getEyes()) return 0;
        }
        return 50;
    }

    @Override
    public String toString() {
        return "YATZEE" ;
    }
}
