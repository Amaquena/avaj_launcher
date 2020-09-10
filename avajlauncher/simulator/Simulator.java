package simulator;

import interfaces.Flyable;
import vehicles.AircraftFactory;
import weatherTower.WeatherTower;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import java.util.ArrayList;

public class Simulator {
	private static WeatherTower weatherTower = new WeatherTower();
	private static List<Flyable> flyables = new ArrayList<>();
	public static BufferedWriter newFile = null;

	public static void main(String[] args) {
		BufferedReader file = null;
		String line = null;
		int simulation = 0;

		if (args.length != 1) {
			System.err.println("Only takes one argument");
			System.exit(1);
		}

		try {
			newFile = new BufferedWriter(new FileWriter("simulation.txt"));
		} catch (IOException e) {
			System.err.println("Error creating simulation.txt");
			System.exit(1);
		}

		try {
			file = new BufferedReader(new FileReader(args[0]));
			line = file.readLine();

			if (line != null) {
				try {
					simulation = Integer.parseInt(line);
				} catch (NumberFormatException e) {
					System.err.println(
							"Simulation runtime Number must be an integer " + e.getMessage() + " in scenario file.");
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
						System.err.println("Invalid Aircraft in scenario file.");
						System.exit(1);
					}
					flyables.add(flyable);
				} catch (NumberFormatException e) {
					System.err.println(e.getMessage() + " in scenario file. It must be of type integer.");
					System.exit(1);
				} catch (ArrayIndexOutOfBoundsException e) {
					System.err.println("file format incorrect");
					System.exit(1);
				}
			}
			if (flyables.isEmpty()) {
				System.err.println("No aircrafts in scenario file");
				System.exit(1);
			}

			for (Flyable flyable : flyables) {
				flyable.registerTower(weatherTower);
			}
			for (int i = 1; i <= simulation; i++) {
				weatherTower.changeWeather();
			}

		} catch (FileNotFoundException e) {
			System.err.println("File not found: " + args[0]);
		} catch (IOException e) {
			System.err.println("There was an error while reading the file: " + args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("No simulation file found.");
		} catch (Exception e) {
			System.err.println("Exception was unfortunately unforseen, Oops.");
		} finally {
			try {
				if (file != null)
					file.close();
			} catch (IOException e) {
				System.err.println("There was an error closing the file: " + args[0]);
			}
			try {
				if (newFile != null)
					newFile.close();
			} catch (IOException e) {
				System.err.println("Error closing the simulation.txt");
			}
		}
	}
}