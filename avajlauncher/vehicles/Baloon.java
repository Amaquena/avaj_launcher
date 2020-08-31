package vehicles;

import interfaces.Flyable;
import weatherTower.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	private WeatherTower weatherTower;

	// Constructor
	public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(coordinates);
		
		//TODO: Output to file
		switch(weather) {
			case "SUN":
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,
								this.coordinates.getLatitide(),
								this.coordinates.getHeight() + 4);
			System.out.println("Baloon#" + this.name + "(" + this.id + "): " + "Damn, it's hotter than the hottest hotter hots.");
			break;
			case "RAIN":
			this.coordinates = new Coordinates((this.coordinates.getLongitude()),
								this.coordinates.getLatitide(),
								this.coordinates.getHeight() - 5);
			System.out.println("Baloon#" + this.name + "(" + this.id + "): " + "Dude where's My raincoat?");
			break;
			case "FOG":
			this.coordinates = new Coordinates((this.coordinates.getLongitude()),
								this.coordinates.getLatitide(),
								this.coordinates.getHeight() - 3);
			System.out.println("Baloon#" + this.name + "(" + this.id + "): " + "I can see my house from up here.");
			break;
			case "SNOW":
			this.coordinates = new Coordinates((this.coordinates.getLongitude()),
								this.coordinates.getLatitide(),
								this.coordinates.getHeight() - 15);
			System.out.println("Baloon#" + this.name + "(" + this.id + "): " + "Is that Elsa down there?");
			
			default:
			break;
		}

		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregister from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		// TODO: write output to file
		System.out.println("Tower says: Baloon" + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
	}
}
