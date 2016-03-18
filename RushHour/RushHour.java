import java.util.*;
import java.io.*;

public class RushHour {

	private int boardSize;

	public static void main(String args[]) {

		CoordinatesHashTable occupied = new CoordinatesHashTable();


		RushHour game = new RushHour();
		int[][] board = game.preparations(occupied);
		game.play(board, occupied);
	}

	// Prepare the game for the AI to play with
	public int[][] preparations(CoordinatesHashTable occupied) {

		int gameNumber;
		SimonsHashTable sht = new SimonsHashTable();
		int key;
		PathHashTable pht = new PathHashTable();

		int[][] test = {
			{0,0},
			{0,0}};

		Scanner input = new Scanner(System.in);

		System.out.println("Which game do you want to play? 1, 2 or 3?");
		gameNumber = input.nextInt();

		if(gameNumber == 1) {
			
			boardSize = 6;

			// In een klasse gooien
			int[][] cars = {
        		{4,4,0,0},
        		{3,4,2,1},
        		{4,1,2,1},
        		{6,4,2,1},
        		{1,1,1,1},
        		{2,2,1,0},
        		{5,1,1,0},
        		{4,6,1,0},
        		{5,3,1,0}};

        	int[][] walls = new int[(boardSize+1)*4][2];

        	makeWalls(walls);

        	for(int i = 0; i < walls.length; i++){
        		putWallCoordinates(walls[i], occupied);
        	}

        	for(int i = 0; i < cars.length; i++){
        		putCarCoordinates(cars[i], occupied);
        	}
				
			// for(int i = 0; i < occupied.size();i++)
			// 	System.out.println(occupied.get(i)); 
			return cars;	  
		}else if(gameNumber == 2) {
			System.out.println("You entered two.");
		}else if(gameNumber == 3) {
			System.out.println("You entered three.");
		}else {
			System.out.println("Please enter '1', '2' or '3'.");
			System.exit(0);
		}
		return test;
	}


	public void play(int[][] cars, CoordinatesHashTable occupied) {

		System.out.println("Old situation.");
		for(int i = 0; i < cars.length; i++) {
			System.out.println("Car: " + i + ", x: " + cars[i][0] + 
				", y: " + cars[i][1]);
		}

		System.out.println("New situation.");
		for(int i = 0; i < cars.length; i++) {
			moveBackward(cars[i], occupied);
			System.out.println("Car: " + i + ", x: " + cars[i][0] + 
				", y: " + cars[i][1]);
		}
	}











	public void makeWalls(int[][] walls) {
		for(int i = 0; i < ((boardSize+1)*4); i++) {
    		if(i <= (boardSize+1)){
    			walls[i][0] = 0;
    			walls[i][1] = i;
    		} else if(i >= (boardSize+1) && i <= ((boardSize+1)*2)) {
    			if(i % (boardSize+1) == 0) {
    				walls[i][0] = 7;
    			} else {
    				walls[i][0] = i % (boardSize+1);
    			}
    			walls[i][1] = 0;
    		} else if(i >= ((boardSize+1)*2) && i < ((boardSize+1)*3)) {
    			walls[i][0] = (boardSize+1);
    			if(i % (boardSize+1) == 0) {
    				walls[i][1] = 7;
    			} else {
    				walls[i][1] = i % (boardSize+1);
    			}
    		} else if(i >= ((boardSize+1)*3) && i < ((boardSize+1)*4)) {
    			if(i % (boardSize+1) == 0) {
    				walls[i][0] = 7;
    			} else {
    				walls[i][0] = i % (boardSize+1);
    			}
    			walls[i][1] = (boardSize+1);
    		}
    	}
	}


