package model;

public class YahtzeeGame
{
    private PlayerGroup group;


    public YahtzeeGame(PlayerGroup group)
    {
        this.group = group;
    }


    public DiceCollection roll(String playerId)
    {
        DiceCollection collection = new DiceCollection(5);

        collection.roll();
        return  collection;

    }


    public void play(String playerId, Category category, Dice[] dice)
    {

    }

    public int getScore(String playerId, Category categoryType)
    {
      return 0;
    }
}
