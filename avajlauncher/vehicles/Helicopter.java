package vehicles;

import interfaces.Flyable;
import weatherTower.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    // Constructor
    public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
    }

    public void updateConditions() {
		System.out.println("Helicopter changed");
    }

    public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		// TODO: write output to file
		System.out.println("Tower says: Helicopter" + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
