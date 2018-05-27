package model;


import exceptions.DomainException;

import java.util.*;

public class PlayerGroup
{
    private Deque<Player> queue = new ArrayDeque<>();
    public PlayerGroup(){
    }


    public void addPlayer(Player player)
    {
        if(queue.contains(player))
        {
            throw new DomainException("This player already exists");
        }
        else
        {
            queue.push(player);
        }
    }

    public int berekenScore(String username, CategoryType type)
    {
        Player player = this.getPlayer(username);
        return player.getScore(type);
    }

    public void removePlayerFromGroup(Player player)
    {
        if(player == null || !queue.contains(player))throw new DomainException("player is null or not found");

        queue.remove(player);



    }

    public Player getCurrentPlayer()
    {
        return queue.peek();
    }

    public Player goNextPlayer()
    {
        Player player = queue.removeLast();
        queue.push(player);

        return player;
    }

    public Player getPlayer(String username)
    {
        Player player = null;

        for(Player obj : queue)
        {
            if(obj.getUsername().equals(username))
            {
                player = obj;
            }
        }

        return player;
    }

    public List<Player> getPlayers()
    {
        return new ArrayList<>(queue);
    }

    public void addCategoryToPlayer(Category category, String username){
        getPlayer(username).addCategory(category);
    }
}
