package model.singleton;

import controller.PlayerController;
import model.Player;
import model.PlayerGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scoreboard {

    private static volatile Scoreboard scoreboard;
    private PlayerController controller;

    private Scoreboard(PlayerController controller){
        setController(controller);
    }

    public static Scoreboard getInstance(PlayerController controller){
         if(scoreboard == null){
             synchronized (Scoreboard.class){
                 if(scoreboard == null){
                     scoreboard = new Scoreboard(controller);
                 }
             }
         }
         return scoreboard;
    }

    private void setController(PlayerController controller){
        if(controller == null){
            throw new IllegalArgumentException("Controller is empty");
        } else{
            this.controller = controller;
        }
    }

    public Map getInfo(){
        Map<Player, List> playersAndScores = new HashMap<>();
        for (Player p: controller.getSuite().getPlayers()) {
            playersAndScores.put(p, p.getCatogories());
        }
        return playersAndScores;
    }


}
