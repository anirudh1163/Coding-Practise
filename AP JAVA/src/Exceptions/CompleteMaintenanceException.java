package Exceptions;


public class CompleteMaintenanceException extends Exception {

public CompleteMaintenanceException(String errMsg) {
	super(errMsg); 
     System.out.println("Error message is: " + errMsg);
} 
}

