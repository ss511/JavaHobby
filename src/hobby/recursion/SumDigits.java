package hobby.recursion;

public class SumDigits {

	public static void main(String[] args) {
		SumDigits sd = new SumDigits();
		int n = 21298;
		System.out.println(sd.sumD(n));
	}
	
	private int sumD(int n){
		if(n<1){
			return 0;
		}
		int sum = 0; 
		sum = sum+(n%10)+sumD(n/10);
		return sum;
	}
}
