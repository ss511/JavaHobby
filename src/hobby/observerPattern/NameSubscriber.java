package hobby.observerPattern;

import java.util.Observable;
import java.util.Observer;

public class NameSubscriber implements Observer{

	private String name;
	
	public void update(Observable o, Object arg) {
		if(arg instanceof String){
			name = (String)arg;
			System.out.println("NameSubscriber:: Name changed to::"+name);
		}
		else{
			System.out.println("NameSubscriber:: Some other change happened");
		}
		
	}

}
