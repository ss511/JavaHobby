package hobby.palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Palindrome {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		Palindrome palindrome = new Palindrome();
		String str;
		//InputStreamReader is = new InputStreamReader(System.in);
		//BufferedReader br = new BufferedReader(is);
		//str = br.readLine();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter A String::");
		str = in.nextLine();
		in.close();
		if(palindrome.isPalindrome(str) == false){
			System.out.println(str+" is not palindrome");
		}
		else
			System.out.println(str+" is palindrome");

	}
	
	boolean isPalindrome(String str){
		if("".equals(str) || str == null){
			return false;
		}
		String reverseStr = getReverse(str);
		if(reverseStr.equals(str)){
			return true;
		}
		else
			return false;
	}
	
	String getReverse(String str){
		
		String reverseString = "";
		//Easy method
		/*StringBuffer sb = new StringBuffer(str);
		reverseString = sb.reverse().toString();*/
		int length = str.length();
		for(int i = length-1; i>=0; i--){
			reverseString = reverseString+str.charAt(i);
		}
		System.out.println("Reverse String Is::"+reverseString);
		return reverseString;
	}

}
