package weatherTower;

import interfaces.Flyable;

public abstract class Tower implements Flyable {
	private Flyable observers;

	// Methods
	public void register(Flyable flyable) {
		// What to do?
	}

	public void unregister(Flyable flyable) {
		// What to do?
	}

	protected void conditionsChanged() {
		// What to do?
	}
}