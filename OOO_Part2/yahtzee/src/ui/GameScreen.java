package ui;

import controller.PlayerController;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Dice;
import model.DiceCollection;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameScreen
{
    private PlayerController controller;
    private Stage stage;
    private List<Label> labels = new ArrayList<>();

    public GameScreen(PlayerController controller)
    {
        this.controller = controller;
        startUp();

    }

    private void startUp()
    {
        //System.out.println("test");
        stage = new Stage();
        stage.setTitle("Yahtzee | " + controller.getPlayerName());
        VBox root = new VBox();

        createGameText(root);
        createGameView(root);
        createPlayerText(root);

        stage.setScene(new Scene(root, 300, 250));

        stage.show();
    }

    private void createGameText(Pane root)
    {
        StackPane stackPane = new StackPane();
        Label gameLabel = new Label("yahtzee");
        stackPane.getChildren().add(gameLabel);
        //
        root.getChildren().add(stackPane);
    }

    private void createGameView(Pane root)
    {
        VBox gameContainer = new VBox();
        Button button = new Button("role dice!");
        button.setOnAction((event -> this.roll()));
        HBox gameView = new HBox();

        for(int i = 0; i < 5; i++)
        {
            Label label = new Label(Integer.toString((i)));
            label.setPadding(new Insets(5,5,5,5));
            labels.add(label);
            gameView.getChildren().add(label);
        }

        gameContainer.setStyle("-fx-background-color: #FFDFC4");
        gameContainer.getChildren().addAll(new Node[]{ button,gameView });


        root.getChildren().add(gameContainer);
    }

    private void createPlayerText(Pane root)
    {
        StackPane stackPane = new StackPane();
        Label name = new Label(controller.getPlayerName() + " now Playing");
        stackPane.getChildren().add(name);
        //
        root.getChildren().add(stackPane);
    }

    private void roll()
    {
        DiceCollection collection = controller.getSuite().getYahtzeeGame().roll(this.controller.getPlayerName());
        int i = 0;
        for(Dice dice : collection.getDices())
        {
            labels.get(i).setText(Integer.toString(dice.getEyes()));
            i++;
        }
    }
}
