package hobby.binaryArraySort;

/*
 * 
 * Sort a binary array such that all the ones come on right side and all zeroes on left.
 * Can iterate over array only once.
 */
public class BinaryArraySort {

	public static void main(String[] args) {
		int arr[] = {1,1,0,1,0,0,0,1,1};
		int n = arr.length;
		int i = 0;
		int j = n-1;
		while(i<j){
			while(arr[i] == 0 && i < j)
				i++;
			while(arr[j] == 1 && i < j)
				j--;
			if(i<j){
				arr[i] = 0;
				arr[j] = 1;
				i++;
				j--;
			}
		}
		for(i=0;i<n;i++){
			System.out.println(arr[i]);
		}
	}

}
