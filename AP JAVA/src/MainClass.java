
import javafx.application.Application;
import javafx.stage.Stage;

import javafx.application.Application;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class MainClass extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			
			CityLodge cityLodge = new CityLodge();
			Stage stage=new Stage();
			cityLodge.start(stage);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

