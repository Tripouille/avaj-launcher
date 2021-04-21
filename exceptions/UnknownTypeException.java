package exceptions;

public class UnknownTypeException extends Exception {
	public UnknownTypeException(String errorMessage) {
		super(errorMessage);
	}
}