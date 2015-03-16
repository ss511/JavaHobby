package hobby.next_greater_number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/*
 * This program finds the next greater number from the combination of digits of the given number
 * For example - For 23145 Next Greater Number is 23154 then 23514 then 23541 and so on
 * 
 * For solving this problem start sorting in descending order one step at a time.
 */
class NextGreaterNumber{

	public static void main(String[] args) {
		NextGreaterNumber ngn = new NextGreaterNumber();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number:");
		int num = in.nextInt();
		ngn.findNextGreaterNumber(num);
		in.close();
	}
	
	private void findNextGreaterNumber(int num){
		int nextNumber = 0;
		int originalNumber = num;
		List<Integer> currentDigit = new ArrayList<Integer>();
		List<Integer> currentDigit2 = new ArrayList<Integer>();
		int temp;
		//Extract digits from the number in reverse order and put it in array list and then reverse the array list
		while(num!=0){
			currentDigit.add(new Integer(num%10));
			num = num/10;
		}
		Collections.reverse(currentDigit);
		currentDigit2.addAll(currentDigit);
		//Comparator for sorting in reverse order
		Comparator<Integer> cmp = Collections.reverseOrder();
		int length = currentDigit.size();
		Collections.sort (currentDigit2, cmp);
		//If the array list is already sorted then return
		if(currentDigit.equals(currentDigit2)){
			System.out.println(originalNumber+" is the greatest number");
			return;
		}
		for(int i=length-1; i>0; i--){
			//Check if (i)th value is greater than (i-1)th value. If true then swap and break from the loop
			if(currentDigit.get(i)>currentDigit.get(i-1)){
				temp = currentDigit.get(i);
				currentDigit.set(i, currentDigit.get(i-1));
				currentDigit.set(i-1, temp);
				break;
			}
		}
		//Generate the next greater number from the array list
		for(int i=0; i<length; i++){
			nextNumber = nextNumber*10+currentDigit.get(i);
		}
		System.out.println(nextNumber+" is the next greater number");
		findNextGreaterNumber(nextNumber);
	}
}
