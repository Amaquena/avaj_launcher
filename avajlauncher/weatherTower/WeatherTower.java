package weatherTower;

import vehicles.Coordinates;
import weatherProvider.WeatherProvider;

public class WeatherTower extends Tower {
	// Methods
	public String getWeather(Coordinates coordinates) {
		// What to do?
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	public void changeWeather() {
		// What to do?
		this.conditionsChanged();
	}
}