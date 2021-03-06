import java.util.ArrayList;

public class PathHashTable {
    // A big prime number to make the load factor low
	private final int TABLESIZE = 9900601;

    // Initialize an array of entries for the hashtable
	PathHashEntry[] hashTable;

    // Makes an hashtable with null-values
	PathHashTable() {
		hashTable = new PathHashEntry[TABLESIZE];
		for (int i = 0; i < TABLESIZE; i++)
			hashTable[i] = null;
	}

    // Gets the value that belongs to the key
	public int[][] getBoard(int key) {
        // Hash is the value of the key that is inside the hashtable
        int hash = (key % TABLESIZE);
        // If the entry has a value and the keys aren't equal,
        // go to the next entry
        while (hashTable[hash] != null && hashTable[hash].key() != key)
            hash = (hash + 4000) % TABLESIZE;
        // If the entry has no value, return null
        if (hashTable[hash] == null)
            return null;
        // Otherwise return the value
        else
            return hashTable[hash].board();
    }

    // Gets the value that belongs to the key
    public ArrayList<Integer> getPath(int key) {
        // Hash is the value of the key that is inside the hashtable
        int hash = (key % TABLESIZE);
        // If the entry has a value and the keys aren't equal,
        // go to the next entry
        while (hashTable[hash] != null && hashTable[hash].key() != key)
            hash = (hash + 4000) % TABLESIZE;
        // If the entry has no value, return null
        if (hashTable[hash] == null)
            return null;
        // Otherwise return the value
        else
            return hashTable[hash].path();
    }

 
    // Put a new entry on the place of the key in the hashtable
    public int put(int oldKey, int newKey, int[][] board) {
        int newHash = (newKey % TABLESIZE);
        int oldHash = (oldKey % TABLESIZE);
        ArrayList<Integer> path = new ArrayList<Integer>();
        if(hashTable[oldHash] != null) {
            path.addAll(hashTable[oldHash].path());
//            System.out.println("Path =  " + path);
        } 
        // If the entry has a value, go to the next entry
        while (hashTable[newHash] != null) {
        	newHash = (newHash + 4000) % TABLESIZE;
//        	System.out.println(newHash);
        }
        path.add(newHash);        
//        System.out.println("Path =  " + path);
        // Make a new entry on the place of the key
        hashTable[newHash] = new PathHashEntry(newHash, board, path);
        return newHash;
    }

    // Give the size of the hashtable
    public int size() {
    	return TABLESIZE;
    }
}