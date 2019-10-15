import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

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

public class DisplayAllRooms {

	public static void fun(Stage primaryStage) {
		
		
		

		try {
			primaryStage.setTitle("DisplayAllRooms");
			String filePath="/Users/anirudhmaheswaram/Documents/sample.csv";
			File file = new File(filePath); 
			
			  
		    try { 
		        // create FileWriter object with file as parameter 
		        FileWriter outputfile = new FileWriter(file); 
		  
		        // create CSVWriter object filewriter object as parameter 
		        CSVWriter writer = new CSVWriter(outputfile); 
		  
		        // create a List which contains String array 
		        List<String[]> data = new ArrayList<String[]>(); 
		        data.add(new String[] { "Name", "Class", "Marks" }); 
		        data.add(new String[] { "Aman", "10", "620" }); 
		        data.add(new String[] { "Suraj", "10", "630" }); 
		        writer.writeAll(data); 
		  
		        // closing writer connection 
		        writer.close(); 
		    } 
		    catch (IOException e) { 
		        // TODO Auto-generated catch block 
		        e.printStackTrace(); 
		    } 
					
		
		    Label label = new Label("Hotel Management Main Menu");
	        FlowPane r = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
		   
			Scene sc = new Scene(r, 800, 800);
			TextField guestName = new TextField("Writing into file sample");
			 r.getChildren().add(guestName);
			//sc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sc);
			primaryStage.show();
			
			
			
		}
		catch(Exception e) {
			System.out.println("Exception in Add room Class");
		}
	
	}

	}