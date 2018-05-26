package controller;

import javafx.scene.control.TextInputDialog;
import model.GameSuite;
import model.Player;
import ui.ScoreboardScreen;

import java.util.Optional;

public class MainController {

    public void start()
    {
        GameSuite gameSuite = new GameSuite();
        loopNameRequests(gameSuite);
        gameSuite.playYahtzee();
        createPlayerControllers(gameSuite);
    }

    ////////////////////////////////
    /////// Helper Methods ////////
    //////////////////////////////

    private void loopNameRequests( GameSuite gameSuite )
    {

        while(true)
        {
            TextInputDialog dialog = createNewDialog();
            Optional<String> result = dialog.showAndWait();

            if(result.isPresent())
            {
                //ok
                gameSuite.createPlayer(result.get());
            }else
            {
                //dialogue got cancelled
                break;
            }
        }
    }

    private TextInputDialog createNewDialog()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setContentText("Naam:");
        return dialog;
    }

    private void createPlayerControllers(GameSuite suite)
    {
        PlayerController playerController = null;
        //for each Player a PlayerController
        for(Player p : suite.getPlayers())
        {
            playerController = new PlayerController(p,suite);
        }
        new ScoreboardScreen(playerController);

    }

}
