import java.util.*;
import java.io.*;

public class RushHour {

	private int boardSize;

	public static void main(String args[]) {

		CoordinatesHashTable occupied = new CoordinatesHashTable();


		RushHour game = new RushHour();
		int[][] board = game.preparations(occupied);
		// game.moveCars(occupied);
	}

	// Prepare the game for the AI to play with
	public int[][] preparations(CoordinatesHashTable occupied) {

		int gameNumber;
		SimonsHashTable sht = new SimonsHashTable();
		int key;

		int[][] test = {
			{0,0},
			{0,0}};

		Scanner input = new Scanner(System.in);

		System.out.println("Which game do you want to play? 1, 2 or 3?");
		gameNumber = input.nextInt();

		if(gameNumber == 1) {
			
			boardSize = 6;

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
        		getWallCoordinates(walls[i], occupied);
        	}

        	for(int i = 0; i < cars.length; i++){
        		getCarCoordinates(cars[i], occupied);
        	}
				
			for(int i = 0; i < occupied.size();i++)
				System.out.println(occupied.get(i)); 
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


	// public void moveCars() {
	// 	if
	// }
























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
	public CoordinatesHashTable getCarCoordinates(int[] car,
		CoordinatesHashTable occupied){

		int length = 0;
		int[] place = new int[2];
		int key;

		int x = car[0];
		int y = car[1];
		int type = car[2];
		int direction = car[3];


		if(direction == 0) {
			if(type == 0 || type == 1) {
				length = 2;
			} else if(type == 2) {
				length = 3;
			}
			for(int i = 0; i < length; i++) {
				place = makeCoordinate((x + i), y);
				key = place[0]+place[1]*8;
				occupied.put(key, place);
			}
			return occupied;
		}else if(direction == 1){
			if(type == 0 || type == 1) {
				length = 2;
			} else if(type == 2) {
				length = 3;
			}
			for(int i = 0; i < length; i++) {
				place = makeCoordinate(x, (y + i));
				key = place[0]+place[1]*8;
				occupied.put(key, place);
			}
			return occupied;
		}else{
			return occupied;
		}
	}

	public int[] makeCoordinate(int x, int y) {
		int[] coordinate = new int[2];
		coordinate[0] = x;
		coordinate[1] = y;
		return coordinate;
	}

	public void getWallCoordinates(int[] wall, 
		CoordinatesHashTable occupied) {
			
		int key = wall[0]+wall[1]*8;
		occupied.put(key, wall);
	}

	private void print(int[] wall, int i){
		System.out.println("i: " + i + ", x: " + wall[0] + ", y: " + wall[1]);
	}

	public void moveForward(int[] car) {
		car[car[3]] += 1;
	}

	public void moveBackward(int[] car) {
		car[car[3]] -= 1;
	}

}