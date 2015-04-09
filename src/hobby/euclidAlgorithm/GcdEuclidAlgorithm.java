package hobby.euclidAlgorithm;

import java.util.Scanner;

/*
 * This program finds GCD (Greatest Common Divisor using Euclid's Algorithm)
 * 
 */
public class GcdEuclidAlgorithm {
	public static void main(String[] args){
		GcdEuclidAlgorithm euclid = new GcdEuclidAlgorithm();
		System.out.println("Enter two numbers of which GCD has to be found::");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		in.close();
		euclid.findGCD(a, b);
	}
	void findGCD(int a, int b){
		int divisor = a<=b?a:b;
		int dividend = a>=b?a:b;
		int remainder;
		while(divisor!=0){
			remainder = dividend % divisor;
			dividend = divisor;
			divisor = remainder;
		}
		System.out.println("The GCD is ::"+dividend);
	}
}
