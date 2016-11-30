package hobby.minLengthUnsortedArray;

public class MinLengthUnsortedArray {

	public static void main(String[] args) {
		MinLengthUnsortedArray minLengthUnsortedArray = new MinLengthUnsortedArray();
		int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		int n = arr.length;
		minLengthUnsortedArray.printUnsorted(arr, n);
	}
	
	void printUnsorted(int arr[], int n){
		int start = 0;
		int end = n-1;
		int i, min, max;
		for(start = 0; start < n-1; start++){
			if(arr[start] > arr[start+1]){
				break;
			}
		}
		if(start > n){
			System.out.println("The complete array is sorted");
		}
		for(end = n-1; end > 0; end--){
			if(arr[end] < arr [end-1]){
				break;
			}
		}
		max = arr[start];
		min = arr[end];
		
		for(i = start+1; i <= end; i++){
			if(arr[i] > max){
				max = arr[i];
			}
			if(arr[i] < min){
				min = arr[i];
			}
		}
		
		for(i = 0; i <start; i++){
			if(arr[i] > min){
				start = i;
				break;
			}
		}
		
		for(i = n-1; i >= end+1; i--){
			if(arr[i] < max){
				end = i;
				break;
			}
		}
		
		System.out.println("Value of start and end is::"+start+" and "+end);
	}
}
