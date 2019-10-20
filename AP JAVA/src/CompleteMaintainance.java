import java.util.Scanner;

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
import javafx.stage.Stage;

public class CompleteMaintainance {

	public static void fun(Stage primaryStage) {
		

		try {

			Label label=new Label("Return Room");
FlowPane r = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
	        
	        primaryStage.setTitle("My First JavaFX GUI");
	        Scene sc = new Scene(r, 800, 800);
	        
			 Label room_id=new Label("Room ID");
		        TextField roomId=new TextField();
		        Button b =new Button("Submit");
		        Label returndate=new Label("Completion date");
		        DatePicker d=new DatePicker();
			
		        r.getChildren().add(room_id);
		        r.getChildren().add(roomId);
		        r.getChildren().add(returndate);
		        r.getChildren().add(d);
		        r.getChildren().add(b);
		        
		        Button home=new Button("Home");
			       r.getChildren().add(home);
			       CityLodge cityLodge = new CityLodge();
			       home.setOnAction(e ->  cityLodge.start(primaryStage));
				 
		        b.setOnAction((event) -> {
				    // Button was clicked, do something...
				   // System.out.println(guestName.getText());
				    System.out.println(roomId.getText());
				    System.out.println(d.getValue());
				  //  System.out.println(combo_box.getSelectionModel().getSelectedItem().toString());    
				});
			
			
			//sc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sc);
			primaryStage.show();
			
			
			
		}
		catch(Exception e) {
			System.out.println("Exception in Add room Class");
		}
	
	}

	}