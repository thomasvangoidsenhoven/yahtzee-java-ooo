package model.categories;

import model.*;

import java.util.*;

public class LargeStraight implements Category {
    private DiceCup diceCup;
    private CategoryType type = CategoryType.LARGE_STRAIGHT;

    @Override
    public int getScore() {
        return this.berekenScore();
    }
    public CategoryType getCategoryType() {
        return type;
    }

    public LargeStraight(DiceCup diceCup){
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
        List<Integer> values = new ArrayList<>();

        for(Dice dice : diceCup.getDiceList()) {
            values.add(dice.getEyes());
        }
        if(values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5) && ((values.contains(1) || values.contains(6)) ) ){
            return 40;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Large Straight";
    }
}
