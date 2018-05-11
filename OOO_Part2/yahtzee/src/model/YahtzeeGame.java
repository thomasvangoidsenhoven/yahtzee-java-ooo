package model;

import java.util.List;

public class YahtzeeGame
{
    private PlayerGroup group;
    private DiceCup diceCup;


    public YahtzeeGame(PlayerGroup group)
    {
        this.group = group;
        diceCup = new DiceCup(5);
    }


    public DiceCup roll()
    {
        diceCup.roll();
        return  diceCup;

    }

    public void lock(int dice){
        diceCup.getDices().get(dice).setLock();
    }


    public void play(String playerId, Category category, Dice[] dice)
    {

    }

    public int getScore(String playerId, Category categoryType)
    {
      return 0;
    }

    public List<Dice> getDiceCup() {
        return diceCup.getDices();
    }

    public void addCategoryToPlayer(String username, CategoryTypes categoryTypes){
        CategoryFactory categoryFactory = new CategoryFactory();
        group.addCategoryToPlayer(categoryFactory.createCategory(categoryTypes,diceCup),username);
    }

}
