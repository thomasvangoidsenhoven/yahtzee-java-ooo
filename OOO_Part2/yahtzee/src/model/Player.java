package model;

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
        this.username = username;
    }

    public List<Category> getCatogories() {
        return new ArrayList<>(catogories.values());
    }

    public void addCategory(Category category){
        catogories.put(category.getCategoryType(),category);
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
