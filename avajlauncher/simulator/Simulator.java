package simulator;

// import interfaces.Flyable;
// import vehicles.*;
// import weatherTower.WeatherTower;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
// import java.util.*;

public class Simulator {
	// private static WeatherTower weatherTower;
	// private static List<Flyable> flyables = new ArrayList<Flyable>();

	public static void main(String[] args) {
		BufferedReader file = null;
		String line = null;

		try {
			file = new BufferedReader(new FileReader(args[0]));
			line = file.readLine();

			if (line != null) {
				if (Integer.parseInt(line) <= 0) {
					System.err.println("Invalid Simulation runtime Number, must be greater than 0.");
				}
			}

			while ((line = file.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + args[0]);
		} catch (IOException e) {
			System.out.println("There was an error while reading the file: " + args[0]);
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