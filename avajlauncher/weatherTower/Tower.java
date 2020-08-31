package weatherTower;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import interfaces.Flyable;

public abstract class Tower {
	private List <Flyable> observers = new CopyOnWriteArrayList<Flyable>();

	// Methods
	public void register(Flyable flyable) {
		// What to do?
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		// What to do?
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		// What to do?
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
	}
}