package model.categories;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class FourOfAKind implements Category {
    private DiceCollection diceCollection;
    private PlayerGroup playerGroup;
    private Player player;

    public FourOfAKind(DiceCollection diceCollection, PlayerGroup playerGroup, String username){
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
        int points =0;
        for(Dice dice : diceCollection.getDices()) {
            values.add(dice.getEyes());
            points += dice.getEyes();
        }

        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        int fives = 0;
        int sixes = 0;

        for(int val : values) {
            if(val == 1) ones ++;
            else if(val == 2) twos ++;
            else if(val == 3) threes ++;
            else if(val == 4) fours ++;
            else if(val == 5) fives ++;
            else if(val == 5) fives ++;
            else if(val == 6) sixes ++;
        }

        if( ones == 4 || ones == 5) { return points; }
        else if(twos == 4|| twos == 5) { return points; }
        else if(threes == 4 || threes == 5) { return points; }
        else if(fours == 4 || fours == 5) { return points; }
        else if(fives == 4 || fives == 5) { return points; }
        else if(sixes == 4 || sixes == 5) { return points; }
        else return 0;
    }

    @Override
    public String toString() {
        return "FOUR_OF_A_KIND";
    }
}
