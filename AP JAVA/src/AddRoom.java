import java.sql.PreparedStatement;
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
			
			primaryStage.setTitle("Add Room");
			Label label = new Label("Hotel Management Main Menu");
	        FlowPane r = new FlowPane(Orientation.VERTICAL,20.0, 20.0, label);
	        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	        Date dateobj = new Date();
	        System.out.println(df.format(dateobj));
	        TextField guestName = new TextField(); 
	        Label myLabel=new Label("Guest Name");
	        Label myLabel1=new Label("Phone Number");
	        Label myLabel2=new Label("Room Type");
	        Label myLabel3=new Label("Reservation till Date");
	        DatePicker d = new DatePicker(); 
	        
	        
	        TextField phoneNumber = new TextField(); 
	        String[] roomType = { "Standard", "Deluxe", "Suite", "Presidential Suite", "Ordinary" };
	        
	        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(roomType)); 
	        
	        Button b =new Button("go");
	       
	        r.getChildren().add(myLabel);
	        r.getChildren().add(guestName);
	        
	        r.getChildren().add(myLabel1);
	        r.getChildren().add(phoneNumber);
	        
	        r.getChildren().add(myLabel2);
	        r.getChildren().add(combo_box);
	         
	        
	        r.getChildren().add(myLabel3);
            r.getChildren().add(d);
            
	        r.getChildren().add(b);
	        
	        
	        
	        
	        
			
			Scene sc = new Scene(r, 800, 800);
			
			b.setOnAction((event) -> {
			    // Button was clicked, do something...
			    System.out.println(guestName.getText());
			    System.out.println(phoneNumber.getText());
			    System.out.println(combo_box.getSelectionModel().getSelectedItem().toString());
			    System.out.println(dateobj);
			    LocalDate i = d.getValue();
			    System.out.println(i);
			    
			    //db.getConnection();
			    //String sqlstatement="update hotelmanagement set column_name=value";
			    //PreparedStatement pstmt = null;
			    //pstmt = con.prepareStatement(SQL);
			    
			    
			    //db.closeConnection();
			    
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