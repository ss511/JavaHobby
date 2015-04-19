package hobby.decimalToBinary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		int num, remainder;
		List<Integer> binaryList= new ArrayList<Integer>();
		System.out.println("Enter Number-");
		Scanner in= new Scanner(System.in);
		num = in.nextInt();
		in.close();
		while(num>0){
			remainder = num%2;
			num=num/2;
			binaryList.add(remainder);
		}
		Collections.reverse(binaryList);
		System.out.println("Number in binary form:");
		Iterator<Integer> it = binaryList.listIterator();
		while(it.hasNext()){
			System.out.print(it.next());
		}
	}

}
