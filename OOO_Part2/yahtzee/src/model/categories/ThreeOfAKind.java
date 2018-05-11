package model.categories;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class ThreeOfAKind implements Category {
    private DiceCup diceCup;

    public ThreeOfAKind(DiceCup diceCup){
        setDiceCup(diceCup);
    }

    @Override
    public void setDiceCup(DiceCup diceCup) {
       if(diceCup.getDices().isEmpty() || diceCup == null){
           throw new IllegalArgumentException("Dice Collection is empty or does not exist");
       } else {
           this.diceCup = diceCup;
       }
    }

    @Override
    public int getScore() {
        List<Integer> values = new ArrayList<>();
        int points =0;
        for(Dice dice : diceCup.getDices()) {
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
            if(val == 1){
                ones ++;
            }
            else if(val == 2){
                twos ++;
            }
            else if(val == 3){
                threes ++;
            }
            else if(val == 4){
                fours ++;
            }
            else if(val == 5){
                fives ++;
            }
            else if(val == 5){
                fives ++;
            }
            else if(val == 6){
                sixes ++;
            }
        }

        if(ones == 3 || ones == 4 || ones == 5) {
            return points;
        }
        else if(twos == 3 || twos == 4|| twos == 5) {
            return points;
        }
        else if(threes == 3 || threes == 4 || threes == 5) {
            return points;
        }
        else if(fours == 3 || fours == 4 || fours == 5) {
            return points;
        }
        else if(fives == 3 || fives == 4 || fives == 5) {
            return points;
        }
        else if(sixes == 3 || sixes == 4 || sixes == 5) {
            return points;
        }
        else return 0;
    }

    @Override
    public String toString() {
        return "THREE_OF_A_KIND";
    }
}
