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
		System.out.println("Baloon changed");
		String weather = this.weatherTower.getWeather(coordinates);
		System.out.println(weather);
	}

	public void registerTower(WeatherTower weatherTower) {
		// What to do?
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		// TODO: write output to file
		System.out.println("Tower says: Baloon" + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}
}
