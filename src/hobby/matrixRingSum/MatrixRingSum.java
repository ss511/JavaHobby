package hobby.matrixRingSum;

import java.util.Scanner;

public class MatrixRingSum {
	public static void main(String[] args){
		System.out.println("Start");
		Scanner in = new Scanner(System.in);
		int n;
		System.out.println("Enter n");
		n = in.nextInt();
		int[][] matrix = new int[n][n];
		System.out.println("Enter matrix element");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = in.nextInt();
			}
		}
		int start = 0;
		int end = n-1;
		int i = 0;
		int j = 0;
		while(true){
			int sum = 0;
			int flag = 0;
			while(true){
				if(i==start && j<end){
					flag=1;
					sum+=matrix[i][j];
					j++;
				}
				else if(j==end && i<end){
					sum+=matrix[i][j];
					i++;
				}
				else if(i>start && j>start){
					sum+=matrix[i][j];
					j--;
				}
				else if(j==start && i >start){
					sum+=matrix[i][j];
					i--;
				}
				if(i==start && j==start){
					if(flag == 0){
						sum+=matrix[i][j];
					}
					break;
				}
			}
			System.out.println("The sum of "+(start+1)+"th ring is:::"+sum);
			start++;
			end--;
			i++;
			j++;
			if(start>end){
				break;
			}
		}
		in.close();
	}
}
