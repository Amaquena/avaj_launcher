package vehicles;

import java.io.IOException;

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

		try {
			if (this.coordinates.getHeight() <= 0) {
				this.weatherTower.unregister(this);
				simulator.Simulator.newFile.write(
						"Tower says: JetPlane#" + this.name + "(" + this.id + ") unregister from weather tower.\n");
			} else {
				switch (weather) {
					case "SUN":
						this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide() + 10, this.coordinates.getHeight() + 2);
						simulator.Simulator.newFile.write(
								"JetPlane#" + this.name + "(" + this.id + "): " + "I'm the maverick around here.\n");
						break;
					case "RAIN":
						this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide() + 5, this.coordinates.getHeight());
						simulator.Simulator.newFile
								.write("JetPlane#" + this.name + "(" + this.id + "): " + "I think we going to fast.\n");
						break;
					case "FOG":
						this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide() + 1, this.coordinates.getHeight());
						simulator.Simulator.newFile
								.write("JetPlane#" + this.name + "(" + this.id + "): " + "It's a good day to die.\n");
						break;
					case "SNOW":
						this.coordinates = new Coordinates(this.coordinates.getLongitude(),
								this.coordinates.getLatitide(), this.coordinates.getHeight() - 7);
						simulator.Simulator.newFile.write(
								"JetPlane#" + this.name + "(" + this.id + "): " + "It's all so white and fluffy.\n");

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
			simulator.Simulator.newFile.write(
					"Tower says: JetPlane" + "#" + this.name + "(" + this.id + ") registered to weather tower.\n");
		} catch (IOException e) {
			System.out.println("Error writing to simulation.txt");
			System.exit(1);
		}
	}
}
