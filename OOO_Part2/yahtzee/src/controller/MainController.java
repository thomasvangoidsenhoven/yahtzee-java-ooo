package controller;

import javafx.scene.control.TextInputDialog;
import model.GameSuite;
import model.Player;

import java.util.Optional;

public class MainController {

    public void start()
    {
        GameSuite gameSuite = new GameSuite();
        loopNameRequests(gameSuite);

        //for each player a new PlayerController
        createPlayerControllers(gameSuite);
        System.out.println("continues");
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
                System.out.println(result.get());
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

    }
}
