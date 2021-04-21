package weather;

import interfaces.*;
import java.util.*;

abstract class Tower {
	private Set<Flyable> observers = new HashSet<Flyable>();
	
	public void register(Flyable flyable) {
		String infos = "Tower: registering " + flyable;

		try {
			if (flyable == null)
				throw new NullPointerException();
			if (observers.add(flyable))
				infos += " -> success.";
			else
				infos += " -> already registered.";
		} catch (UnsupportedOperationException | ClassCastException
		| NullPointerException | IllegalArgumentException e) {
			infos += " -> invalid flyable.";
		}
		System.out.println(infos);
	}

	public void unregister(Flyable flyable) {
		String infos = "Tower: unregistering " + flyable;

		try {
			if (flyable == null)
				throw new NullPointerException();
			if (observers.remove(flyable))
				infos += " -> success.";
			else
				infos += " -> not found.";
		} catch (ClassCastException | NullPointerException | UnsupportedOperationException e) {
			infos += " -> invalid flyable.";
		}
		System.out.println(infos);
	}

	protected void conditionsChanged() {
		for (Flyable flyable : observers)
			flyable.updateCondition();
	}
}
