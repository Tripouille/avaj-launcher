package weather;

import interfaces.Flyable;
import java.util.List;
import java.util.ArrayList;

abstract class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
		System.out.println("Tower says: " + flyable + " registered.");
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
		System.out.println("Tower says: " + flyable + " unregistered.");
	}

	protected void conditionsChanged() {
		for (int i = 0; i < observers.size(); ++i)
			observers.get(i).updateCondition();
	}
}
