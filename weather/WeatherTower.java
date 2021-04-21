package weather;

import aircraft.*;

public class WeatherTower extends Tower {
	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	public void changeWeather() { // remove le public de la mort
		//System.out.println("WeatherTower: changeWeather()");
		conditionsChanged();
	}

}
