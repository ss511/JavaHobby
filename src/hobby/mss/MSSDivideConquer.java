package hobby.mss;

public class MSSDivideConquer {
	
	public void findMSS(int arr[]){
		int n = arr.length;
		int ans = findMSSRecursion(arr, n);
		System.out.println("Answer Using Divide and Conquer is"+ ans);
	}
	int findMSSRecursion(int arr[], int n){
		if(n==1){
			return arr[0];
		}
		int m=n/2;
		int[] rightArray = new int[n-m];
		int j=0;
		for(int i=m; i<n; i++){
			rightArray[j] = arr[i];
			j++;
		}
		int leftMSS = findMSSRecursion(arr, m);
		int rightMSS = findMSSRecursion(rightArray, n-m);
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=m; i<n; i++){
			sum += arr[i];
			rightSum = Math.max(rightSum, sum); 
		}
		System.out.println("1 Sum is::"+sum);
		System.out.println("RightSum is::"+rightSum);
		sum = 0;
		for(int i = (m-1); i>=0; i--){
			sum += arr[i];
			leftSum = Math.max(leftSum, sum); 
		}
		System.out.println("2 Sum is::"+sum);
		System.out.println("LeftSum is::"+leftSum);
		int ans = Math.max(leftMSS, rightMSS);
		System.out.println("Ans is"+ ans);
		return Math.max(ans, leftSum+rightSum);
	}
}
