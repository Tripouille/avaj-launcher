package interfaces;

import weather.*;

public interface Flyable {
	void updateCondition();
	void registerTower(WeatherTower weatherTower);
}
