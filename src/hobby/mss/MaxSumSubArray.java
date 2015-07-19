package hobby.mss;

import java.util.Scanner;

public class MaxSumSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		System.out.println(Integer.MIN_VALUE);
		MSSDivideConquer mdc = new MSSDivideConquer();
		MSS_KadaneAlg mka = new MSS_KadaneAlg();
		int arr[] = new int[10];
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Array Length");
		int n = in.nextInt();
		System.out.println("Enter Array Elements");
		for(int i = 0; i<n; i++){
			arr[i] = in.nextInt();
		}
		System.out.println("Enter Choice\n1-Divide and Conquer Algorithm\n2-Kadane's Algorithm");
		int choice = in.nextInt();
		if(choice == 1){
			mdc.findMSS(arr);
		}
		else if(choice == 2){
			mka.findMSS(arr);
		}
		else{
			System.out.println("Wrong choice!!! Program will exit now");
		}
		in.close();
	}

}
