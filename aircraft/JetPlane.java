package aircraft;

import interfaces.Flyable;
import weather.WeatherTower;
import java.util.HashMap;

class JetPlane extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
		movements.put("SUN", new Movement(0, 10, 2, "Watch me, sun ! I'm going fast ! Vrooooooom ..."));
		movements.put("RAIN", new Movement(0, 5, 0, "Oh no cloud, why did you cry ... :("));
		movements.put("FOG", new Movement(0, 1, 0, "Hmmm this smoke ... Did my motor take fire ?"));
		movements.put("SNOW", new Movement(0, 0, -7, "Ho Ho Ho, Merry Christmas everyone !"));
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
		return ("JetPlane" + super.toString());
	}
}
