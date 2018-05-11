package model.categories;

import model.*;

public class NumberCombos implements Category {
    private DiceCup diceCup;
    private int number;

    public NumberCombos(DiceCup diceCup, int number){
        setDiceCup(diceCup);
        this.number = number;

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
        int result = 0;
        for(Dice dice : diceCup.getDices()) {
            if(dice.getEyes() == this.number){
                result += this.number;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "COMBO_FOR_NUMBER_"+this.number;
    }
}
