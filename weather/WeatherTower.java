package weather;

import aircraft.*;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	public void changeWeather() {
		System.out.println("WeatherTower: changeWeather()");
		conditionsChanged();
	}

}
