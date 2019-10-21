package com;
import java.sql.PreparedStatement;
import backend.*;
import backend.LodgeService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

import com.sun.javafx.scene.control.skin.DatePickerSkin;

import Exceptions.CompleteMaintenanceException;
import Exceptions.PerformMaintenanceException;
import Exceptions.RentExceptions;
import Exceptions.ReturnException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ComboBoxBase;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class AddRoom {

	public static void fun(Stage primaryStage) {
		try {
			Label summary1=new Label("Summary");
			Label summary2=new Label("Summary");
			TextField tf1=new TextField();
			TextField tf2=new TextField();
			Label room_num1= new Label("Room Number");
			Label numOfBeds1= new Label("Number of Beds");
			Label roomType1 = new Label("Room Type");
			Label room_num2= new Label("Room Number");
			Label numOfBeds2= new Label("Number of Beds");
			Label roomType2 = new Label("Room Type");
			primaryStage.setTitle("Return Room");
			Label label = new Label("Hotel Management Main Menu");
	        FlowPane r = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
	        primaryStage.setTitle("My First JavaFX GUI");
	        Scene sc = new Scene(r, 800, 800);
	        FlowPane r1 = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
	        FlowPane r2 = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
	        Scene scene1= new Scene(r1, 800, 800);
	        Scene scene2= new Scene(r2,800,800);
	        TextField roomid1 = new TextField();
	        TextField roomid2 = new TextField();
	        Label date=new Label("Last Maintainance date");
	        Label date1=new Label("Last Maintainance date");
	        DatePicker d=new DatePicker();
	        DatePicker d1=new DatePicker();
	        Button b1 =new Button("Submit");
	        Button b2 =new Button("Submit");
	      Button button1= new Button("Standard");
	      Label labels1 = new Label("Standard");
	      String[] standardBeds= {"1","2","4"};
	      ComboBox standard_beds = new ComboBox(FXCollections.observableArrayList(standardBeds));
	      r1.getChildren().addAll(roomType1,labels1,room_num1,roomid1,numOfBeds1,standard_beds,date,d,summary1,tf1,b1 );
	      Button button2= new Button("suite");
	      Label labels = new Label("Suite");
	      String[] suiteBeds= {"6"};
	      ComboBox suite_beds = new ComboBox(FXCollections.observableArrayList(suiteBeds));
	      r2.getChildren().addAll(roomType2,labels,room_num2,roomid2,numOfBeds2, suite_beds,date1,d1,summary2,tf2,b2 );
			r.getChildren().add(button1);
			r.getChildren().add(button2);
			
			button1.setOnAction(e -> primaryStage.setScene(scene1)); 
			 button2.setOnAction(e -> primaryStage.setScene(scene2));
			 Button home=new Button("Home");
		       r.getChildren().add(home);
		       CityLodge cityLodge = new CityLodge();
		       home.setOnAction(e ->  cityLodge.start(primaryStage));
			 b1.setOnAction((event) -> {    
				    System.out.println(roomid1.getText());
				    
				   
				    
				    System.out.println(standard_beds.getSelectionModel().getSelectedItem().toString());
				    System.out.println(labels1.getText()); 
				    LodgeService service = new LodgeService();
				    try {
						service.addRoom(roomid1.getText(),standard_beds.getSelectionModel().getSelectedItem().toString(),labels1.getText(),d.getValue(),tf1.getText());
					} catch (RentExceptions e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ReturnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    
				});
			 b2.setOnAction((event) -> {    
				 System.out.println(roomid2.getText());
				    System.out.println(suite_beds.getSelectionModel().getSelectedItem().toString());
				    System.out.println(labels.getText()); 
				    LodgeService service = new LodgeService();
				    try {
						service.addRoom(roomid2.getText(),suite_beds.getSelectionModel().getSelectedItem().toString(),labels.getText(),d1.getValue(),tf2.getText());
					} catch (RentExceptions e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ReturnException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
	      primaryStage.setScene(sc);
			primaryStage.show();
		}
		catch(Exception e) {
			System.out.println("Exception in Add room Class");
		}
	}
	}