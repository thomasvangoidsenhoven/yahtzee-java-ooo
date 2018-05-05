package model;

public interface Category {
    void setDiceCollection(DiceCollection diceCollection);
    void setPlayerGroup(PlayerGroup playerGroup);
    void setPlayer(String username);
    void add();
    int getScore();
}
