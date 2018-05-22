package ui;

import controller.PlayerController;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Player;
import model.observer.ScreenObserver;
import model.singleton.Scoreboard;


public class ScoreboardScreen implements ScreenObserver {
    private PlayerController controller;
    private Stage stage;
    private Pane root;
    private Scoreboard scoreboard = Scoreboard.getInstance(controller);

    public ScoreboardScreen(PlayerController controller){
        this.controller.registerObserver(this);
    }

    public void initDraw(){
        //System.out.println("test");
        stage = new Stage();
        stage.setTitle("Scoreboard");
        this.root = new GridPane();
        for (Player p: controller.getSuite().getPlayers()) {
            Label l = new Label(p.getUsername());
            root.getChildren().add(l);
        }
        stage.setScene(new Scene(root, 300, 250));
        stage.show();
    }


    @Override
    public void update() {
        //redraw
    }
}
