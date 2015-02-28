package hobby.anagram;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		List anagramList = new ArrayList();
		System.out.println("Input Strings");
		Scanner input = new Scanner(System.in);
		for(int i=0; i<3; i++)
			anagramList.add(input.nextLine());
		boolean anagram;
		input.close();
		anagram = a.isAnagram(anagramList);
		System.out.println("The set of Strings are Anagrams:"+anagram);

	}
	boolean isAnagram(List anagramList){
		int anagramSize = anagramList.size();
		char ch[][] = new char[anagramSize][];
		int flag = 1;
		for(int i=0; i<anagramSize; i++){
			ch[i] = anagramList.get(i).toString().toCharArray();
			Arrays.sort(ch[i]);
			if(!Arrays.equals(ch[i], ch[0])){
				flag = 0;
			}
		}
		
		if(flag == 1){
			return true;
		}
		else
			return false;
	}

}
