package hobby.swap_without_temp;

import java.util.Scanner;

public class SwapWithoutTemp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a,b;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a and b");
		a = in.nextInt();
		b = in.nextInt();
		System.out.println("A and B Before Swap::"+a+" "+b);
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("A and B After Swap::"+a+" "+b);
		in.close();
	}

}
