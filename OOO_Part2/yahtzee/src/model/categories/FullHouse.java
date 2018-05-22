package model.categories;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class FullHouse implements Category {
    private DiceCup diceCup;
    private CategoryType type = CategoryType.FULL_HOUSE;


    @Override
    public int getScore() {
        return this.berekenScore();
    }
    public CategoryType getCategoryType() {
        return type;
    }

    public FullHouse(DiceCup diceCup){
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

        for(Dice dice : diceCup.getDices()) {
            values.add(dice.getEyes());
        }
        int number1 = values.get(0);
        int amount1=0;
        int number2 = 0;
        int amount2 =0;
        for(int i : values) {
            if(number2 == 0 && i != number1) {
                number2= i;
                amount2++;
            }
            else if(number1 == i){
                amount1++;
            }
            else if(number2 == i){
                amount2++;
            }
            else{
                return 0;
            }
        }
        if((amount1 == 2 && amount2 == 3)|| (amount1 == 3 && amount2==2)) {
            return 25;
        }
        else return 0;
    }

    @Override
    public String toString() {
        return "FULL_HOUSE";
    }
}
