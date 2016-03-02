public class HashEntry {

	private int key;
	private Vehicle value;

	// Makes an object with a key and a value
	HashEntry(int key, Vehicle value) {
		this.key = key;
		this.value = value;
	}

	// Get the key of the object
	public int getKey() {
		return key;
	}

	// Get the value of the object
	public Vehicle getValue() {
		return value;
	}
}