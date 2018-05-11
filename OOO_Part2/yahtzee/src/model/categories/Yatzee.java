package model.categories;

import model.*;

public class Yatzee implements Category {
    private DiceCup diceCup;
    private CategoryType type = CategoryType.YAHTZEE;

    public CategoryType getCategoryType() {
        return type;
    }
    public Yatzee(DiceCup diceCup){
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
        int firstDice = diceCup.getDices().get(0).getEyes();
        for(Dice dice : diceCup.getDices()) {
            if(firstDice != dice.getEyes()) return 0;
        }
        return 50;
    }

    @Override
    public String toString() {
        return "YATZEE" ;
    }
}
