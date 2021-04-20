package weather;

import aircraft.*;

public class WeatherProvider {
	private String weather;

	private WeatherProvider() {
	}

	private static class WeatherProviderHolder {
		private final static WeatherProvider instance = new WeatherProvider();
	}

	public static WeatherProvider getProvider() {
		return (WeatherProviderHolder.instance);
	}

	public String getCurrentWeather(Coordinates coordinates) {
		weather = "SUN";
		return (weather);
	}
}