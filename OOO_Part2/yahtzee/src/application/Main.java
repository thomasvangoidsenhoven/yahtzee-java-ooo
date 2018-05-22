package application;
	
import controller.MainController;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		MainController controller = new MainController();
		controller.start();

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
