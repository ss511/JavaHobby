package hobby.buildePattern;

import java.util.ArrayList;
import java.util.List;

public class GamingDesktop extends Desktop{

	public String getType() {
		
		return "Gaming Desktop";
	}

	public int getPrice() {
		
		return 80000;
	}

	public Delivery getDelivery() {
		
		return new StorePickup();
	}

	public boolean isGraphicsCardPresent() {
		
		return true;
	}

	@Override
	public List<String> getRequiredAccessories() {
		List<String> accessories = new ArrayList<String>();
		accessories.add("Keyboard");
		accessories.add("Monitor");
		accessories.add("Mouse");
		accessories.add("Speakers");
		accessories.add("UPS");
		return accessories;
	}
}
