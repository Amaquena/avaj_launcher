package weatherTower;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import interfaces.Flyable;

public abstract class Tower {
	private List <Flyable> observers = new CopyOnWriteArrayList<Flyable>();

	public void register(Flyable flyable) {
		observers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		observers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
	}
}