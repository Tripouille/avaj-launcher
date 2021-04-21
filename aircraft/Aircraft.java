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
		private String sentence;

		Movement(int longitude, int latitude, int height, String sentence) {
			super(longitude, latitude, height);
			this.sentence = sentence;
		}

		public String getSentence() {
			return (sentence);
		}
	}

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private long nextId() {
		return (++idCounter);
	}

	protected void initializeMovements(HashMap<String, Movement> movements) {
		this.movements = movements;
	}

	protected void updateCoordonates(String weather) {
		Movement movement = movements.get(weather);
		int height = coordinates.getHeight() + movement.getHeight() >= 100 ?
					100 : coordinates.getHeight() + movement.getHeight();

		this.coordinates = new Coordinates(coordinates.getLongitude() + movement.getLongitude(),
										coordinates.getLatitude() + movement.getLatitude(), height);
		System.out.println(this + ": " + movement.getSentence());
	}

	public String toString() {
		return (String.format("#%s(%d)[%d %d %d]", name, id,
				coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight()));
	}
}
