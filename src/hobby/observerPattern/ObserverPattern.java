package hobby.observerPattern;

public class ObserverPattern {

	public static void main(String[] args) {
		
		Publisher p = new Publisher();
		p.setName("Apple");
		p.setCost(2.99);
		System.out.println("Name::"+p.getName());
		System.out.println("Cost::"+p.getCost());
		NameSubscriber ns = new NameSubscriber();
		PriceSubscriber ps = new PriceSubscriber();
		
		p.addObserver(ns);
		p.addObserver(ps);
		
		p.setName("Grape");
		p.setCost(1.99);
		System.out.println("Name::"+p.getName());
		System.out.println("Cost::"+p.getCost());
	}

}
