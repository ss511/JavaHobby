package hobby.observerPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Publisher extends Observable{
	private List<Observer> users = new ArrayList<Observer>();
	private String name;
	private double cost;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		setChanged();
		notifyObservers(name);
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double d) {
		this.cost = d;
		setChanged();
		notifyObservers(new Double(d));
	}
	
	@Override
	public void addObserver(Observer o) {
		users.add(o);
	}
	
	@Override
	public void deleteObserver(Observer o) {
		users.remove(o);
	}
	
}
