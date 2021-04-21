package aircraft;

import interfaces.Flyable;

abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = idCounter;
		nextId();
	}

	private long nextId() {
		return (++idCounter);
	}

	public String toString() {
		return (String.format("ID: %d, Name: %s, Coordonates: [%d %d %d]", id, name,
								 coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight()));
	}
}
