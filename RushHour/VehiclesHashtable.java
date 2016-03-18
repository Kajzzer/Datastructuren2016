import java.util.*;


public class VehiclesHashtable {
	
	static int boardSize = 6;

    public static void main(String[] args) {
        int[][] cars = new int[][] {
        		{4,4,0,0},
        		{3,4,2,1},
        		{4,1,2,1},
        		{6,4,2,1},
        		{1,1,1,1},
        		{2,2,1,0},
        		{5,1,1,0},
        		{4,6,1,0},
        		{5,3,1,0}};
        
        
        

        
        int carsAmount = cars.length;
        

        
        int [] hashPrimes = primeArray(50, carsAmount * 50);
        int hashValue = boardHashValue(cars, hashPrimes, carsAmount);
        
        PathHashTable pht = new PathHashTable();
        
        pht.put(hashValue, hashValue, cars);
        		
        
        List<Integer> hvList = new ArrayList<Integer>();
//        hashValue = Arrays.deepHashCode(cars);
        hvList.add(hashValue);
        System.out.println(hvList);
        int getal = 0;
        while(!hvList.isEmpty()){
//        for(int iets = 0; iets<11;iets++){
        	List<Integer> newHVList = new ArrayList<Integer>();
        	for(int i = 0; i < hvList.size(); i++ ){
        		cars = pht.getBoard(hvList.get(i));
        		hashValue = boardHashValue(cars, hashPrimes, carsAmount);
                CoordinatesHashTable occupied = new CoordinatesHashTable();
                
            	int[][] walls = new int[(boardSize+1)*4][2];

            	makeWalls(walls);
            	
            	for(int k = 0; k < walls.length; k++){
            		getWallCoordinates(walls[k], occupied);
            	}

            	for(int k = 0; k < cars.length; k++){
            		getCarCoordinates(cars[k], occupied);
            	}
        		
        		for (int k = 0; k < carsAmount; k++){
                	int[] taken = null;
                	int steps = 0;
                	int carLength = 1;
                	int[] carClone = (int[]) cars[k].clone();
            		if(carClone[2] == 2) {
            				carLength = 2;
            			}
            		carClone[carClone[3]] += carLength;
            		while (taken == null){
            			carClone[carClone[3]] += 1;
            			steps += 1;
                	
            			if (carClone[2] == 0 && carClone[carClone[3]] == 7){
            				int[][] newCars = newCars(cars, k, cars[k][3], steps);
            				int newHash = boardHashValue(newCars, hashPrimes, carsAmount);
            				newHash = pht.put(hashValue, newHash, newCars);
            				System.out.println(pht.getPath(newHash));
            				System.exit(0);
            			}
            			
            			int hashToCheck = carClone[0] + carClone[1] * 8;
            			taken = occupied.get(hashToCheck);
                	
            			if (taken == null){
            				int[][] newCars = newCars(cars, k, cars[k][3], steps);
            				int newHash = boardHashValue(newCars, hashPrimes, carsAmount);
            				int[][] carsToCheck = pht.getBoard(newHash);
            				if (carsToCheck == null){
            					newHash = pht.put(hashValue, newHash, newCars);
        						newHVList.add(newHash);
            				} else {
            					boolean vallie = compare(newCars, carsToCheck, carsAmount);
            					if (vallie == false){
            						newHash = pht.put(hashValue, newHash, newCars);
            						newHVList.add(newHash);
            					}
            				}            				
            			}
                	}
            		taken = null;
            		steps = 0;
            		carClone = (int[]) cars[k].clone();
            		while (taken == null){
            			carClone[carClone[3]] -= 1;
            			steps -= 1;
                	    
            			int hashToCheck = carClone[0] + carClone[1] * 8;
            			taken = occupied.get(hashToCheck);
                	
            			if (taken == null){
            				int[][] newCars = newCars(cars, k, cars[k][3], steps);
            				int newHash = boardHashValue(newCars, hashPrimes, carsAmount);
            				
            				int[][] carsToCheck = pht.getBoard(newHash);
            				if (carsToCheck == null){
            					newHash = pht.put(hashValue, newHash, newCars);
        						newHVList.add(newHash);
            				} else {
            					boolean vallie = compare(newCars, carsToCheck, carsAmount);
            					if (vallie == false){
            						newHash = pht.put(hashValue, newHash, newCars);
            						newHVList.add(newHash);
            					}
            				}            				
            			}
            		}
        		}
        	}
        	
        	hvList = newHVList;
        	getal++;
        	System.out.println(getal);

        	}
        //for(int a = 0; a < occupied.size();a++)
		//	System.out.println(occupied.get(a));
        //forward moves
        
        //the same but steps backwards
        
        
        }
    
    public static void makeWalls(int[][] walls) {
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
    public static CoordinatesHashTable getCarCoordinates(int[] car,
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

    	public static int[] makeCoordinate(int x, int y) {
    		int[] coordinate = new int[2];
    		coordinate[0] = x;
    		coordinate[1] = y;
    		return coordinate;
    	}

    	public static void getWallCoordinates(int[] wall, 
    		CoordinatesHashTable occupied) {
    			
    		int key = wall[0]+wall[1]*8;
    		occupied.put(key, wall);
    	}
    
    public static int[][] newCars(int[][] cars, int row, int column, int direction) {
    	int [][] cars2 = new int[cars.length][];
    	for(int i = 0; i < cars.length; i++)
    	    cars2[i] = (int[]) cars[i].clone();
    	cars2[row][column] += direction;
    	return cars2; 
    	}
    


	public static boolean isPrime(int number) {

		// Eliminate the need to check versus even numbers
		if (number == 2)
			return true;
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

	public static int getNextPrime(int minNumberToCheck) {

		for (int i = minNumberToCheck; true; i++) {

			if (isPrime(i))
				return i;

		}

	}
	
	public static int[] primeArray(int minValue, int length) {
		int [] primes = new int[length];
		for(int i = 0; i < length; i++) {
			primes[i] = getNextPrime(minValue);
			minValue = primes[i] + 1;
		}
	
		return primes;
	}

	
	public static int boardHashValue(int [][] cars, int [] hashPrimes, int carsAmount) {
		int hashValue = 1;
		for(int i = 0; i < carsAmount; i++) {
			hashValue += cars[i][0] * hashPrimes[50 * i];
			hashValue += cars[i][1] * hashPrimes[50 * i + 1];
		}
		return hashValue;
	}


	public static boolean compare(int[][] cars, int[][] newCars, int carsAmount){
		for (int i = 0; i< carsAmount; i++){
			for (int j = 0; j < 4; j++){
				if (cars[i][j] != newCars[i][j]){
					return false;
				}
			}
		}
		return true;
    }
}
