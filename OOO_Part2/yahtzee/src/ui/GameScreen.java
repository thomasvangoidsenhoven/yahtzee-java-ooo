package ui;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXMessageDialog;
import controller.PlayerController;
import exceptions.DomainException;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.CategoryType;
import model.Dice;
import model.DiceCup;
import model.YahtzeeGame;
import model.observer.ScreenObserver;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class GameScreen implements ScreenObserver
{
    private PlayerController controller;
    private Stage stage;
    private StackPane playerNamePane = new StackPane();
    private List<Button> buttons = new ArrayList<>();
    private Label playerLabel = new Label("");
    private Label playerScore = new Label("");
    private ComboBox menuButton;
    private Button endTurnButton;
    private Button rollButton = new Button("role dice!");
    private Pane root;

    public GameScreen(PlayerController controller)
    {
        this.controller = controller;
        this.controller.registerObserver(this);
        startUp();

        this.playMusic("startup");
    }

    private void startUp()
    {

        stage = new Stage();
        stage.setTitle("Yahtzee | " + controller.getPlayerName());
        this.root = new VBox();

        createGameText(root);
        createGameView(root);
        createPlayerText();

        drawRollButton();
        this.playerNamePane.getChildren().add(playerLabel);
        root.getChildren().add(playerNamePane);
        HBox rootScore = new HBox();
        rootScore.getChildren().add(this.playerScore);
        root.getChildren().add(rootScore);

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

    private void drawRollButton()
    {
        if (controller.areYouPlaying())
        {
            rollButton.setVisible(true);
        }else
            {
                rollButton.setVisible(false);
            }

    }

    private void createGameView(Pane root)
    {
        VBox gameContainer = new VBox();
        rollButton.setOnAction((event -> this.roll()));
        HBox gameView = new HBox();

        for(int i = 0; i < 5; i++)
        {
            Button diceButton = new Button(Integer.toString((i)));
            diceButton.setPadding(new Insets(5,5,5,5));
            diceButton.setStyle("-fx-background-color: green");
            buttons.add(diceButton);
            gameView.getChildren().add(diceButton);
        }


        this.menuButton = new ComboBox();
        menuButton.setItems(FXCollections.observableArrayList(CategoryType.values()));

        endTurnButton = new Button("End Turn");
        endTurnButton.setOnAction((event -> this.endTurn(menuButton)));
        drawCategories();
        gameView.getChildren().addAll(new Node[]{menuButton,endTurnButton});

        gameContainer.setStyle("-fx-background-color: #FFDFC4");
        gameContainer.getChildren().addAll(new Node[]{ rollButton,gameView });


        root.getChildren().add(gameContainer);
    }



    private void createPlayerText()
    {
        playerLabel.setText(controller.getCurrentPlayer().getUsername() + " now Playing");
    }

    private void roll()
    {
        try
        {
            controller.roll();
        }catch (DomainException e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("no more chances");
            alert.showAndWait();
        }

    }

    private void lock(int index){
        controller.lock(index);
    }

    private void drawCategories()
    {

        if(controller.areYouPlaying())
        {
            menuButton.setVisible(true);
            endTurnButton.setVisible(true);

        }else
            {
                menuButton.setVisible(false);
                endTurnButton.setVisible(false);
            }



    }

    private void endTurn(ComboBox list)
    {
        if(list.getValue() != null)
        {
            try
            {
                controller.chooseCategory(controller.getPlayerName(),(CategoryType) list.getValue());
                if(!controller.getSuite().getYahtzeeGame().isGameOver()) {
                    controller.resetDices();
                    controller.goNextPlayer();
                    this.roll();
                }

            }catch (DomainException e)
            {
                JOptionPane.showMessageDialog(null,"category is already used");
            }



        }


    }

    private void displayScores(){
        String result = "";
        for (String s: controller.getYourPlayer().getScoresAndCategories()) {
            result += s +"\n";
        }
        playerScore.setText(result);
    }

    private void showWinner()
    {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setContentText("The Winner IS: " + controller.getWinner().getUsername() + "\n WITH " + this.controller.getWinner().getTotalScore() + " POINTS " + "\n Do you with to play again?");
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.get() == ButtonType.OK){
            controller.resetCategoriesForPlayer();
            this.root.setVisible(true);

        } else {
            controller.removePlayerFromPlayerGroup();
            stage.close();
        }

        controller.madeReplayChoice();

    }

    private void playMusic(String filename)
    {
        //OOO_Part2/yahtzee/
        String musicFile = "resources/" + filename + ".mp3";
        try
        {
            Media sound = new Media(new File(musicFile).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setVolume(0.1);
            mediaPlayer.play();
        }catch (Exception e)
        {

        }

    }

    private void dissolve()
    {
        this.root.setVisible(false);
    }

    //redraw dices
    @Override
    public void update() {

        if(controller.isGameOver())
        {
            this.dissolve();
            this.showWinner();
            this.playMusic("tyrone");
        }
        else
        {
            //create helper methods
            for(int i = 0; i < controller.getDices().size(); i++ )
            {
                buttons.get(i).setText(Integer.toString(controller.getDices().get(i)));
                if(controller.areYouPlaying())
                {
                    final int index = i;
                    buttons.get(i).setOnAction((event -> this.lock(index)));
                }
                else
                {
                    buttons.get(i).setOnAction(event -> {});
                }
                if(controller.isDiceLocked(i))
                {
                    this.buttons.get(i).setStyle("-fx-background-color: red");
                }
                else
                {
                    this.buttons.get(i).setStyle("-fx-background-color: green");
                }
            }



            this.createPlayerText();
            this.drawCategories();
            this.drawRollButton();
            this.displayScores();

        }

    }
}

