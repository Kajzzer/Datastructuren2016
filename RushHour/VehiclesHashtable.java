import java.util.ArrayList;
import java.util.List;


public class VehiclesHashtable {

    public static void main(String[] args) {
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
        
        
        int carsAmount = cars.length;
        
        int [] hashPrimes = primeArray(7, carsAmount * 2);
        int hashValue = boardHashValue(cars, hashPrimes, carsAmount);
        
        System.out.println(hashValue);
        
        
        //forward moves
        for (int i = 0; i < carsAmount; i++){
        	boolean taken = false;
        	int[] carClone = (int[]) cars[i].clone();
        	//check if coordinate carClone + carlength(in its direction) is taken
        	//if not. Clone all vehicles in a loop and store in hashtable
        	if (taken == false){
        		
        		int[][] newCar = newCars(cars, i, cars[i][3]);
        		
        	}
        	}
        //the same but steps backwards
        }
        

        
    
    public static int[][] newCars(int[][] cars, int row, int column) {
    	
    	int [][] cars2 = new int[cars.length][];
    	for(int i = 0; i < cars.length; i++)
    	    cars2[i] = (int[]) cars[i].clone();
    	cars2[row][column] += 1;
    	return cars2; 
    	}

	public static boolean isPrime(int number) {

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
		int hashValue = 0;
		for(int i = 0; i < carsAmount; i++) {
			hashValue += cars[i][0] * hashPrimes[2 * i];
			hashValue += cars[i][1] * hashPrimes[2 * i + 1];
		}
		return hashValue;
	}
}