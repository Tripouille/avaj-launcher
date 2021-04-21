package aircraft;

import interfaces.Flyable;
import weather.WeatherTower;

class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateCondition() {
		weatherTower.getWeather(coordinates);
	}

	public void registerTower(WeatherTower weatherTower) {
		weatherTower.register(this);
	}

	@Override
	public String toString() {
		return ("Type: Baloon, " + super.toString());
	}
}
