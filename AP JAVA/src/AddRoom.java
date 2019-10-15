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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AddRoom {

	public static void fun(Stage primaryStage) {
		

		try {
			
			primaryStage.setTitle("Add Room");
			Label label = new Label("Hotel Management Main Menu");
	        FlowPane r = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
	        
	        TextField guestName = new TextField(); 
	        
	        TextField phoneNumber = new TextField(); 
	        String[] roomType = { "Standard", "Deluxe", "Suite", "Presidential Suite", "Ordinary" };
	        
	        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(roomType)); 
	        
	        r.getChildren().add(guestName);
	        r.getChildren().add(phoneNumber);
	        r.getChildren().add(combo_box);
	        
			
			Scene sc = new Scene(r, 800, 800);
			
			
			//sc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sc);
			primaryStage.show();
			
			
			
		}
		catch(Exception e) {
			System.out.println("Exception in Add room Class");
		}
	
	}

	}