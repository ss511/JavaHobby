package hobby.sieveErastosthenes;

import java.util.Scanner;

public class SieveErastosthenes {

	public static void main(String[] args) {
		System.out.println("Input the number upto which you want list of prime numbers::");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.close();
		SieveErastosthenes se = new SieveErastosthenes();
		se.findPrime(num);
	}
	
	void findPrime(int num){
		int primes[] = new int[num+1];
		for (int i=0; i<=num; i++){
			primes[i] = 1;
		}
		primes[0] = 0;
		primes[1] = 0;
		double numSqrt = Math.sqrt(num);
		for(int i=2; i<=numSqrt; i++){
			if(primes[i] == 1){
				for(int j=2; i*j<=num; j++){
					primes[i*j] = 0;
				}
			}
		}
		System.out.println("Prime numbers upto "+num+" are:");
		for(int i = 0; i<=num; i++){
			if(primes[i] == 1){
				System.out.println(" "+i);
			}
		}
	}

}
