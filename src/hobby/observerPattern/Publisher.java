package hobby.observerPattern;

import java.util.Observable;

public class Publisher extends Observable{
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
}
