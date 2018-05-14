package model;

//put dicecup in DiceRoll?
public class DiceRoll {
    private int amount = 0;
    private final int init;

    public DiceRoll(int amount)
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
