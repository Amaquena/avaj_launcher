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
		System.out.println("Jetplane changed");
    }

    public void registerTower(WeatherTower weatherTower) {
		// What to do?
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		// TODO: write output to file
		System.out.println("Tower says: Jetplane" + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
