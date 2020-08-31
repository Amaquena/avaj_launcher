package vehicles;

import java.io.IOException;

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

		try {
			switch (weather) {
				case "SUN":
					this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,
							this.coordinates.getLatitide(), this.coordinates.getHeight() + 4);
					simulator.Simulator.newFile.write("Baloon#" + this.name + "(" + this.id + "): "
							+ "Damn, it's hotter than the hottest hotter hots.\n");
					break;
				case "RAIN":
					this.coordinates = new Coordinates((this.coordinates.getLongitude()),
							this.coordinates.getLatitide(), this.coordinates.getHeight() - 5);
					simulator.Simulator.newFile
							.write("Baloon#" + this.name + "(" + this.id + "): " + "Dude where's My raincoat?\n");
					break;
				case "FOG":
					this.coordinates = new Coordinates((this.coordinates.getLongitude()),
							this.coordinates.getLatitide(), this.coordinates.getHeight() - 3);
					simulator.Simulator.newFile.write(
							"Baloon#" + this.name + "(" + this.id + "): " + "I can see my house from up here.\n");
					break;
				case "SNOW":
					this.coordinates = new Coordinates((this.coordinates.getLongitude()),
							this.coordinates.getLatitide(), this.coordinates.getHeight() - 15);
					simulator.Simulator.newFile
							.write("Baloon#" + this.name + "(" + this.id + "): " + "Is that Elsa down there?\n");

				default:
					break;
			}

			if (this.coordinates.getHeight() <= 0) {
				this.weatherTower.unregister(this);
				simulator.Simulator.newFile.write(
						"Tower says: Baloon#" + this.name + "(" + this.id + ") unregister from weather tower.\n");
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
					"Tower says: Baloon" + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
		} catch (IOException e) {
			System.out.println("Error writing to simulation.txt");
			System.exit(1);
		}
	}
}
