public class CoordinatesHashTable {
    // A big prime number to make the load factor low
	private final int TABLESIZE = 64;

    // Initialize an array of entries for the hashtable
	CoordinatesHashEntry[] hashTable;

    // Makes an hashtable with null-values
	CoordinatesHashTable() {
		hashTable = new CoordinatesHashEntry[TABLESIZE];
		for (int i = 0; i < TABLESIZE; i++)
			hashTable[i] = null;
	}

    // Gets the value that belongs to the key
	public int[] get(int key) {
        // Hash is the value of the key that is inside the hashtable
        int hash = (key % TABLESIZE);
        // If the entry has a value and the keys aren't equal,
        // go to the next entry
        while (hashTable[hash] != null && hashTable[hash].getKey() != key)
            hash = (hash + 1) % TABLESIZE;
        // If the entry has no value, return null
        if (hashTable[hash] == null)
            return null;
        // Otherwise return the value
        else
            return hashTable[hash].getValue();
    }
 
    // Put a new entry on the place of the key in the hashtable
    public void put(int key, int[] value) {
        int hash = (key % TABLESIZE);
        // If the entry has a value, go to the next entry
        while (hashTable[hash] != null) {
        	hash = (hash + 1) % TABLESIZE;
        }
        // Make a new entry on the place of the key
        hashTable[hash] = new CoordinatesHashEntry(hash, value);
    }

    // Give the size of the hashtable
    public int size() {
    	return TABLESIZE;
    }

}