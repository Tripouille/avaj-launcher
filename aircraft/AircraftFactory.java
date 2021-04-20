package aircraft;

import interfaces.Flyable;
import java.util.HashMap;

public abstract class AircraftFactory {
	private interface CreateFlyable {
		Flyable create(String name, Coordinates coordinates);
	}

	private static class Factory {
		private HashMap<String, CreateFlyable> recipe = new HashMap<String, CreateFlyable>();

		Factory() {
			recipe.put("Helicopter", new CreateFlyable() {
				public Flyable create(String name, Coordinates coordinates) {
					return (new Helicopter(name, coordinates));
				}
			});
			recipe.put("JetPlane", new CreateFlyable() {
				public Flyable create(String name, Coordinates coordinates) {
					return (new JetPlane(name, coordinates));
				}
			});
			recipe.put("Baloon", new CreateFlyable() {
				public Flyable create(String name, Coordinates coordinates) {
					return (new Baloon(name, coordinates));
				}
			});
		}
	}

	public static Flyable newAirCraft(String type, String name, int longitude, int latitude, int height) {
		Factory factory = new Factory();

		if (factory.recipe.containsKey(type))
			return (factory.recipe.get(type).create(name, new Coordinates(longitude, latitude, height)));
		return (null);
	}
}
