package hobby.duplicate_words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * This program finds the duplicate occurrences of word from a given paragraph
 * The program first writes a paragraph into a file and then read it from that file
 * Map is being used to store words as key and its occurrences as value  
 * 
 */
public class DuplicateWords {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("file.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("This is a sample program for finding the duplicate words in a paragraph");
		bw.append("\nThis program uses Map to put word as key and its occurrences as value");
		bw.append("\nFilwWriter and FileReader is used for writing and reading contents to and from the file");
		bw.close();
		fw.close();
		
		FileReader fr = new FileReader("file.txt");
		BufferedReader br = new BufferedReader(fr);
		String str = null;
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		List<String> wordList = new ArrayList<String>();
		while((str=br.readLine())!=null){
			wordList = Arrays.asList(str.split(" "));
			Iterator<String> it = wordList.listIterator();
			while(it.hasNext()){
				String newKey = it.next();
				int newValue = 1;
				if(!wordMap.containsKey(newKey)){
					wordMap.put(newKey, newValue);
				}
				else{
					newValue = wordMap.get(newKey);
					newValue++;
					wordMap.replace(newKey, newValue);
				}
			}
		}
		System.out.println(wordMap);
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("List Of Duplicate Words");
		Set<String> wordSet = wordMap.keySet();
		Iterator<String> it = wordSet.iterator();
		while(it.hasNext()){
			String key = it.next();
			if(wordMap.get(key)>1){
				System.out.println("Word: "+key+"\t\tOccurrences: "+wordMap.get(key));
			}
		}
		br.close();
		fr.close();
	}

}
