package model;

import java.util.ArrayList;
import java.util.List;

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
            if (!dice.isLocked())
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
        return diceList.get(index);
    }

    public List<Integer> getDices() {
        List<Integer> integers = new ArrayList<>();

        for(Dice dice : diceList)
        {
            integers.add(dice.getEyes());
        }
        return integers;
    }

    public List<Dice> getDiceList()
    {
        return this.diceList;
    }

    public String toString(){
        String test ="";

        for (Dice dice: diceList) {
           test += dice.toString();
        }
        return test;
    }

    public void clone(DiceCup diceCup)
    {
        this.diceList = new ArrayList<>();

        for(Dice dice : diceCup.getDiceList())
        {
            diceList.add(new Dice(dice.getEyes()));
        }
    }


}
