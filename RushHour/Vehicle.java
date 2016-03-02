public class Vehicle {

	private int x;
	private int y;
	private int type;
	private int direction;

	// Assign values to a new vehicle object
	Vehicle(int x, int y, int type, int direction) {
		this.x = x; // X-coordinate
		this.y = y; // Y-coordinate
		this.type = type; //Red = 0, Car = 1, Truck = 2
		this.direction = direction; // Horizontal = 0, Vertical = 1
	}

	// Get the X-coordinate
	public int getX() {
		return x;
	}

	// Get the y-coordinate
	public int getY() {
		return y;
	}

	// Get the type of the vehicle
	public int getType() {
		return type;
	}

	// Get the direction of the vehicle
	public int getDirection() {
		return direction;
	}
 
	// Get the coordinates of the vehicle
	public CoordinatesHashTable getCoordinates(int x, int y, int type, int direction,
		CoordinatesHashTable takenCoordinates){

		int length = 0;
		int[] place = new int[2];
		int key;

		if(direction == 0) {
			if(type == 0 || type == 1) {
				length = 2;
			} else if(type == 2) {
				length = 3;
			}
			for(int i = 0; i < length; i++) {
				place = makeCoordinate((x + i), y);
				key = place[0]+place[1]*6;
				takenCoordinates.put(key, place);
			}
			return takenCoordinates;
		}else if(direction == 1){
			if(type == 0 || type == 1) {
				length = 2;
			} else if(type == 2) {
				length = 3;
			}
			for(int i = 0; i < length; i++) {
				place = makeCoordinate(x, (y + i));
				key = place[0]+place[1]*6;
				takenCoordinates.put(key, place);
			}
			return takenCoordinates;
		}else{
			return takenCoordinates;
		}
	}

	public int[] makeCoordinate(int x, int y) {
		int[] coordinate = new int[2];
		coordinate[0] = x;
		coordinate[1] = y;
		return coordinate;
	}

	// Move the vehicle up or right
	public void moveForward(int x, int y, int direction) {
		if(direction == 0) {
			x++;
		}else if(direction == 1) {
			y++;
		}
	}

	// Move the vehicle down or left
	public void moveBackward(int x, int y, int direction) {
		if(direction == 0) {
			x--;
		}else if(direction == 1) {
			y--;
		}
	}	
}