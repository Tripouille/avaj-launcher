package aircraft;

import interfaces.Flyable;
import weather.WeatherTower;
import java.util.HashMap;

class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
		HashMap<String, Movement> movements = new HashMap<String, Movement>();
		movements.put("SUN", new Movement(2, 0, 4));
		movements.put("RAIN", new Movement(0, 0, 5));
		movements.put("FOG", new Movement(0, 0, 3));
		movements.put("SNOW", new Movement(0, 0, 15));
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
		return ("Type: Baloon, " + super.toString());
	}
}
