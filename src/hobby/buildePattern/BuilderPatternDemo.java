package hobby.buildePattern;

import java.util.List;

//This builder pattern application is designed for purchasing computers
public class BuilderPatternDemo {

	public static void main(String[] args) {
		ComputerBuilder computerBuilder = new ComputerBuilder();
		BuyComputer gamingComputer = computerBuilder.gamingComputer();
		System.out.println("Gaming Computer");
		gamingComputer.showComputers();
		System.out.println(gamingComputer.getTotalCost());
		
		System.out.println();
		System.out.println();
		
		System.out.println("Normal Computer");
		BuyComputer normalComputer = computerBuilder.nonGamingComputer();
		normalComputer.showComputers();
		System.out.println(normalComputer.getTotalCost());
	}

}

class HomeDelivery implements Delivery{

	public String getDeliveryType() {
		// TODO Auto-generated method stub
		return "Home Delivery";
	}
	
}

class StorePickup implements Delivery{

	public String getDeliveryType() {
		// TODO Auto-generated method stub
		return "Store Pickup";
	}
	
}

abstract class Laptop implements Computer{

	public boolean isMobile() {
		return true;
	}
	
	public abstract List<String> getOptionalAccessories();

}

abstract class Desktop implements Computer{

	public boolean isMobile() {
		return false;
	}
	
	public abstract List<String> getRequiredAccessories();
}

