package model;

import java.util.List;

//put dicecup in DiceRoll?
public class DiceRoll {
    private int amount = 0;
    private final int init;
    private DiceCup diceCup;


    public DiceRoll(int chances, int cupSize)
    {
        diceCup = new DiceCup(cupSize);
        init = chances;
        this.amount = chances;
    }

    public void resetChances()
    {
        amount = init;
    }

    public void resetDice()
    {
        diceCup.reset();

    }

    public DiceCup getDiceCup() {
        return diceCup;
    }

    public List<Dice> getDiceCupAsList()
    {

        return this.diceCup.getDices();
    }

    public boolean isDiceLockedOnIndex(int index)
    {

        return this.getDiceOnIndex(index).isLocked();
    }

    public void lockDiceOnIndex(int index)
    {
        this.getDiceOnIndex(index).setLock();
    }

    private Dice getDiceOnIndex(int index)
    {

        return diceCup.getDiceOnIndex(index);
    }

    public void roll()
    {
        if(amount == 0) throw new IllegalStateException("nope");
        diceCup.roll();
        amount--;
        System.out.println("chances: " + amount);
    }

    public boolean isOnEndOfTurn()
    {
        if(amount == 0) return true;
        return false;
    }



}
