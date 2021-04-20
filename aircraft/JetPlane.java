package aircraft;

import interfaces.Flyable;
import weather.WeatherTower;

class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateCondition() {
		weatherTower.getWeather(coordinates);
	}

	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
	}
}
