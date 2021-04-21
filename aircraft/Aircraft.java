package aircraft;

import java.util.HashMap;

import exceptions.BadCoordinatesException;
import interfaces.Flyable;
import weather.WeatherTower;

abstract class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter;
	protected HashMap<String, Movement> movements = new HashMap<String, Movement>();

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

	protected Aircraft(String name, Coordinates coordinates) throws BadCoordinatesException {
		if (coordinates.getLongitude() < 0)
			throw new BadCoordinatesException("Longitude must be positive");
		else if (coordinates.getLatitude() < 0)
			throw new BadCoordinatesException("Latitute must be positive");
		else if (coordinates.getHeight() < 0 || coordinates.getHeight() > 100)
			throw new BadCoordinatesException("Height must be between 0 and 100");
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private long nextId() {
		return (++idCounter);
	}

	protected void updateCoordonates(WeatherTower weatherTower) {
		Movement movement = movements.get(weatherTower.getWeather(coordinates));
		int height = coordinates.getHeight() + movement.getHeight() >= 100 ?
		100 : coordinates.getHeight() + movement.getHeight();
		height = height > 0 ? height : 0;

		this.coordinates = new Coordinates(coordinates.getLongitude() + movement.getLongitude(),
									coordinates.getLatitude() + movement.getLatitude(), height);

		System.out.println(this + ": " + movement.getSentence());
		if (coordinates.getHeight() == 0) {
			System.out.println(this + " landing.");
			weatherTower.unregister((Flyable)this);
		}
	}

	public String toString() {
		return (String.format("#%s(%d)[%d %d %d]", name, id,
				coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight()));
	}
}
