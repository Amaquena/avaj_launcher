package vehicles;

import java.io.IOException;

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

		try {
			if (this.coordinates.getHeight() <= 0) {
				this.weatherTower.unregister(this);
				simulator.Simulator.newFile.write(
						"Tower says: Helicopter#" + this.name + "(" + this.id + ") unregister from weather tower.\n");
			} else {
				switch (weather) {
					case "SUN":
						this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,
								this.coordinates.getLatitide(), this.coordinates.getHeight() + 2);
						simulator.Simulator.newFile.write("Helicopter#" + this.name + "(" + this.id + "): "
								+ "I'd rather be at the beach right now.\n");
						break;
					case "RAIN":
						this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,
								this.coordinates.getLatitide(), this.coordinates.getHeight());
						simulator.Simulator.newFile
								.write("Helicopter#" + this.name + "(" + this.id + "): " + "I can't see like this.\n");
						break;
					case "FOG":
						this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,
								this.coordinates.getLatitide(), this.coordinates.getHeight());
						simulator.Simulator.newFile
								.write("Helicopter#" + this.name + "(" + this.id + "): " + "Where are we?\n");
						break;
					case "SNOW":
						this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide(), this.coordinates.getHeight() - 12);
						simulator.Simulator.newFile
								.write("Helicopter#" + this.name + "(" + this.id + "): " + "We're falling!\n");

					default:
						break;
				}

			}
		} catch (IOException e) {
			System.out.println("Error writing to simulation.txt");
			System.exit(1);
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);

		try {
			simulator.Simulator.newFile.write("Tower says: Helicopter" + "#" + this.name + "(" + this.id + ")"
					+ " registered to weather tower.\n");
		} catch (IOException e) {
			System.out.println("Error writing to simulation.txt");
			System.exit(1);
		}
	}
}
