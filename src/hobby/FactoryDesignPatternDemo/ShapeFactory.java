package hobby.FactoryDesignPatternDemo;

public class ShapeFactory {
	/*
	 * Shape Factory contains static method which returns the Shape object
	 */
	public static Shape createShape(int shape){
		if(shape==1){
			return new Circle();
		}
		else{
			return new Triangle();
		}
	}

}
