import java.util.ArrayList;

public class PathHashEntry {

	private int key;
	private int[][] board;
	private ArrayList<Integer> path = new ArrayList<Integer>(); 

	// Makes an object with a key and a board
	PathHashEntry(int key, int[][] board, ArrayList<Integer> path) {
		this.key = key;
		this.board = board;
		this.path = path;
	}

	// Get the key of the object
	public int key() {
		return key;
	}

	// Get the board of the object
	public int[][] board() {
		return board;
	}

	public ArrayList<Integer> path() {
		return path;
	}
}