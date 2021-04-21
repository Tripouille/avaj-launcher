package aircraft;

import interfaces.Flyable;
import weather.WeatherTower;
import java.util.HashMap;

class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
		HashMap<String, Movement> movements = new HashMap<String, Movement>();
		movements.put("SUN", new Movement(0, 10, 2, "Oh yeah ... I like the sun."));
		movements.put("RAIN", new Movement(0, 5, 0, ""));
		movements.put("FOG", new Movement(0, 1, 0, ""));
		movements.put("SNOW", new Movement(0, 0, 7, ""));
		initializeMovements(movements);
	}

	public void updateCondition() {
		updateCoordonates(weatherTower.getWeather(coordinates));
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}

	@Override
	public String toString() {
		return ("JetPlane" + super.toString());
	}
}
