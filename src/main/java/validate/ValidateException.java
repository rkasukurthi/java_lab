package validate;

public class ValidateException extends Exception {
   String message;

private ValidateException(String message) {
	super();
	this.message = message;
}
   
}
