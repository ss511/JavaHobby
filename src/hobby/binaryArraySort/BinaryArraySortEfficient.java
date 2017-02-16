package hobby.binaryArraySort;

/*
 * More efficient way to sort binary array
 * To sort in descending order just have arr[i] == 1 and arr[j] == 0
 *  
 */
public class BinaryArraySortEfficient {

	public static void main(String[] args) {
		int[] arr = {1,0,0,1,0,0,1,1,1,0,0};
		int length = arr.length;
		int i = 0;
		int j = length-1;
		int temp = 0;
		while(i<j){
			if(arr[i] == 0){
				i++;
			}
			else if(arr[j] == 1){
				j--;
			}
			else{
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		for(i = 0; i < length; i++){
			System.out.print(arr[i]+" ");
		}
	}

}
