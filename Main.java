import weather.*;

public class Main {
	public static void main(String av[]) {
		WeatherProvider wp = WeatherProvider.getProvider();

		System.out.println(wp.getCurrentWeather());
	}
}