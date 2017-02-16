package hobby.recursion;

/*
 * Prints all the combinations of an array
 */
public class ArrayCombinations {

	public static void main(String[] args) {
		ArrayCombinations ac = new ArrayCombinations();
		int[] arr = {2,3,1,4,6,5};
		int[] gArr = {2,3,1,4,6,5};
		int length = arr.length;
		ac.combinations(arr, gArr, 0, length);
	}

	private void combinations(int[] arr, int[] gArr, int k, int n){
		if(k == n-1){
			arr[k] = 0;
			printArr(arr, gArr, n);
			arr[k] = 1;
			printArr(arr, gArr, n);
			return;
		}
		arr[k] = 0;
		combinations(arr, gArr, k+1, n);
		arr[k] = 1;
		combinations(arr, gArr, k+1, n);
	}
	
	private void printArr(int[] arr, int[] gArr, int n){
		int sum = 0;
		for(int i = 0; i < n; i++){
			if(arr[i] == 1){
				System.out.print(gArr[i]+ " ");
				sum++;
			}
		}
		if(sum == 0){
			System.out.println("null set");
		}
		System.out.println();
	}
}
