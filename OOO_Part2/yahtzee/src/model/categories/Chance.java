package model.categories;

import model.*;

public class Chance implements Category {
    private DiceCup diceCup;
    private CategoryType type = CategoryType.CHANCE;
    private int score;
    @Override
    public void setScore() {
        this.score = berekenScore();
    }

    @Override
    public int getScore() {
        return score;
    }

    public CategoryType getCategoryType() {
        return type;
    }

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
    public int berekenScore() {
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
