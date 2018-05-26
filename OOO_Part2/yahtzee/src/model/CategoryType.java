package model;

public enum CategoryType {
    ACES("Aces"),
    TWOS("Twos"),
    THREES("Threes"),
    FOURS("Fours"),
    FIVES("Fives"),
    SIXES("Sixes"),
    THREE_OF_A_KIND("Three Of A Kind"),
    FOUR_OF_A_KIND("Four Of A kind"),
    FULL_HOUSE("Full House"),
    SMALL_STRAIGHT("Small Straight"),
    LARGE_STRAIGHT("Large Straight"),
    YAHTZEE("Yahtzee"),
    CHANCE("Chance");
    private final String name;
    private CategoryType(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
