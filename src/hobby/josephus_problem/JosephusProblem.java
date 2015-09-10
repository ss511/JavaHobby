package hobby.josephus_problem;

import java.util.Scanner;

/*
 * Solution code for Josephus Problem
 * Suppose 100 people are standing in circle. First kills second person and hands over the sword to third which kills fourth
 * and hands over the sword to fifth and the process continues until only one person is left behind
 * 
 * The solution for this problem comes from the theorem - If n=2^m+a and 0<=a<2^m, then f(n) = 2a+1.
 * For 100 people the solution is 73
 */
public class JosephusProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfPeople;
		JosephusProblem jp = new JosephusProblem();
		System.out.println("Enter the number of people standing in the circle");
		numberOfPeople = in.nextInt();
		in.close();
		jp.lastManStanding(numberOfPeople);
	}
	
	private void lastManStanding(int numberOfPeople){
		int m = 0;
		int l;
		int i=1;
		while(Math.pow(2,i)<=numberOfPeople){
			m=i;
			i++;
		}
		l = (int) (numberOfPeople - Math.pow(2, m));
		int lastMan;
		lastMan = 2*l+1;
		System.out.println("The Last Man Standing is:"+lastMan);
	}

}
