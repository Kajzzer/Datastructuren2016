public class SimonsLinkedHash {
    // A big prime number to make the load factor low
	private final int TABLESIZE = 1500007;

    LinkedHashEntry[] hashTable;

    // Makes a hashtable with null-values
	SimonsLinkedHash() {
		hashTable = new LinkedHashEntry[TABLE_SIZE];
            for (int i = 0; i < TABLE_SIZE; i++)
                  hashTable[i] = null;
	}

    // Gets the value that belongs to the key
	public String get(int key) {
        // Hash is the value of the key that is inside the hashtable
        int hash = (key % TABLESIZE);
        // If the entry has a value and the keys aren't equal,
        // go to the next entry
        if (table[hash] == null)
                  return null;
            else {
                  LinkedHashEntry entry = table[hash];
                  while (entry != null && entry.getKey() != key)
                        entry = entry.getNext();
                  if (entry == null)
                        return null;
                  else
                        return entry.getValue();
    }
 
    // Put a new entry on the place of the key in the hashtable
    public void put(int key, String value) {
        int hash = (key % TABLESIZE);
        // If the entry has a value, go to the next entry
        if (table[hash] == null)
                  table[hash] = new LinkedHashEntry(key, value);
            else {
                  LinkedHashEntry entry = table[hash];
                  while (entry.getNext() != null && entry.getKey() != key)
                        entry = entry.getNext();
                  if (entry.getKey() == key)
                        entry.setValue(value);
                  else
                        entry.setNext(new LinkedHashEntry(key, value));
            }
      }

    // Give the size of the hashtable
    public int size() {
    	return TABLESIZE;
    }

}