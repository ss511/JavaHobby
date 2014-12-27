package hobby.prime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrimeFactor pf = new PrimeFactor();
		int num = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number");
		num = in.nextInt();
		in.close();
		if(pf.isPrime(num))
			System.out.println(num+" is prime");
		else
			System.out.println(num+" is not prime");
		System.out.println("Other prime numbers upto "+num+" are: "+pf.otherPrimes(num));
		
	}
	boolean isPrime(int num){
		int numFactor = numOfFactors(num, true);
		if(numFactor<=2)
			return true;
		return false;
	}
	List otherPrimes(int num){
		List primes = new ArrayList();
		for(int i=2; i<=num; i++){
			if(numOfFactors(i, false)<=2){
				primes.add(new Integer(i));
			}
		}
		return primes;
		
	}
	int numOfFactors(int num, boolean display){
		int numFactors=0;
		List numList = new ArrayList();
		//int numSqrt = (int) Math.ceil(Math.sqrt(num));
		double numSqrt = Math.sqrt(num);
		for(int i=1; i<=numSqrt; i++){
			if((num%i)==0){
				numList.add(new Integer(i));
				if(i!=numSqrt)
					numList.add(new Integer(num/i));
			}
		}
		if(display){
			Iterator it = numList.listIterator();
			while(it.hasNext()){
				System.out.println("Factors are:::"+it.next());
			}
		}
		numFactors = numList.size();
		return numFactors;
	}

}
