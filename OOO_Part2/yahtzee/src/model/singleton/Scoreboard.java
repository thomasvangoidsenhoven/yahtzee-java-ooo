package model.singleton;

import controller.PlayerController;
import model.Player;
import model.PlayerGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scoreboard {

    private static volatile Scoreboard scoreboard;
    private PlayerGroup playerGroup;

    private Scoreboard(PlayerGroup playerGroup){
        this.playerGroup = playerGroup;
    }

    public static Scoreboard getInstance(PlayerGroup group){
         if(scoreboard == null){
             synchronized (Scoreboard.class){
                 if(scoreboard == null){
                     scoreboard = new Scoreboard(group);
                 }
             }
         }
         return scoreboard;
    }


    public Map getInfo(){
        Map<Player, List> playersAndScores = new HashMap<>();
        for (Player p: playerGroup.getPlayers()) {
            playersAndScores.put(p, p.getCatogories());
        }
        return playersAndScores;
    }


}
