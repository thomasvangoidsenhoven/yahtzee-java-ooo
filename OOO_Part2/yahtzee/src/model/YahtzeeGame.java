package model;

import model.observer.ScreenObserver;
import model.observer.YahtzeeSubject;

import java.util.List;

public class YahtzeeGame implements YahtzeeSubject
{
    private PlayerGroup group;
    private DiceCup diceCup;


    public YahtzeeGame(PlayerGroup group)
    {
        this.group = group;
        diceCup = new DiceCup(5);

    }


    public void roll()
    {
        diceCup.roll();
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
    public void play(String playerId, CategoryTypes category, Dice[] dice)
    {
        addCategoryToPlayer(playerId,category);
        notifyObservers();
    }

    public int getScore(String playerId, Category categoryType)
    {
        //TODO
      return 0;
    }

    public List<Dice> getDiceCup() {
        return diceCup.getDices();
    }

    private void addCategoryToPlayer(String username, CategoryTypes categoryTypes){
        CategoryFactory categoryFactory = new CategoryFactory();
        group.addCategoryToPlayer(categoryFactory.createCategory(categoryTypes,diceCup),username);
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
