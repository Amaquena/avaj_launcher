package vehicles;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	// Constructor
	public Coordinates(int longitude, int latitude, int height) {
		if (height > 100) {
			height = 100;
		}
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public int getLatitide() {
		return this.latitude;
	}

	public int getHeight() {
		return this.height;
	}
}
