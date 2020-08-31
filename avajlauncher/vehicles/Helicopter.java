package vehicles;

import interfaces.Flyable;
import weatherTower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    // Constructor
    public Helicopter(String name, Coordinates coordinates) {
		// What to do?
		super(name, coordinates);
    }

    // Methods
    public void updateConditions() {
		// What to do?
		System.out.println("Helicopter changed");
    }

    public void registerTower(WeatherTower weatherTower) {
		// What to do?
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		// TODO: write output to file
		System.out.println("Tower says: Helicopter" + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
