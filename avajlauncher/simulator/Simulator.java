package simulator;

import interfaces.Flyable;
import vehicles.AircraftFactory;
import weatherTower.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;

public class Simulator {
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyables = new ArrayList<>();

	public static void main(String[] args) {
		BufferedReader file = null;
		String line = null;
		int simulation = 0;

		try {
			file = new BufferedReader(new FileReader(args[0]));
			line = file.readLine();

			if (line != null) {
				try {
					simulation = Integer.parseInt(line);
				} catch (NumberFormatException e) {
					System.out.println("Simulation runtime Number must be an integer " + e.getMessage() + " in scenario file.");
					System.exit(1);
				}
				if (simulation <= 0) {
					System.err.println("Invalid Simulation runtime Number, must be greater than 0.");
					System.exit(1);
				}
			}

			while ((line = file.readLine()) != null) {
				try {
					Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
							Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
							Integer.parseInt(line.split(" ")[4]));
					if (flyable == null) {
						System.out.println("Invalid Aircraft in scenario file.");
						System.exit(1);
					}
					flyables.add(flyable);
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage() + " in scenario file. It must be of type integer.");
					System.exit(1);
				}
			}

			for (Flyable flyable : flyables) {
				flyable.registerTower(weatherTower);
			}
			for (int i = 1; i <= simulation; i++) {
				weatherTower.changeWeather();
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + args[0]);
		} catch (IOException e) {
			System.out.println("There was an error while reading the file: " + args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No simulation file found.");
		// } catch (Exception e) {
			// System.out.println("Exception: " + e);
			// System.out.println("Exception was unfortunately unforseen, Oops.");
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (IOException e) {
				System.out.println("There was an error closing the file: " + args[0]);
			}
		}
		// Flyable flyable = new AircraftFactory().newAircraft(type, name, longitude,
		// latitude, height)
	}
}