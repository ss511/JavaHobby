package hobby.binarySearch;

public class MinElementSortedRotatedArray {

	public static void main(String[] args) {
		MinElementSortedRotatedArray minElementSortedRotatedArray = new MinElementSortedRotatedArray();
		int[] arr = {8,9,10,1,2,3,4,5,6,7};
		int low = 0;
		int high = arr.length-1;
		int min = minElementSortedRotatedArray.findMin(arr, low, high);
		System.out.println("Minimum Element is ::: "+min);
	}
	/*int findMin(int[] arr, int low, int high){
		if(high < low)
			return arr[0];
		if(high == low)
			return arr[low];
		int mid = (high+low)/2;
		if(mid < high && arr[mid+1] < arr[mid]){
			return arr[mid+1];
		}
		if(mid > low && arr[mid] < arr[mid-1])
			return arr[mid];
		if(arr[high] > arr[mid]){
			return findMin(arr, low, mid-1);
		}
		return findMin(arr, mid+1, low);
	}*/
	
	int findMin(int[] arr, int low, int high){
		
		int mid = (high+low)/2;
		if(high == low){
			System.out.println(arr[low]);
			return arr[low];
		}
		if(high < low){
			return arr[0];
		}
		if(arr[mid] < arr[high]){
			if(arr[mid] < arr[mid+1]){
				return findMin(arr, low, mid-1);
			}
			else{
				return findMin(arr, mid+1, high);
			}
		}
		else if(arr[mid] >= arr[low]){
			if(arr[mid] < arr[mid-1]){
				return findMin(arr, low, mid-1);
			}
			else{
				return findMin(arr, mid+1, high);
			}
		}
		return -1;
	}
}
