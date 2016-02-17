public class HashEntry {

	private int key;
	private String value;

	HashEntry(int key, int value) {
		this.key = key;
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
}