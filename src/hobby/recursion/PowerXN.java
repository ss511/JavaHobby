package hobby.recursion;

/*
 * To calculate power(x,n) in log(n) time using divide and conquer
 */
public class PowerXN {

	public static void main(String[] args) {
		PowerXN px = new PowerXN();
		int n = 8;
		int x = 4;
		
		System.out.println("The answer is::"+px.getPower(x, n));
	}
	
	private int getPower(int x, int n){
		if(n== 0){
			return 1;
		}
		int temp = 1;
		temp = getPower(x, n/2);
		if((n%2) == 0){
			return (temp*temp);
		}
		else{
			return (x*temp*temp);
		}
	}
}
