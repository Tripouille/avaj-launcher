import aircraft.*;
import weather.*;
import interfaces.Flyable;

public class Main {
	public static void main(String av[]) {
		Flyable h = AircraftFactory.newAirCraft("JetPlane", "J1", 1, 2, 3);
		System.out.println(h);
		WeatherTower tower = new WeatherTower();
		h.registerTower(tower);
		for (int i = 0; i < 10; ++i)
			tower.changeWeather();
	}
}