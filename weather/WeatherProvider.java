package weather;

import aircraft.Coordinates;

class WeatherProvider {
	private final String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {
	}

	private static class WeatherProviderHolder {
		private final static WeatherProvider instance = new WeatherProvider();
	}

	public static WeatherProvider getProvider() {
		return (WeatherProviderHolder.instance);
	}

	public String getCurrentWeather(Coordinates coordinates) {
		return (weather[0]);
	}
}