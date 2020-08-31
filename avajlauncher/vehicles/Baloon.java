package vehicles;

import interfaces.Flyable;
import weatherTower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	// Constructor
	public Baloon(String name, Coordinates coordinates) {
		// What to do?
		super(name, coordinates);
	}

	// Methods
	public void updateConditions() {
		// What to do?
	}

	public void registerTower(WeatherTower weatherTower) {
		// What to do?
		
	}
}
