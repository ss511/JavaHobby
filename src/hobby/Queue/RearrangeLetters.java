package hobby.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * This program rearranges a String such that no two same elements are adjacent to each other
 * Eg. aaabc will be rearranged to abaca
 * 
 */
public class RearrangeLetters {

	public static void main(String[] args) {
		Letters letters = new Letters();
		String str = "acbb";
		Queue<Letters> queue = new PriorityQueue<Letters>(new LetterComparator());
		int[] count = new int[26];
		int n = str.length();
		
		for(int i = 0; i < n; i++){
			count[str.charAt(i) - 'a']++;
		}
		for(char c = 'a'; c <= 'z'; c++){
			if(count[c - 'a'] > 0){
				letters = new Letters();
				letters.setLetter(c);
				letters.setFreq(count[c - 'a']);
				queue.add(letters);
			}
		}
		Letters prev = new Letters();
		prev.setFreq(-1);
		prev.setLetter('#');
		//System.out.println(queue.size());
		StringBuilder stringBuilder = new StringBuilder();
		while(!queue.isEmpty()){
			letters = new Letters();
			letters = queue.poll();
			stringBuilder.append(letters.getLetter());
			letters.setFreq((letters.getFreq()) - 1);
			if(prev.getFreq() > 0){
				queue.add(prev);
			}
			prev = letters;
		}
		String newString = stringBuilder.toString();
		if(n != newString.length())
			System.out.println("Not possible");
		else{
			System.out.println(newString);
		}
	}

}

class Letters{
	private Character letter;
	private int freq;
	public Character getLetter() {
		return letter;
	}
	public void setLetter(Character letter) {
		this.letter = letter;
	}
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	
	
}

class LetterComparator implements Comparator<Letters>{

	public int compare(Letters l1, Letters l2) {
		return l2.getFreq() - l1.getFreq();
	}
	
}