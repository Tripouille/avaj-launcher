package exceptions;

public class BadCoordinatesException extends Exception {
	public BadCoordinatesException(String errorMessage) {
		super(errorMessage);
	}
}