	// Get the coordinates of the vehicle
	public CoordinatesHashTable putCarCoordinates(int[] car,
		CoordinatesHashTable occupied){

		int length = 0;
		int[] newLocation = new int[2];
		int key;

		int x = car[0];
		int y = car[1];
		int type = car[2];
		int direction = car[3];

		if(type == 0 || type == 1) {
			length = 2;
		} else if(type == 2) {
			length = 3;
		}
		if(direction == 0) {
			for(int i = 0; i < length; i++) {
				newLocation = makeCoordinate((x + i), y);
				key = newLocation[0]+newLocation[1]*8;
				occupied.put(key, newLocation);
			}
		}else if(direction == 1){
			for(int i = 0; i < length; i++) {
				newLocation = makeCoordinate(x, (y + i));
				key = newLocation[0]+newLocation[1]*8;
				occupied.put(key, newLocation);
			}
		}
		return occupied;
	}

	public void moveForward(int[] car, CoordinatesHashTable occupied) {
		int length = 0;
		int[] newLocation = new int[2];
		int key;
		int[] check = new int[2];

		int x = car[0];
		int y = car[1];
		int type = car[2];
		int direction = car[3];

		if(type == 0 || type == 1) {
			length = 2;
		} else if(type == 2) {
			length = 3;
		}
		if(direction == 0) {
			newLocation = makeCoordinate((x + length),y);
			key = newLocation[0] + newLocation[1]*8;
			check = occupied.get(key);
			// System.out.println(check + ", " + key);
			if(check == null && key <= ((boardSize +2)*4)) 
				car[car[3]] += 1;
		}else if(direction == 1){
			newLocation = makeCoordinate(x, (y + length));
			key = newLocation[0]+newLocation[1]*8;
			occupied.get(key);
			check = occupied.get(key);
			// System.out.println(check + ", " + key);
			if(check == null && key <= ((boardSize +2)*4)) 
				car[car[3]] += 1;
		}
	}

	public void moveBackward(int[] car, CoordinatesHashTable occupied) {
		int[] newLocation = new int[2];
		int key;
		int[] check = new int[2];

		int x = car[0];
		int y = car[1];
		int direction = car[3];

		if(direction == 0) {
			newLocation = makeCoordinate((x -1 ),y);
			key = newLocation[0] + newLocation[1]*8;
			check = occupied.get(key);
			// System.out.println(check + ", " + key);
			if(check == null && key <= ((boardSize +2)*4)) 
				car[car[3]] -= 1;
		}else if(direction == 1){
			newLocation = makeCoordinate(x, (y - 1));
			key = newLocation[0]+newLocation[1]*8;
			occupied.get(key);
			check = occupied.get(key);
			// System.out.println(check + ", " + key);
			if(check == null && key <= ((boardSize +2)*4)) 
				car[car[3]] -= 1;
		}
	}


	public int[] makeCoordinate(int x, int y) {
		int[] coordinate = new int[2];
		coordinate[0] = x;
		coordinate[1] = y;
		return coordinate;
	}

	public void putWallCoordinates(int[] wall, 
		CoordinatesHashTable occupied) {
			
		int key = wall[0]+wall[1]*8;
		occupied.put(key, wall);
	}

	private void print(int[] array, int i){
		System.out.println("i: " + i + ", x: " + array[0] + ", y: " + array[1]);
	}

	public boolean isPrime(int number) {

		// Eliminate the need to check versus even numbers

		if (number % 2 == 0)
			return false;

		// Check against all odd numbers

		for (int i = 3; i * i <= number; i += 2) {

			if (number % i == 0)
				return false;

		}

		// If we make it here we know it is odd

		return true;

	}

	// Receives a number and returns the next prime
	// number that follows

	public int getNextPrime(int minNumberToCheck) {

		for (int i = minNumberToCheck; true; i++) {

			if (isPrime(i))
				return i;

		}

	}
	
	public int[] primeArray(int minValue, int length) {
		int [] primes = new int[length];
		for(int i = 0; i < length; i++) {
			primes[i] = getNextPrime(minValue);
			minValue = primes[i] + 1;
		}
			
		return primes;
	}
	public int boardHashValue(int[][] cars, int[] hashPrimes, int carsAmount) {
		int hashValue = 0;
		for(int i = 0; i < carsAmount; i++) {
			hashValue += cars[i][0] * hashPrimes[2 * i];
			hashValue += cars[i][1] * hashPrimes[2 * i + 1];
		}
		return hashValue;
	}

}