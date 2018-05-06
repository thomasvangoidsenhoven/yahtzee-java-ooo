package model.categories;

import model.*;

import java.util.*;

public class SmallStraight implements Category {
    private DiceCollection diceCollection;
    private PlayerGroup playerGroup;
    private Player player;

    public SmallStraight(DiceCollection diceCollection, PlayerGroup playerGroup, String username){
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
        Set<Integer> duplicates = new HashSet<>();
        for(Dice dice : diceCollection.getDices()) {
            values.add(dice.getEyes());
        }

        //Makes it possible to remove al duplicates by adding the arraylist to a set which doesn't add duplicates
        duplicates.addAll(values);
        values.clear();
        values.addAll(duplicates);

        Collections.sort(values);

        //If the array now has less than 4 values, the loop will throw an index out of bounds exception. This prevents this from happening
        values.add(10);
        values.add(10);
        values.add(10);
        values.add(10);

        int count = 1;
        for(int i=0; i<4; i++) {
            if(values.get(i) == values.get(i+1)-1) {
                count++;
                if(count==4){
                    return 30;
                }
            }
            else count = 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "SMALL_STRAIGHT";
    }
}
