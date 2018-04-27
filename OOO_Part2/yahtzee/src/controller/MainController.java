package controller;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class MainController {

    public void start()
    {
        while(true)
        {
            TextInputDialog dialog = createNewDialog();
            Optional<String> result = new TextInputDialog().showAndWait();
            if(result.isPresent())
            {
                //ok
                System.out.println(result.get());
            }else
            {
                //dialogue got cancelled
                break;
            }
        }
        System.out.println("continues");
    }



    ////////////////////////////////
    /////// Helper Methods ////////
    //////////////////////////////
    private TextInputDialog createNewDialog()
    {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setContentText("Naam:");
        return dialog;
    }
}
