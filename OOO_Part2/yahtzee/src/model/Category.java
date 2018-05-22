package model;

public interface Category {

    int getScore();
    void setDiceCup(DiceCup diceCup);
    int berekenScore();

    CategoryType getCategoryType();
}
