import aircraft.*;
import weather.*;
import interfaces.Flyable;

public class Main {
	public static void main(String av[]) {
		Flyable h = AircraftFactory.newAirCraft("JetPlane", "h1", 1, 2, 3);
		System.out.println(h);
		WeatherTower tower = new WeatherTower();
		h.registerTower(tower);
		tower.changeWeather();
		tower.changeWeather();
		tower.changeWeather();
		tower.changeWeather();
		tower.changeWeather();
		tower.changeWeather();
		tower.changeWeather();
	}
}