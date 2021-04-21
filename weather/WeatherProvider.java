package weather;

import aircraft.Coordinates;

class WeatherProvider {
	private final String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};
	private final static WeatherProvider weatherProvider = new WeatherProvider();

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return (weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates) { // remove le public
		byte i = 0;
		long score = coordinates.getLongitude()
					+ coordinates.getLatitude() + coordinates.getHeight();

		if (score % 2 == 0)
			++i;
		if (score % 3 == 0)
			++i;
		if (score % 5 == 0)
			++i;
		return (weather[i]);
	}
}