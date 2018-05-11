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
import model.DiceCup;
import model.YahtzeeGame;
import model.observer.ScreenObserver;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements ScreenObserver
{
    private PlayerController controller;
    private Stage stage;
    private List<Button> buttons = new ArrayList<>();

    public GameScreen(PlayerController controller)
    {
        this.controller = controller;
        this.controller.registerObserver(this);
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
            Button diceButton = new Button(Integer.toString((i)));
            diceButton.setPadding(new Insets(5,5,5,5));
            final int current = i;
            diceButton.setOnAction(event -> lock(current));
            diceButton.setStyle("-fx-background-color: green");
            buttons.add(diceButton);
            gameView.getChildren().add(diceButton);
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
        controller.roll();

    }

    private void lock(int index){
        controller.lock(index);
    }


    //redraw dices
    @Override
    public void update() {
        System.out.println("redraw");
        int i = 0;
        for(Dice dice : controller.getDices())
        {
            buttons.get(i).setText(Integer.toString(dice.getEyes()));
            if(controller.isDiceLocked(i))
            {
                this.buttons.get(i).setStyle("-fx-background-color: red");
            }
            else
            {
                this.buttons.get(i).setStyle("-fx-background-color: green");
            }
            i++;
        }

    }
}

