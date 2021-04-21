package aircraft;

import interfaces.Flyable;
import java.util.HashMap;

abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;
	private HashMap<String, Movement> movements;

	protected static class Movement extends Coordinates {
		Movement(int longitude, int latitude, int height) {
			super(longitude, latitude, height);
		}
	}

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = idCounter;
		nextId();
	}

	private long nextId() {
		return (++idCounter);
	}

	protected void initializeMovements(HashMap<String, Movement> movements) {
		this.movements = movements;
	}

	protected void updateCoordonates(String weather) {
		Movement movement = movements.get(weather);
		System.out.println(this + " " + weather);
		this.coordinates = new Coordinates(coordinates.getLongitude() + movement.getLongitude(),
											coordinates.getLatitude() + movement.getLatitude(),
											coordinates.getHeight() + movement.getHeight());
	}

	public String toString() {
		return (String.format("ID: %d, Name: %s, Coordonates: [%d %d %d]", id, name,
								 coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight()));
	}
}
