package hobby.sortWaveForm;

import java.util.Arrays;

public class SortWaveForm {

	public static void main(String[] args) {
		SortWaveForm sortWaveForm = new SortWaveForm();
		int[] arr = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		sortWaveForm.sortInWave(arr, arr.length);
		for(int i : arr){
			System.out.print(i+" ");
		}
	}
	
	void sortInWave(int[] arr, int n){
		Arrays.sort(arr);
		int temp;
		for(int i = 0; i < n-1; i+=2){
			temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
	}

}
