package model.categories;

import model.*;

public class Chance implements Category {
    private DiceCup diceCup;
    private CategoryType type = CategoryType.CHANCE;


    @Override
    public int getScore() {
        return this.berekenScore();
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
            this.diceCup = new DiceCup(5);
            this.diceCup.clone(diceCup);
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
