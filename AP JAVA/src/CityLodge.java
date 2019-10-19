
import java.util.Scanner;

import Exceptions.CompleteMaintenanceException;
import Exceptions.PerformMaintenanceException;
import Exceptions.RentExceptions;
import Exceptions.ReturnException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CityLodge extends Application{

	

	public void start(Stage primaryStage) {

		
			// city lodge menu
			System.out.println("**** CITYLODGE MAIN MENU ****\r\n" + "Add Room: 1\r\n" + "Rent Room: 2\r\n"
					+ "Return Room: 3\r\n" + "Room Maintenance: 4\r\n" + "Complete Maintenance: 5\r\n"
					+ "Display All Rooms: 6\r\n" + "Exit Program: 7\r\n" + "Enter your choice:");
			try {
				primaryStage.setTitle("Sample Java FX Application"); 
				
		        Button badd = new Button("Add room");
		        Button brent = new Button("Rent room");
		        Button breturn = new Button("return room");
		        Button bmaintenance = new Button("Room Maintainance");
		        Button bcompletemaintainance = new Button ("Complete maintainance");
		        Button bdisplayrooms = new Button ("Display all rooms");
		        Button bexit = new Button ("Exit");
		        
		        
		        // create a stack pane 
		        //StackPane r = new StackPane(); 
		        Label label = new Label("Hotel Management Main Menu");
		        FlowPane r = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
		  
		        // add button 
		        r.getChildren().add(badd); 
		        r.getChildren().add(brent);
		        r.getChildren().add(breturn);
		        r.getChildren().add(bmaintenance); 
		        r.getChildren().add(bcompletemaintainance); 
		        r.getChildren().add(bdisplayrooms); 
		        r.getChildren().add(bexit); 
		  
		        
		        // create a scene 
		        Scene sc = new Scene(r, 800, 800);
				
				
				//sc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(sc);
				primaryStage.show();
				System.out.println("in action events");
				badd.setOnAction(e -> AddRoom.fun(primaryStage));
				brent.setOnAction(e -> RentRoom.fun(primaryStage));
				breturn.setOnAction(e -> ReturnRoom.fun(primaryStage));
				bmaintenance.setOnAction(e -> RoomMaintainance.fun(primaryStage));
				bcompletemaintainance.setOnAction(e -> CompleteMaintainance.fun(primaryStage));
				bdisplayrooms.setOnAction(e -> DisplayAllRooms.fun(primaryStage));
				
				
					
					//System.out.println("selected return room");
					//service.returnRoom();
				

				
			} catch (Exception e) {
				System.out.println(e);
			}
		
			
			
			

	}

	}
