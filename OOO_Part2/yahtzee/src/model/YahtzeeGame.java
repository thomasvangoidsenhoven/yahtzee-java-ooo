package model;

import model.observer.ScreenObserver;
import model.observer.YahtzeeSubject;

import java.util.List;

public class YahtzeeGame implements YahtzeeSubject
{
    private PlayerGroup group;
    private DiceRoll diceRoll;


    public YahtzeeGame(PlayerGroup group)
    {
        this.group = group;
        diceRoll = new DiceRoll(3,5);
    }


    public void resetDice()
    {
        diceRoll.resetDice();

    }


    public Player getCurrentPlayer()
    {
        return group.getCurrentPlayer();
    }

    public Player goNextPlayer()
    {
        Player player = group.goNextPlayer();
        resetDice();
        //roll();
        notifyObservers();
        return player;

    }

    public void roll()
    {
        diceRoll.roll();
        notifyObservers();
    }

    public void lock(int index){
        diceRoll.lockDiceOnIndex(index);
        notifyObservers();
    }

    public boolean isLocked(int index)
    {
        return diceRoll.isDiceLockedOnIndex(index);
    }


    //choose category
    public void play(String playerId, CategoryType category)
    {
        diceRoll.resetChances();
        addCategoryToPlayer(playerId,category);
        System.out.println(group.getPlayer(playerId).getUsername() + " has categories: " + group.getPlayer(playerId).getScoresAndCategories());
        notifyObservers();
    }

    public int getScore(String playerId, CategoryType categoryType)
    {
        //TODO Principle of Least Knowledge
        return group.getPlayer(playerId).getCategoryByType(categoryType).berekenScore();
    }

    public List<Dice> getDiceCup() {
        return diceRoll.getDiceCupAsList();
    }

    private void addCategoryToPlayer(String username, CategoryType categoryType){
        CategoryFactory categoryFactory = new CategoryFactory();
        //TODO should category know the DiceCup object or just a list of dices?
        Category category = categoryFactory.createCategory(categoryType, diceRoll.getDiceCup());
        category.setScore();
        group.addCategoryToPlayer(category,username);
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
