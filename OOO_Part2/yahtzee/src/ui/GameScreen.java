package ui;

import controller.PlayerController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
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
        StackPane  root = new StackPane();
        stage.setScene(new Scene(root, 300, 250));

        stage.show();
    }
}
