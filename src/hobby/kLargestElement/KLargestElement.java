package hobby.kLargestElement;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElement {

	public static void main(String[] args) {
		int[] arr = {5,1,2,8,9,10,15,14,12,60,30};
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the K value");
		int k = in.nextInt();
		int len = arr.length;
		if(k <= len)
			largest(arr, k);
		else {
			System.out.println("Invalid k value");
		}
		System.out.println("Enter the K value to find k smallest element");
		k = in.nextInt();
		if(k <= len)
			smallest(arr, k);
		else {
			System.out.println("Invalid k value");
		}
	}
	
	static void largest(int[] arr, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		for(int i : arr) {
			q.offer(i);
			if(q.size() > k) {
				q.poll();
			}
		}
		System.out.println(q.peek());
		/*while (!q.isEmpty()) {
			System.out.println(q.poll());
		}*/
	}
	static void smallest(int[] arr, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int i: arr) {
			q.offer(i);
			if(q.size() > k) {
				q.poll();
			}
		}
		System.out.println(q.peek());
	}
}
