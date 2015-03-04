package hobby.armstrongNumber;

import java.util.Scanner;

/*
 * An Armstrong number is a 3 digit number for which sum of cube of its digit is equal to the number. 
 * Example of Armstrong number is 153 as 153= 1+ 125+27 which 1^3+5^3+3^3. Another Armstrong number is 371 (371= 27+343+1)
 * This code finds whehter the given input is an armstrong number or not
 */
public class ArmstrongNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Input Number:");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		in.close();
		ArmstrongNumber as = new ArmstrongNumber();
		if(as.isArmstrong(num)){
			System.out.println("The input number is an armstrong number");
		}
		else{
			System.out.println("The input number is not an armstrong number");
		}
		
	}
	boolean isArmstrong(int num){
		int originalNumber = num;
		int result = 0;
		int remainder = 0;
		while(num!=0){
			remainder = num%10;
			result = result + remainder*remainder*remainder;
			num = num/10;
		}
		if(originalNumber == result)
			return true;
		else
			return false;
	}

}
