public class SimonsHashTable {
    // A big prime number to make the load factor low
	private int final tableSize = 64;

    // Initialize an array of entries for the hashtable
	HashEntry[] hashTable;

    // Makes an hashtable with null-values
	SimonsHashTable() {
		hashTable = new HashEntry[tableSize];
		for (int i = 0; i < tableSize; i++)
			hashTable[i] = null;
	}

    // Gets the value that belongs to the key
	public Vehicle get(int key) {
        // Hash is the value of the key that is inside the hashtable
        int hash = (key % tableSize);
        // If the entry has a value and the keys aren't equal,
        // go to the next entry
        while (hashTable[hash] != null && hashTable[hash].getKey() != key)
            hash = (hash + 1) % tableSize;
        // If the entry has no value, return null
        if (hashTable[hash] == null)
            return null;
        // Otherwise return the value
        else
            return hashTable[hash].getValue();
    }
 
    // Put a new entry on the place of the key in the hashtable
    public void put(int key, Vehicle value) {
        int hash = (key % tableSize);
        // If the entry has a value, go to the next entry
        while (hashTable[hash] != null) {
        	hash = (hash + 1) % tableSize;
        }
        // Make a new entry on the place of the key
        hashTable[hash] = new HashEntry(hash, value);
    }

    // Give the size of the hashtable
    public int size() {
    	return tableSize;
    }

}