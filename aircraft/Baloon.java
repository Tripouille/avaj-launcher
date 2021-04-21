package aircraft;

import interfaces.Flyable;
import weather.WeatherTower;
import java.util.HashMap;

class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) throws BadCoordinatesException {
		super(name, coordinates);
		movements.put("SUN", new Movement(2, 0, 4, "If you want to shine like a sun, first burn like a sun."));
		movements.put("RAIN", new Movement(0, 0, -5, "Let’s agree that the office should be closed when it rains."));
		movements.put("FOG", new Movement(0, 0, -3, "I tried to catch some fog but I mist."));
		movements.put("SNOW", new Movement(0, 0, -15, "Wake me up when it's summer ..."));
	}

	public void updateCondition() {
		updateCoordonates(weatherTower);
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		weatherTower.register(this);
	}

	@Override
	public String toString() {
		return ("Baloon" + super.toString());
	}
}
