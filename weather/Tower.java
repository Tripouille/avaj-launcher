package weather;

import interfaces.*;
import java.util.*;

abstract class Tower {
	private Set<Flyable> observers = new HashSet<Flyable>();

	public void register(Flyable flyable) {

	}

	public void unregister(Flyable flyable) {

	}

	protected void conditionsChanged() {

	}
}
