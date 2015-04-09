package hobby.directionOfPoint;

import java.util.Scanner;

/*
 * This program finds the direction in which a point lies with respect to the line segment.
 * To find this we move point A of line to origin and rest of the points with respect to that.
 * If cross product of point B of line and point P is positive it lies	left to that line,
 * if it is negative it lies to the right and if it is 0 it lies on the line.
 * 
 */
public class PointDirection {
	public static void main(String[] args){
		PointDirection pd = new PointDirection();
		Point aOfLine = new Point();
		Point bOfLine = new Point();
		Point point = new Point();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Point A of Line:");
		aOfLine.setA(in.nextDouble());
		aOfLine.setB(in.nextDouble());
		System.out.println("Enter Point B of Line:");
		bOfLine.setA(in.nextDouble());
		bOfLine.setB(in.nextDouble());
		System.out.println("Enter Point:");
		point.setA(in.nextDouble());
		point.setB(in.nextDouble());
		
		bOfLine = pd.subtract(bOfLine, aOfLine);
		point = pd.subtract(point, aOfLine);
		in.close();
		pd.getDirection(bOfLine, point);
		
	}
	Point subtract(Point a, Point b){
		Point newPoint = new Point();
		newPoint.setA(a.getA()-b.getA());
		newPoint.setB(a.getB()-b.getB());
		return newPoint;
	}
	void getDirection(Point x, Point y){
		double crossProduct = x.getA()*y.getB() - y.getA()*x.getB();
		System.out.println("Cross Product Is::"+crossProduct);
		
		if(crossProduct<0){
			System.out.println("Point Lies On Right Side");
		}
		else if(crossProduct>0){
			System.out.println("Point Lies On Left Side");
		}
		else{
			System.out.println("Point Lies On Line");
		}
		
	}
}
class Point{
	private double a;
	private double b;
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	
}
