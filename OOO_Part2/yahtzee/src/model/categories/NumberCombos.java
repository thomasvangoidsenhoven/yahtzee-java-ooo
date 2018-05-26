package model.categories;

import model.*;

public class NumberCombos implements Category {
    private DiceCup diceCup;
    private int number;
    private CategoryType type;

    @Override
    public int getScore() {
        return this.berekenScore();
    }

    public CategoryType getCategoryType() {
        return type;
    }

    public NumberCombos(DiceCup diceCup, int number){
        setDiceCup(diceCup);
        this.number = number;
        setCategory(number);

    }

    private void setCategory(int number)
    {
        switch (number)
        {
            default:
                throw new IllegalArgumentException();
            case 1:
                type = CategoryType.ACES;
                break;
            case 2:
                type = CategoryType.TWOS;
                break;
            case 3:
                type = CategoryType.THREES;
                break;
            case 4:
                type = CategoryType.FOURS;
                break;
            case 5:
                type = CategoryType.FIVES;
                break;
            case 6:
                type = CategoryType.SIXES;
                break;
        }
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
        int result = 0;
        for(Dice dice : diceCup.getDiceList()) {
            if(dice.getEyes() == this.number){
                result += this.number;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String toSring = "";
        switch (this.number) {
            case 1:
                toSring = "Ones";
                break;
            case 2:
                toSring = "Twos";
                break;
            case 3:
                toSring = "Threes";
                break;
            case 4:
                toSring = "Fours";
                break;
            case 5:
                toSring = "Fives";
                break;
            case 6:
                toSring = "Sixes";
                break;
        }
        return toSring;
    }
}
