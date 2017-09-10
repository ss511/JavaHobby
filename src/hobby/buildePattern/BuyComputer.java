package hobby.buildePattern;

import java.util.ArrayList;
import java.util.List;

public class BuyComputer {

	private List<Computer> computers = new ArrayList<Computer>();
	
	public void addComputers(Computer computer) {
		computers.add(computer);
	}
	
	public int getTotalCost() {
		int cost = 0;
		for(Computer computer : computers) {
			cost += computer.getPrice();
		}
		return cost;
	}
	
	public void showComputers() {
		for(Computer computer: computers) {
			System.out.println("Type: " + computer.getType());
			System.out.println("Price: " + computer.getPrice());
			System.out.println("Delivery: " + computer.getDelivery().getDeliveryType());
		}
	}
}
