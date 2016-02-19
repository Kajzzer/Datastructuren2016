
import java.util.*;
import java.io.*;

public class DictionaryHashC {

	public static void main(String[] args) {
		DictionaryHashC dhc = new DictionaryHashC();
		SimonsLinkedHash wllh = dhc.readH("wordlist.txt");
		// for(int i=0;i<wllh.size();i++)
			System.out.println(wllh);
		String[] sample = dhc.readA("sample_0OXg@T=T55.txt");

		long startTime = System.currentTimeMillis();
		int verified = dhc.compare(wllh, sample);
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime)*1000;

		System.out.println("The ratio is "+ verified + " verified words" +
			" of the " + sample.length + " total words.");
		System.out.println("It took the program " + totalTime + "ns to verify" +
			" the sample file.");
	}

	// Read out a file and puts it into a hashtable
	public SimonsLinkedHash readH(String file){

		String control;
		SimonsLinkedHash sht = new SimonsLinkedHash();
		int key = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			// Reads lines until the end of the file
			while ((control = br.readLine()) != null) {
				// Gets a key (positive ASCII value of the word)  
				key = Math.abs(control.hashCode());
				// Puts the word with key in the hashtable
				sht.put(key, control);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sht; 
	}

	// Read out a file and puts it into an array
	public String[] readA(String file){

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

	public int compare(SimonsLinkedHash wlsht, String[] ssht) {

		// Counter for the number of verified words
		int verified = 0;
		

		// Goes through every word in the sample file for comparison
		for(int i=0; i < ssht.length; i++){
			boolean check = false;
			// Gets a key (positive ASCII value of the sample word) 
			int sampleKey = Math.abs(ssht[i].hashCode() % wlsht.size());
			String wlword = wlsht.get(sampleKey);
			if(wlword != null) {
				LinkedHashEntry entry = wlsht.hashTable[sampleKey]; 
				while(ssht[i].equals(wlword) == false && entry.getNext() != null) {
					// If the words are the same, verify it
						entry = entry.getNext();
				}
				if(ssht[i].equals(wlword))
					verified += 1;
			}
		}
		return verified;	
	}

}