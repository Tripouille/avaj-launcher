package aircraft;

import interfaces.Flyable;
import weather.WeatherTower;
import java.util.HashMap;

class Helicopter extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
		movements.put("SUN", new Movement(10, 0, 2, "Off to the wild blue yonder ! Wheeee !"));
		movements.put("RAIN", new Movement(5, 0, 0, "Some people feel the rain others just get wet."));
		movements.put("FOG", new Movement(1, 0, 0, "They'll never see me coming !"));
		movements.put("SNOW", new Movement(0, 0, -12, "And so the snow day begins ..."));
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
		return ("Helicopter" + super.toString());
	}
}
