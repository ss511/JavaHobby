package hobby.recursion;

public class NumbersSum {

	public static void main(String[] args) {
		
		int n = 10;
		int sum = 0;
		/*for(int i = 1; i <= n; i++){
			sum+=i;
		}
		System.out.println(sum);*/
		NumbersSum ns = new NumbersSum();
		sum = ns.getSum(n);
		System.out.println("The sum of "+n+" is:::"+sum);
	}
	
	private int getSum(int n){
		int sum = n;
		if(n == 1){
			return 1;
		}
		else{
			sum = sum+getSum(--n);
			return sum;
		}
	}

}
