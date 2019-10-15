package Exceptions;



public class RentExceptions extends Exception {

public RentExceptions(String msg) {

	super(msg);    

    System.out.println("Error message is: " + msg);
}
}



