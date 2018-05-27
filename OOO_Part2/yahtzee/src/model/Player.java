package model;

import exceptions.DomainException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player
{
    private String username;

    //TODO maybe new collection type needed
    private Map<CategoryType,Category> catogories = new HashMap<>();

    public Category getCategoryByType(CategoryType type)
    {
        return catogories.get(type);
    }

    public Player(String username)
    {
        setUsername(username);
    }

    public String getUsername()
    {
        return  username;
    }

    public void setUsername(String username)
    {
        if(username == null || username.isEmpty())throw new DomainException("username is null or empty");
        this.username = username;
    }

    public List<Category> getCatogories() {
        return new ArrayList<>(catogories.values());
    }

    public List<String> getScoresAndCategories(){
        List<String> test = new ArrayList<>();
        for (Category c: getCatogories()) {
            test.add(c.toString() +": " + c.getScore());
        }
        return test;
    }

    public boolean hasFilledOutAllCategories()
    {
        if (new ArrayList<>(this.catogories.values()).size() == 13) return true;
        return false;
    }

    public void addCategory(Category category){
        if(catogories.get(category.getCategoryType()) != null) throw new IllegalStateException("Already Used a category")  ;
        catogories.put(category.getCategoryType(),category);
    }


    public int getTotalScore()
    {
        int sum = 0;
        for(Category c : catogories.values())
        {
            sum += c.getScore();
        }

        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Player)
        {
            Player player = (Player) obj;
            if(player.getUsername().equals(this.getUsername())) return true;
        }
        return false;

    }
}
