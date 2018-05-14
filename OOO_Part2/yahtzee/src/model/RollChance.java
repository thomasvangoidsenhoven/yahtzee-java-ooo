package model;

//put dicecup in RollChance?
public class RollChance {
    private int amount = 0;
    private final int init;

    public RollChance(int amount)
    {
        init = amount;
        this.amount = amount;
    }

    public void resetChances()
    {
        amount = init;
    }


    public void roll()
    {

        if(amount == 0) throw new IllegalStateException("nope");
        amount--;
        System.out.println("chances: " + amount);
    }

    public boolean isOnEndOfTurn()
    {
        if(amount == 0) return true;
        return false;
    }



}
