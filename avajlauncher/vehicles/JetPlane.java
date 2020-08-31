package vehicles;

import interfaces.Flyable;
import weatherTower.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    // Constructor
    public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
    }

    public void updateConditions() {
		System.out.println("Jetplane changed");
    }

    public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Jetplane" + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
