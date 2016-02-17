public class SimonsHashTable {
	private int tableSize = 128;

	HashEntry[] hashTable;

	SimonsHashTable() {
		hashTable = new HashEntry[tableSize];
		for (int i = 0; i < tableSize; i++)
			hashTable[i] = null;
	}

	public int get(int key) {
            int hash = (key % tableSize);
            while (hashTable[hash] != null && hashTable[hash].getKey() != key)
                  hash = (hash + 1) % tableSize;
            if (hashTable[hash] == null)
                  return -1;
            else
                  return hashTable[hash].getValue();
      }
 
      public void put(int key, String value) {
            int hash = (key % tableSize);
            while (hashTable[hash] != null && hashTable[hash].getKey() != key)
                  hash = (hash + 1) % tableSize;
            hashTable[hash] = new HashEntry(key, value);
      }
}