package hobby.binarySearch;

/*
 * Given a matrix mat[m][n] with 0s and 1s in sorted order.
 * Find the row which has max number of 1.
 * Tag - Binary Search
 */
public class Max1Row {

	public static void main(String[] args) {
		//int[][] matrix = {{0,0,1,1},{0,1,1,1},{0,0,0,1}};
		//int[][] matrix = {{0,1,1,1},{0,0,0,0},{0,0,0,1},{1,1,1,1}};
		int[][] matrix = {{0,0,0,0,1,1,1},{0,0,0,0,0,0,0},{0,0,0,0,0,0,1},{0,0,1,1,1,1,1},{0,0,0,1,1,1,1}};
		Max1Row max1Row = new Max1Row();
		int index = max1Row.findMaxRow(matrix);
		System.out.println("Row with maximum number of 1 is::: "+index);
	}
	int findMaxRow(int[][] matrix){
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int low = 0;
		int high = n-1;
		int mid = 0;
		int num = 0;
		int index = 0;
		for(int i = 0; i < m; i++){
			num = 0;
			low = 0;
			high = n-1;
			if(matrix[i][low] == 1){
				num = n;
				return i;
			}
			else if(matrix[i][high] == 0){
				num = 0;
			}
			else{
				while(low <= high){
					mid = (low+high)/2;
					if(matrix[i][mid] == 0){
						low = mid + 1;
					}
					if(matrix[i][mid] == 1){
						num = num + (high-mid)+1;
						high = mid - 1;
					}
				}
			}
			if(num > max){
				index = i;
			}
			max = Math.max(max, num);
		}
		return index;
	}
}
