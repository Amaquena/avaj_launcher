package vehicles;

import interfaces.Flyable;

public class AircraftFactory {
	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
		// What to do?
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		switch (type) {
			case "Baloon":
				return (new Baloon(name, coordinates));
			case "Jetplane":
				return (new JetPlane(name, coordinates));
			case "Helicopter":
				return (new Helicopter(name, coordinates));

			default:
				return (null);
				// System.out.println("Unrecognized Aircraft.");
				// System.exit(1);
		}
	}
}