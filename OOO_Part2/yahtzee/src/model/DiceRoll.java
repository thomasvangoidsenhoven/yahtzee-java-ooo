package model;

import exceptions.DomainException;

import java.util.List;

//put dicecup in DiceRoll?
public class DiceRoll {
    private int amount;
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

    public DiceCup getDiceCupAsList()
    {

        return this.diceCup;
    }

    public boolean isDiceLockedOnIndex(int index)
    {
        if(index <0 || index >= getDiceCupAsList().getDiceList().size()) throw new DomainException("invalid index argument");
        return this.getDiceOnIndex(index).isLocked();
    }

    public void lockDiceOnIndex(int index)
    {
        this.getDiceOnIndex(index).setLock();
    }

    private Dice getDiceOnIndex(int index)
    {
        if(index <0 || index >= getDiceCupAsList().getDiceList().size()) throw new DomainException("invalid index argument");
        return diceCup.getDiceOnIndex(index);
    }

    public void roll()
    {
        if(amount == 0) throw new DomainException("you do not have any more chances");
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
