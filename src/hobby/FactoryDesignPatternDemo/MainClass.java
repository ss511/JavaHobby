package hobby.FactoryDesignPatternDemo;

import java.util.Scanner;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Choose 1 for Circle and 2 for Triangle");
		int choice=0;
		Scanner in = new Scanner(System.in);
		do{
		choice = in.nextInt();
		if(choice!=1 && choice!=2)
			System.out.println("Wrong Choice. Please Enter Again");
		}while(choice!=1 && choice!=2);
		Shape shape = ShapeFactory.createShape(choice);
		shape.draw();
		in.close();
	}

}
