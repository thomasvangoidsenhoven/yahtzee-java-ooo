package application;
	
import controller.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

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
