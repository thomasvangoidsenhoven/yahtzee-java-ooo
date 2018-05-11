package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiceCup {
    private List<Dice> diceList;

    //yatzee uses 5 dices
    public DiceCup(int dices) {
        diceList = new ArrayList<>();
        for (int i = 0; i < dices; i++) {
            diceList.add(new Dice());
        }
    }

    //TESPURPOSE CONSTRUCTOR
    public DiceCup(List<Dice> dices) {
        diceList = dices;
    }

    public void roll() {
        for (Dice dice : diceList) {
            if (!dice.isLock())
                dice.roll();
        }
    }

    public void reset(){
        for(Dice d : diceList){
            d.reset();
        }
    }

    public Dice getDiceOnIndex(int index)
    {
        return this.getDices().get(index);
    }

    public List<Dice> getDices() {
        return diceList;
    }

    public String toString(){
        String test ="";

        for (Dice dice: diceList) {
           test += dice.toString();
        }
        return test;
    }



}
