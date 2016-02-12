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
		da.checkWords(dict,sample);

	}	

	public String[] read(String file){

		int count = 0;
		String control;
		String dict[] = new String[1];


		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{

			while ((control = br.readLine()) != null) {
				if(count == (dict.length-1)){
					dict = Arrays.copyOf(dict, dict.length*2);
				}
				dict[count] = control;
				count += 1;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		dict = Arrays.copyOf(dict, count);
		return dict; 
	}

	public checkWords(String dict[], String sample[]){

		for(int i=0; i < sample.length; i++){
			for(int j=0; j < dict.length; j++){
				
			}
		}
	}
}

// SimonsHashTable