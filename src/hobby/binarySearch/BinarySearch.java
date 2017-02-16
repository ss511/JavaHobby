package hobby.binarySearch;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = {2,4,5,7,8,10,12,16,17,18};
		int search = 17;
		BinarySearch binarySearch = new BinarySearch();
		int low = 0;
		int high = arr.length - 1;
		binarySearch.binarySearchUtil(arr, low, high, search);
	}

	void binarySearchUtil(int[] arr, int low, int high, int searchElement){
		if(low>high){
			System.out.println("Element " + searchElement + " does not exist in the array");
			return;
		}
		
		int mid = (low + high)/2;
		if(arr[mid] == searchElement){
			System.out.println("Search Element " + searchElement + " found at " + mid + " position");
			return;
		}
		else if(searchElement < arr[mid]){
			binarySearchUtil(arr, low, mid - 1, searchElement);
		}
		else{
			binarySearchUtil(arr, mid + 1, high, searchElement);
		}
		
	}
}
