package model;

public interface Category {
    void setScore();
    int getScore();
    void setDiceCup(DiceCup diceCup);
    int berekenScore();
    CategoryType getCategoryType();
}
