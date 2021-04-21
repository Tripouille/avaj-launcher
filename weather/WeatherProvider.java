package weather;

import aircraft.Coordinates;

class WeatherProvider {
	private final String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
	private final static WeatherProvider instance = new WeatherProvider();

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return (instance);
	}

	public String getCurrentWeather(Coordinates coordinates) {
		byte i = 0;

		if (coordinates.getLongitude() % 2 == 1)
			++i;
		if (coordinates.getLatitude() % 3 == 1)
			++i;
		if (coordinates.getHeight() % 4 == 1)
			++i;
		return (weather[i]);
	}
}