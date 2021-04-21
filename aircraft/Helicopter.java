package aircraft;

import interfaces.Flyable;
import weather.WeatherTower;
import java.util.HashMap;

class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
		HashMap<String, Movement> movements = new HashMap<String, Movement>();
		movements.put("SUN", new Movement(10, 0, 2));
		movements.put("RAIN", new Movement(5, 0, 0));
		movements.put("FOG", new Movement(1, 0, 0));
		movements.put("SNOW", new Movement(0, 0, 12));
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
		return ("Type: Helicopter, " + super.toString());
	}
}
