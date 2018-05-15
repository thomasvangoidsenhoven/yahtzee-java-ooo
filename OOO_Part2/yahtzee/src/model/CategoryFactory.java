package model;

import model.categories.*;

public class CategoryFactory
{

    /*THREE_OF_A_KIND,
    FOUR_OF_A_KIND,
    FULL_HOUSE,
    SMALL_STRAIGHT,
    LARGE_STRAIGHT,
    YAHTZEE,
    CHANCE*/


    public Category createCategory(CategoryType categoryType, DiceCup diceCup)
    {

        Category category = null;

        switch (categoryType.toString())
        {
            case "THREE_OF_A_KIND":
                category = new ThreeOfAKind(diceCup);
                break;

            case "FOUR_OF_A_KIND":
                category = new FourOfAKind(diceCup);
                break;
            case "LARGE_STRAIGHT":
                category = new LargeStraight(diceCup);
                break;
            case "SMALL_STRAIGHT":
                category = new SmallStraight(diceCup);
                break;
            case "YAHTZEE":
                category = new Yatzee(diceCup);
                break;
            case "FULL_HOUSE":
                category = new FullHouse(diceCup);
                break;
            case "CHANCE":
                category = new Chance(diceCup);
                break;
            case "ACES":
                category = new NumberCombos(diceCup,1);
                break;
            case "TWOS":
                category = new NumberCombos(diceCup,2);
                break;
            case "THREES":
                category = new NumberCombos(diceCup,3);
                break;
            case "FOURS":
                category = new NumberCombos(diceCup,4);
                break;
            case "FIVES":
                category = new NumberCombos(diceCup,5);
                break;
            case "SIXES":
                category = new NumberCombos(diceCup,6);
                break;
        }
        return category;
    }

}
