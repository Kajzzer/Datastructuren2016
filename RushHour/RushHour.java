import java.util.*;
import java.io.*;

public class RushHour {


	public static void main(String args[]) {
		RushHour game = new RushHour();
		game.preparations();
	}

	// Prepare the game for the AI to play with
	public void preparations() {

		int gameNumber;
		SimonsHashTable sht = new SimonsHashTable();
		CoordinatesHashTable takenCoordinates = new CoordinatesHashTable();
		Vehicle vehicle;
		int key;

		Scanner input = new Scanner(System.in);

		System.out.println("Which game do you want to play? 1, 2 or 3?");
		gameNumber = input.nextInt();

		if(gameNumber == 1) {
			/* Put red car first */   
			vehicle = new Vehicle(4, 4, 0, 0);
			key = Math.abs(vehicle.hashCode());
			sht.put(key, vehicle);   
			/* Trucks*/   
			vehicle = new Vehicle(3, 4, 2, 1);
			key = Math.abs(vehicle.hashCode());
			sht.put(key, vehicle);     
			vehicle = new Vehicle(4, 1, 2, 1);
			key = Math.abs(vehicle.hashCode());
			sht.put(key, vehicle);     
			vehicle = new Vehicle(6, 4, 2, 1);
			key = Math.abs(vehicle.hashCode());
			sht.put(key, vehicle);     
	        /* Cars*/   
			vehicle = new Vehicle(1, 1, 1, 1);
			key = Math.abs(vehicle.hashCode());
			sht.put(key, vehicle);     
			vehicle = new Vehicle(2, 2, 1, 0);
			key = Math.abs(vehicle.hashCode());
			sht.put(key, vehicle);     
			vehicle = new Vehicle(5, 1, 1, 0);
			key = Math.abs(vehicle.hashCode());
			sht.put(key, vehicle);     
			vehicle = new Vehicle(4, 6, 1, 0);
			key = Math.abs(vehicle.hashCode());
			sht.put(key, vehicle);     
			vehicle = new Vehicle(5, 3, 1, 0);
			key = Math.abs(vehicle.hashCode());
			sht.put(key, vehicle);

			Vehicle v = new Vehicle(1,1,2,0);

			v.getCoordinates(1, 4, 2, 1, takenCoordinates);
			v.getCoordinates(2,3,2,0, takenCoordinates);


			 for(int i = 0; i < takenCoordinates.size();i++)
				System.out.println(takenCoordinates.get(i));   
		}else if(gameNumber == 2) {
			System.out.println("You entered two.");
		}else if(gameNumber == 3) {
			System.out.println("You entered three.");
		}else {
			System.out.println("Please enter '1', '2' or '3'.");
		}
	}
}