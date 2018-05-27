package ui;

import controller.PlayerController;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Category;
import model.CategoryType;
import model.Player;
import model.observer.ScreenObserver;
import model.singleton.Scoreboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ScoreboardScreen implements ScreenObserver {
    private PlayerController controller;
    private Stage stage;
    private GridPane root;
    private List<Player> playerList;


    public ScoreboardScreen(PlayerController controller){
        this.controller = controller;
        this.controller.registerObserver(this);
        this.controller.initScoreboard();
        playerList = controller.getPlayers();
        initDraw();
    }

    public void initDraw(){
        stage = new Stage();
        stage.setTitle("Scoreboard");
        this.root = new GridPane();
        root.add(new Label("Scoreboard"),0,0);

        int columnNumber=1;
        int rowNumber = 1;
        for (Player p: controller.getSuite().getPlayers()) {
            Label l = new Label(p.getUsername());
            root.add(l,columnNumber,0);
            ColumnConstraints constraints = new ColumnConstraints();
            constraints.setMinWidth(100);
            root.getColumnConstraints().add(constraints);
            columnNumber++;

        }

        for(CategoryType categoryType : CategoryType.values())
        {
            root.add(new Label(categoryType.getName()),0,rowNumber);
            rowNumber++;
        }
        stage.setScene(new Scene(root, (columnNumber+1)*75, 666));
        stage.show();
    }

    @Override
    public void update() {

        List<CategoryType> categoryTypes = new ArrayList<>(Arrays.asList(CategoryType.values()));


        for(int row = 1; row <= categoryTypes.size();row++)
        {
            for(int column = 1; column <= playerList.size();column++)
            {
                int searchdex = column-1;
                Player currentPlayer = playerList.get(searchdex);
                CategoryType categoryType = categoryTypes.get(row-1);
                if(currentPlayer.getCategoryByType(categoryType) != null)
                {

                    int categoryScore = currentPlayer.getCategoryByType(categoryType).getScore();
                    Label label = new Label(Integer.toString(categoryScore));

                    root.add(label,column,row);
                }
            }
        }


        //redraw
    }
}
