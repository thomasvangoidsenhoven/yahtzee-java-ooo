package model;

import model.observer.ScreenObserver;
import model.observer.YahtzeeSubject;
import model.singleton.Scoreboard;

import java.util.List;
import java.util.Map;

public class YahtzeeGame implements YahtzeeSubject
{
    private PlayerGroup group;
    private DiceRoll diceRoll;
    private Scoreboard scoreboard;


    public YahtzeeGame(PlayerGroup group)
    {
        this.group = group;
        diceRoll = new DiceRoll(3,5);
    }

    public void initScoreboard()
    {
        this.scoreboard = Scoreboard.getInstance(group);
    }

    public Map<Player,List> getScoreboardInfo()
    {
        return this.scoreboard.getInfo();
    }

    public void endGame()
    {

    }

    public void restart()
    {

    }


    public Player getWinner()
    {
        Player winner = null;

        for(Player p : group.getPlayers())
        {
            if(winner == null ) winner = p;
            if(winner != null && winner.getTotalScore() < p.getTotalScore()) winner = p;
        }

        return winner;
    }


    public void resetDice()
    {
        diceRoll.resetDice();

    }


    public boolean isGameOver()
    {
        boolean result = false;
        int amount = 0;
        for(Player player : group.getPlayers())
        {
            if(player.hasFilledOutAllCategories()) amount++;
        }

        if(amount == group.getPlayers().size()) return true;
        return result;
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

    public List<Integer> getDiceCup() {
        return diceRoll.getDiceCup().getDices();
    }

    private void addCategoryToPlayer(String username, CategoryType categoryType){
        CategoryFactory categoryFactory = new CategoryFactory();

        Category category = categoryFactory.createCategory(categoryType, diceRoll.getDiceCup());
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
