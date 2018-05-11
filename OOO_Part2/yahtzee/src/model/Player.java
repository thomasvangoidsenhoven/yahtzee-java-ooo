package model;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private String username;

    //TODO maybe new collection type needed
    private List<Category> catogories = new ArrayList<>();

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
        return catogories;
    }

    public void addCategory(Category category){
        catogories.add(category);
    }



}
