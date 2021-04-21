package aircraft;

public class BadCoordinatesException extends Exception {
	BadCoordinatesException(String errorMessage) {
		super(errorMessage);
	}
}