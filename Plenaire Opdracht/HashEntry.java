public class HashEntry {

	private int key;
	private String value;

	// Makes an object with a key and a value
	HashEntry(int key, String value) {
		this.key = key;
		this.value = value;
	}

	// Get the key of the object
	public int getKey() {
		return key;
	}

	// Get the value of the object
	public String getValue() {
		return value;
	}
}