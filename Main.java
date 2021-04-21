import aircraft.*;
import weather.*;
import interfaces.Flyable;

public class Main {
	public static void main(String av[]) {
		Flyable h1 = AircraftFactory.newAirCraft("Helicopter", "h1", 1, 2, 3);
		Flyable h2 = AircraftFactory.newAirCraft("Baloon", "h2", 10, 20, 30);
		Flyable h3 = AircraftFactory.newAirCraft("JetPlane", "h2", 10, 20, 30);
		Flyable h4 = AircraftFactory.newAirCraft("jetPlane", "h2", 10, 20, 30);
		System.out.println(h1);
		System.out.println(h2);
		System.out.println(h3);
		System.out.println(h4);
		WeatherTower tower = new WeatherTower();
		h1.registerTower(tower);
		//tower.changeWeather();
		//System.out.println(tower.getWeather(new Coordinates(1, 4, 5)));
	}
}