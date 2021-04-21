import aircraft.*;
import weather.*;
import interfaces.Flyable;

public class Main {
	public static void main(String av[]) {
		Flyable j = AircraftFactory.newAirCraft("JetPlane", "J1", 1, 2, 3);
		Flyable h = AircraftFactory.newAirCraft("Helicopter", "H1", 1, 2, 3);
		Flyable b = AircraftFactory.newAirCraft("Baloon", "B1", 1, 2, 3);
		System.out.println(h);
		WeatherTower tower = new WeatherTower();
		j.registerTower(tower);
		h.registerTower(tower);
		b.registerTower(tower);
		for (int i = 0; i < 20; ++i)
			tower.changeWeather();
	}
}