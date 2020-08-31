package vehicles;

import interfaces.Flyable;
import weatherTower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    // Constructor
    public JetPlane(String name, Coordinates coordinates) {
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
