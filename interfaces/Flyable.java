package interfaces;

import weather.WeatherTower;

public interface Flyable {
	void updateCondition();
	void registerTower(WeatherTower weatherTower);
}
