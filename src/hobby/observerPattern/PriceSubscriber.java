package hobby.observerPattern;

import java.util.Observable;
import java.util.Observer;

public class PriceSubscriber implements Observer{

	private double price;
	
	public void update(Observable o, Object arg) {
		if(arg instanceof Double){
			price = ((Double)arg).doubleValue();
			System.out.println("PriceSubscriber:: Price changed to:::"+price);
		}
		else{
			System.out.println("PriceSubscriber:: Some other change happened");
		}
		
	}
	
}
