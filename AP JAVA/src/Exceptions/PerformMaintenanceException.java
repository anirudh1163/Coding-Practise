package Exceptions;
public class PerformMaintenanceException extends Exception {

	public PerformMaintenanceException(String errMsg) {
		super(errMsg);     

	    System.out.println("Error message is: " + errMsg);
	} 
}