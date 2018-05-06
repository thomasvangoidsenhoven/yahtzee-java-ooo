package model.categories;

import model.*;

import java.util.*;

public class LargeStraight implements Category {
    private DiceCollection diceCollection;
    private PlayerGroup playerGroup;
    private Player player;

    public LargeStraight(DiceCollection diceCollection, PlayerGroup playerGroup, String username){
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
        List<Integer> values = new ArrayList<>();

        for(Dice dice : diceCollection.getDices()) {
            values.add(dice.getEyes());
        }
        if(values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5) && (values.contains(1) || values.contains(6))){
            return 40;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "LARGE_STRAIGHT";
    }
}
