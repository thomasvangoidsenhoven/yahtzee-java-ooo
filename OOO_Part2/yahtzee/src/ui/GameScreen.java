package ui;

import controller.PlayerController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScreen
{
    private PlayerController controller;
    private Stage stage;

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

        Button button = new Button("role dice!");
        VBox gameView = new VBox();



        gameView.getChildren().add(button);
        root.getChildren().add(gameView);
    }

    private void createPlayerText(Pane root)
    {
        StackPane stackPane = new StackPane();
        Label name = new Label(controller.getPlayerName() + " now Playing");
        stackPane.getChildren().add(name);
        //
        root.getChildren().add(stackPane);
    }
}
