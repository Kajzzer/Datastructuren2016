// Implement the Unix cat utility in java

import java.util.*;
import java.io.*;

public class DictionaryArray {

	public static void main(String[] args) {

		DictionaryArray da = new DictionaryArray();
		String dict[] = da.read("wordlist.txt");
		String sample[] = da.read("sample_0OXg@T=T55.txt");
		
		// for(int i=0; i < dict.length; i++){
		// 	System.out.println(dict[i]);
		// }
		
		long startTime = System.currentTimeMillis();
		int verified = da.checkWords(dict,sample);
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;

		System.out.println("The ratio is "+ verified + " verified words" +
			" of the " + sample.length + " total words.");
		System.out.println("It took the program " + totalTime + "ms to verify" +
			" the sample file.");
	}	

	// Read out a file and puts it into an array
	public String[] read(String file){

		int count = 0;
		String control;
		String dict[] = new String[1];


		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			// Reads lines until the end of the file
			while ((control = br.readLine()) != null) {
				// Doubles the length of the array if it's full
				if(count == (dict.length-1)){
					dict = Arrays.copyOf(dict, dict.length*2);
				}
				// Puts the word into the array
				dict[count] = control;
				count += 1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Shrinks the array so that there are no null values
		dict = Arrays.copyOf(dict, count);
		return dict; 
	}

	// Compares the dictionary with the sample file
	public int checkWords(String dict[], String sample[]){

		// Counter for the number of verified words
		int verified = 0;
 
		// Goes through every word in the sample file for comparison
		for(int i=0; i < sample.length; i++){

			// Goes through every word in the dictionary to compare them
			for(int j=0; j < dict.length; j++){
				// If the sample is the same as a word in the dictionary,
				// it counts it as verified and goes on to the next sample
				if(sample[i].equals(dict[j])){
					verified += 1;
					break;
				}
			}
		}
		return verified;	
	}
}

// SimonsHashTable