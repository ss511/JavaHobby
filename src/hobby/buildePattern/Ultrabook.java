package hobby.buildePattern;

import java.util.ArrayList;
import java.util.List;

public class Ultrabook extends Laptop{

	public String getType() {
		
		return "Ultrabook";
	}

	public int getPrice() {
		
		return 70000;
	}

	public Delivery getDelivery() {
		
		return new StorePickup();
	}

	public boolean isGraphicsCardPresent() {
		
		return false;
	}

	@Override
	public List<String> getOptionalAccessories() {
		
		List<String> accessories = new ArrayList<String>();
		accessories.add("External HDD");
		accessories.add("Bluetooth Headset");
		accessories.add("USB Dongle");
		accessories.add("External Dock");
		return accessories;
	}

}
