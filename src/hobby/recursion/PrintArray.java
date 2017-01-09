package hobby.recursion;

public class PrintArray {

	public static void main(String[] args) {
		PrintArray pa = new PrintArray();
		int[] arr = {2,3,1,4,5,0,90,87};
		int length = arr.length;
		pa.printArr(arr, length);
		
	}
	private void printArr(int[] arr, int n){
		if(n==0){
			return;
		}
		else{
			printArr(arr, n-1);
			System.out.println(arr[n-1]);
		}
	}
}
