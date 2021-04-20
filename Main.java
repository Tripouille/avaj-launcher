import aircraft.AircraftFactory;
import interfaces.Flyable;

public class Main {
	public static void main(String av[]) {
		Flyable h = null;
		System.out.println(h);
		h = AircraftFactory.newAirCraft("type", "name", 1, 2, 3);
		System.out.println(h);
		h = AircraftFactory.newAirCraft("Helicopter", "name", 1, 2, 3);
		System.out.println(h);
	}
}