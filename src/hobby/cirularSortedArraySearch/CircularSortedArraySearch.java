package hobby.cirularSortedArraySearch;

import java.util.Scanner;


/*
 * Perform Binary Search to search for an element in circular sorted array or normal sorted array.
 * Linear Search time complexity is O(n) whereas Binary Search is O(logn) which is more efficient than linear search.
 * 
 */
public class CircularSortedArraySearch {

	public static void main(String[] args) {
		//int arr[] = {12,14,17,18,3,5,7,8};
		int arr[] = {3,5,7,8,9,10,12,14};
		Scanner in = new Scanner(System.in);
		System.out.println("Enter search value");
		int num = in.nextInt();
		in.close();
		CircularSortedArraySearch csas = new CircularSortedArraySearch();
		int index = csas.returnSearchIndex(arr, num);
		if(index == -1){
			System.out.println("Sorry the number "+num+" is not present in the array");
		}
		else{
			System.out.println("The number "+num+" is present at the index "+index+" in the array");
		}
	}
	
	int returnSearchIndex(int arr[], int num){
		int length = arr.length;
		int low = 0;
		int high = length-1;
		int mid;
		while(low<=high){
			mid = (low+high)/2;
			if(num == arr[mid]) return mid;
			if(arr[mid] <= arr[high]){
				if(num>arr[mid] && num<=arr[high]){
					low = mid+1;
				}
				else{
					high = mid-1;
				}
			}
			else{
				if(num<arr[mid] && num>=arr[low]){
					high = mid-1;
				}
				else{
					low=mid+1;
				}
			}
		}
		return -1;
	}

}
