package hobby.wordCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCount {

	public static void main(String[] args) {
		String str = "Who is the world's richest man? The hint is he used to be the ceo of microsoft long time ago. "
				+ "Microsoft is the world's one of the largest IT company. The other companies which feature in the "
				+ "largest company list is Google, Apple, Facebook, Amazon. Still not getting the answer. The world's richest man "
				+ "is Bill Gates.";
		
		str = str.toLowerCase().replaceAll("[.,?!]", "");
		//System.out.println(str);
		WordCount wordCount = new WordCount();
		wordCount.getCounts(str);
	}
	
	public void getCounts(String str) {
		String[] st = str.split(" ");
		int len = st.length;
		
		Map<String, Words> map = new HashMap<String, Words>();
		Words words = null;
		for (int i = 0; i < len; i++) {
			String word = st[i];
			if(map.containsKey(word)) {
				words = map.get(word);
				words.setCount(words.getCount()+1);
				map.put(word, words);
			}
			else {
				words = new Words();
				words.setWord(word);
				words.setCount(1);
				words.setOccr(i);
				map.put(word, words);
			}
		}
		List<Map.Entry<String, Words>> wordList = new ArrayList<Map.Entry<String,Words>>(map.entrySet());
		Collections.sort(wordList, new Comparator<Map.Entry<String, Words>>() {

			public int compare(Entry<String, Words> o1, Entry<String, Words> o2) {
				if(o1.getValue().getCount() != o2.getValue().getCount())
					return o2.getValue().getCount() - o1.getValue().getCount();
				else
					return o1.getValue().getOccr() - o2.getValue().getOccr();
			}
		});
		printWords(wordList);
		
	}
	
	public void printWords(List<Map.Entry<String, Words>> wordList) {
		/*Set<Map.Entry<String, Words>> set =map.entrySet();
		Iterator<Map.Entry<String, Words>> it = set.iterator();
		while(it.hasNext()) {
			Entry<String, Words> entry = it.next();
			System.out.println(entry.getKey() + " - " + entry.getValue().getCount() + " - " + entry.getValue().getOccr());
		}
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			System.out.println(map.get(keyIterator.next()).getCount());
		}*/
		for(Entry<String, Words> entry : wordList) {
			System.out.println("For Key::: - " + entry.getKey());
			System.out.println(entry.getValue().getWord() + " - " + entry.getValue().getCount() + " - " + entry.getValue().getOccr());
		}
	}
}

class Words{
	String word;
	int count;
	int occr;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOccr() {
		return occr;
	}
	public void setOccr(int occr) {
		this.occr = occr;
	}
	
}
