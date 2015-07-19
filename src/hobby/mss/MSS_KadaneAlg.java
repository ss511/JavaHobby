package hobby.mss;

public class MSS_KadaneAlg {
	//Kadane Algorithm is super efficient but doesn't work if all the elements are negative in an array
	public void findMSS(int arr[]){
		int ans = 0;
		int sum = 0;
		int n = arr.length;
		for(int i=0; i<n; ++i){
			if(sum+arr[i]>0){
				sum+=arr[i];
			}
			else
				sum=0;
			ans = Math.max(sum, ans);
		}
		System.out.println("Answer using Kadane Algorithm is::"+ans);
	}
}
