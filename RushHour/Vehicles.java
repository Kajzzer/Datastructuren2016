public class Vehicles {

	private int key;
	private Vehicle vehicle;

	Vehicles(int key, Vehicle vehicle) {
		this.key = key;
		this.vehicle = vehicle;
	}	

	public int getKey() {
		return key;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}
}