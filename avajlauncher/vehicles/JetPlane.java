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
		String weather = this.weatherTower.getWeather(coordinates);
		
		// TODO: Output to a file
		switch(weather) {
			case "SUN":
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide() + 10,
								this.coordinates.getHeight() + 2);
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + "I'm the maverick around here.");
			break;
			case "RAIN":
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide() + 5,
								this.coordinates.getHeight());
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + "I think we going to fast.");
			break;
			case "FOG":
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide() + 1,
								this.coordinates.getHeight());
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + "It's a good day to die.");
			break;
			case "SNOW":
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide(),
								this.coordinates.getHeight() - 7);
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): " + "It's all so white and fluffy.");

			default:
			break;
		}

		if (this.coordinates.getHeight() <= 0) {
			this.weatherTower.unregister(this);
			System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregister from weather tower.");
		}
    }

    public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: JetPlane" + "#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}
