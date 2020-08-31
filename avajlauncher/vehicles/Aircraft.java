package vehicles;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    static private long idCounter = 0L;

    // Constructor
    protected Aircraft(String name, Coordinates coordinates) {
		this.id = nextId();
		this.name = name;
		this.coordinates = coordinates;
    }

    private long nextId() {
		return (++idCounter);
    }
}