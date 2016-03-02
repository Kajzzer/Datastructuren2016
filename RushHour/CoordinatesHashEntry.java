public class CoordinatesHashEntry {

	private int key;
	private int[] value;

	// Makes an object with a key and a value
	CoordinatesHashEntry(int key, int[] value) {
		this.key = key;
		this.value = value;
	}

	// Get the key of the object
	public int getKey() {
		return key;
	}

	// Get the value of the object
	public int[] getValue() {
		return value;
	}
}