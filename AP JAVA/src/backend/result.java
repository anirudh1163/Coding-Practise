package backend;
import com.*;
import java.util.Scanner;
import backend.*;
import backend.LodgeService;
import Exceptions.CompleteMaintenanceException;
import Exceptions.PerformMaintenanceException;
import Exceptions.RentExceptions;
import Exceptions.ReturnException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class result {

	public static void fun(Stage primaryStage,String s) {
		

		try {
			Label label=new Label("result page");
			FlowPane r = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
				        primaryStage.setTitle("My First JavaFX GUI");
				        Scene sc = new Scene(r, 800, 800);
				        Label res=new Label();
				        res.setText(s);
				        r.getChildren().add(res);
				        
				        Button ok=new Button("OK");
				        r.getChildren().add(ok);
				        CityLodge cityLodge = new CityLodge();
				        ok.setOnAction(e ->  cityLodge.start(primaryStage));
				        primaryStage.setScene(sc);
						primaryStage.show();
			
		}
		catch(Exception e) {
			System.out.println("Exception in Add room Class");
		}
	
	}

	}