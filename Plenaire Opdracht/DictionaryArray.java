// Implement the Unix cat utility in java

import java.util.*;
import java.io.*;

public class DictionaryArray {

	public static void main(String[] args) {

		try (BufferedReader br = new BufferedReader(new FileReader("wordlist.txt")))
		{

			String control;
			
			int numberOfWords = 0;

			while ((control = br.readLine()) != null) {
				numberOfWords += 1;
			}

			String words[] = new String[numberOfWords];

			for(int i = 0; i < numberOfWords; i++){
				words[i] = br.readLine();
			}
			System.out.println(words[2]);
			System.out.println(numberOfWords);

		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}