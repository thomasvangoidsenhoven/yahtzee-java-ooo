package model;

import model.observer.ScreenObserver;
import model.observer.YahtzeeSubject;

import java.util.List;

public class YahtzeeGame implements YahtzeeSubject
{
    private PlayerGroup group;
    private DiceCup diceCup;
    private DiceRoll diceRoll;


    public YahtzeeGame(PlayerGroup group)
    {
        this.group = group;
        diceCup = new DiceCup(5);
        diceRoll = new DiceRoll(4);



    }


    public void resetDice()
    {
        diceCup.reset();

    }


    public Player getCurrentPlayer()
    {
        return group.getCurrentPlayer();
    }

    public Player goNextPlayer()
    {
        Player player = group.goNextPlayer();
        resetDice();
        roll();
        notifyObservers();
        return player;

    }

    public void roll()
    {
        diceCup.roll();
        diceRoll.roll();
        notifyObservers();
    }

    public void lock(int index){
        diceCup.getDiceOnIndex(index).setLock();
        notifyObservers();
    }

    public boolean isLocked(int index)
    {
        return diceCup.getDiceOnIndex(index).isLock();
    }


    //choose category
    public void play(String playerId, CategoryType category)
    {
        diceRoll.resetChances();
        addCategoryToPlayer(playerId,category);
        notifyObservers();
    }

    public int getScore(String playerId, CategoryType categoryType)
    {
        return group.getPlayer(playerId).getCategoryByType(categoryType).getScore();
    }

    public List<Dice> getDiceCup() {
        return diceCup.getDices();
    }

    private void addCategoryToPlayer(String username, CategoryType categoryType){
        CategoryFactory categoryFactory = new CategoryFactory();
        group.addCategoryToPlayer(categoryFactory.createCategory(categoryType,diceCup),username);
    }

    @Override
    public void registerObserver(ScreenObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(ScreenObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(ScreenObserver observer : observers)
        {
            observer.update();
        }
    }
}
