package model.categories;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class FullHouse implements Category {
    private DiceCollection diceCollection;
    private PlayerGroup playerGroup;
    private Player player;

    public FullHouse(DiceCollection diceCollection, PlayerGroup playerGroup, String username){
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
        int number1 = values.get(0);
        int amount1=0;
        int number2 = 0;
        int amount2 =0;
        for(int i : values) {
            if(number2 == 0 && i != number1) {
                number2= i;
                amount2++;
            }
            else if(number1 == i){
                amount1++;
            }
            else if(number2 == i){
                amount2++;
            }
            else{
                return 0;
            }
        }
        if((amount1 == 2 && amount2 == 3)|| (amount1 == 3 && amount2==2)) {
            return 25;
        }
        else return 0;
    }

    @Override
    public String toString() {
        return "FULL_HOUSE";
    }
}
