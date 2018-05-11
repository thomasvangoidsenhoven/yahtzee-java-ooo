package model.categories;

import model.*;

public class Chance implements Category {
    private DiceCup diceCup;

    public Chance(DiceCup diceCup){
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
        int result=0;
        for(Dice dice : diceCup.getDices()) {
            result += dice.getEyes();
        }
        return result;
    }

    @Override
    public String toString() {
        return "CHANCE";
    }
}
