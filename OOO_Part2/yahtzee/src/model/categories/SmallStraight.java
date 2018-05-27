package model.categories;

import exceptions.DomainException;
import model.*;

import java.util.*;

public class SmallStraight implements Category {
    private DiceCup diceCup;
    private CategoryType type = CategoryType.SMALL_STRAIGHT;

    public CategoryType getCategoryType() {
        return type;
    }

    public SmallStraight(DiceCup diceCup){
        setDiceCup(diceCup);

    }

    @Override
    public void setDiceCup(DiceCup diceCup) {
        if(diceCup == null || diceCup.getDices().isEmpty()){
            throw new DomainException("Dice Collection is empty or does not exist");
        } else {
            this.diceCup = new DiceCup(5);
            this.diceCup.clone(diceCup);
        }
    }

    @Override
    public int getScore() {
        return this.berekenScore();
    }


    @Override
    public int berekenScore() {
        List<Integer> values = new ArrayList<>();
        Set<Integer> duplicates = new HashSet<>();
        for(Dice dice : diceCup.getDiceList()) {
            values.add(dice.getEyes());
        }

        //Makes it possible to remove al duplicates by adding the arraylist to a set which doesn't add duplicates
        duplicates.addAll(values);
        values.clear();
        values.addAll(duplicates);

        Collections.sort(values);

        //If the array now has less than 4 values, the loop will throw an index out of bounds exception. This prevents this from happening
        values.add(10);
        values.add(10);
        values.add(10);
        values.add(10);

        int count = 1;
        for(int i=0; i<4; i++) {
            if(values.get(i) == values.get(i+1)-1) {
                count++;
                if(count==4){
                    return 30;
                }
            }
            else count = 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Small Straight";
    }
}
