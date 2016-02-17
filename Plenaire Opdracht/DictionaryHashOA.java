public class DictionaryHashOA {

	public static void main(String[] args) {
		DictionaryHashOA dhoa = new DictionaryHashOA();
		SimonsHashTable sht = dhoa.read("wordlist.txt");
		SimonsHashTable sht = dhoa.read("sample_0OXg@T=T55.txt");

	}

	public String[] read(String file){

		int count = 0;
		String control;
		SimonsHashTable sht = new SimonsHashTable();


		try (BufferedReader br = new BufferedReader(new FileReader(file)))
		{
			// Reads lines until the end of the file
			while ((control = br.readLine()) != null) {
				// Doubles the length of the array if it's full
				if(count == (sht.length-1)){
					sht = Arrays.copyOf(sht, sht.length*2);
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

}