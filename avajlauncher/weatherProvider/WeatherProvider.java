package weatherProvider;

import java.util.Random;

import vehicles.Coordinates;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

	public WeatherProvider() {
	}
	
	public static WeatherProvider getProvider() {
		weatherProvider = new WeatherProvider();
		return (weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int choice = new Random().nextInt(4);
		return (weather[choice]);
	}
}