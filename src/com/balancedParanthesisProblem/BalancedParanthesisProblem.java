package com.balancedParanthesisProblem;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesisProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		Scanner in = new Scanner(System.in);
		System.out.println("Please Enter text with parenthesis");
		String text = in.nextLine();
		char[] ch = text.toCharArray();
		in.close();
		if((text.indexOf('(') < 0) && (text.indexOf(')') < 0 )){
			System.out.println("The text doesn't have opening and closing paranthesiss");
			return;
		}
		if((text.indexOf('(') < 0) && (text.indexOf(')') >= 0 )){
			System.out.println("The text has only closing paranthesiss");
			return;
		}
		int length = text.length();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < length; i++){
			if(ch[i] == '('){
				stack.push(ch[i]);
			}
			if(ch[i] == ')' && stack.empty() == false){
				stack.pop();
			}
		}
		if(stack.size() == 0){
			System.out.println("The text has balanced paranthesis");
		}
		else{
			System.out.println("The text doesn't have balanced paranthesis");
		}
	}

}
