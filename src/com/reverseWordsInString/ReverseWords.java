package com.reverseWordsInString;

/*
 * This program reverses words in a String
 * Thank.you.very.much becomes much.very.you.Thank
 * 
 */
public class ReverseWords {

	public static void main(String[] args) {
		String str = "Thank.you.very.much";
		ReverseWords reverseWords = new ReverseWords();
		reverseWords.reverse(str);
	}
	
	void reverse(String str){
		String[] strs = str.split("\\.");
		int start = 0;
		int end = strs.length-1;
		String temp;
		while(start<=end){
			temp = strs[start];
			strs[start] = strs[end];
			strs[end] = temp;
			start++;
			end--;
		}
		StringBuilder stringBuilder = new StringBuilder();
		if(strs.length > 0){
			for(String st : strs){
				stringBuilder.append(st).append('.');
			}
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		String newStr = stringBuilder.toString();
		System.out.println("Modified String is ::: "+newStr);
	}
}
