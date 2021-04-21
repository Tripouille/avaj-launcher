package aircraft;

import java.util.HashMap;

import interfaces.Flyable;
import exception.BadCoordinatesException;

public abstract class AircraftFactory {
	private final static Factory factory = new Factory();

	private interface CreateFlyable {
		Flyable create(String name, Coordinates coordinates) throws BadCoordinatesException;
	}

	private static class Factory {
		private HashMap<String, CreateFlyable> recipe = new HashMap<String, CreateFlyable>();

		Factory() {
			recipe.put("Helicopter", new CreateFlyable() {
				public Flyable create(String name, Coordinates coordinates) throws BadCoordinatesException {
					return (new Helicopter(name, coordinates));
				}
			});
			recipe.put("JetPlane", new CreateFlyable() {
				public Flyable create(String name, Coordinates coordinates) throws BadCoordinatesException {
					return (new JetPlane(name, coordinates));
				}
			});
			recipe.put("Baloon", new CreateFlyable() {
				public Flyable create(String name, Coordinates coordinates) throws BadCoordinatesException {
					return (new Baloon(name, coordinates));
				}
			});
		}
	}

	public static Flyable newAirCraft(String type, String name, int longitude, int latitude, int height) throws BadCoordinatesException {
		if (factory.recipe.containsKey(type))
			return (factory.recipe.get(type).create(name, new Coordinates(longitude, latitude, height)));
		return (null);
	}
}
