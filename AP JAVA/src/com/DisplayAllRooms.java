package com;
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
import backend.LodgeService;
import backend.Room;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
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
			
					
		
		    Label label = new Label("Hotel Management Main Menu");
	        FlowPane r = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
		   
			Scene sc = new Scene(r, 800, 800);
			LodgeService service = new LodgeService();
			List<Room> rooms =  service.displayRoom();
			String response="";
			Label l=new Label();
			for (Room room : rooms) {
				response=response+room.getDetails()+"\n";
				l.setText(response);
			}
			r.getChildren().addAll(l);
			//sc.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Button home=new Button("home");
			CityLodge cityLodge = new CityLodge();
		       home.setOnAction(e ->  cityLodge.start(primaryStage));
			primaryStage.setScene(sc);
			primaryStage.show();
			
			
			
		}
		catch(Exception e) {
			System.out.println("Exception in Add room Class");
		}
	
	}

	}