package hobby.fibonacci;

import java.util.Scanner;

public class FibonacciSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n,a,b,c;
		Scanner in = new Scanner(System.in);
		a=0;
		b=1;
		System.out.println("Enter n::");
		n = in.nextInt();
		System.out.println(a+"\n"+b);
		while(true){
			c=a+b;
			if(c>n)
				break;
			System.out.println(c);
			a=b;
			b=c;
		}
		in.close();

	}

}
