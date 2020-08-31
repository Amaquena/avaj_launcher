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
		String weather = this.weatherTower.getWeather(coordinates);

		// TODO: Output to a file
		switch(weather) {
			case "SUN":
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,
								this.coordinates.getLatitide(),
								this.coordinates.getHeight() + 2);
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + "I'd rather be at the beach right now.");
			break;
			case "RAIN":
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,
								this.coordinates.getLatitide(),
								this.coordinates.getHeight());
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + "I can't see like this.");
			break;
			case "FOG":
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,
								this.coordinates.getLatitide(),
								this.coordinates.getHeight());
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + "Where are we?");
			break;
			case "SNOW":
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide(),
								this.coordinates.getHeight() - 12);
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): " + "We're falling!");

			default:
			break;
		}

		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregister from weather tower.");
		}
    }

    public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		// TODO: write output to file
		System.out.println("Tower says: Helicopter" + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
