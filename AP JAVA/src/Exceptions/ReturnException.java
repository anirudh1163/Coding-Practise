package Exceptions;



public class ReturnException extends Exception {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	private String message;

public  ReturnException (String msg) {

	super(msg);    
	this.message = msg;
}
}



