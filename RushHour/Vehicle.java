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
 
	// Get the length of the vehicle
	public int getVehicleLength(int type){
		if(type == 0 || type == 1) {
			return 2;
		}else if(type == 2){
			return 3;
		}else{
			return 0;
		}
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