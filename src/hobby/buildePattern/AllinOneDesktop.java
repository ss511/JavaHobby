package hobby.buildePattern;

import java.util.ArrayList;
import java.util.List;

public class AllinOneDesktop extends Desktop{
	public String getType() {
		
		return "All in one Desktop";
	}

	public int getPrice() {
		
		return 68000;
	}

	public Delivery getDelivery() {
		
		return new HomeDelivery();
	}

	public boolean isGraphicsCardPresent() {
		
		return false;
	}

	@Override
	public List<String> getRequiredAccessories() {
		List<String> accessories = new ArrayList<String>();
		accessories.add("UPS");
		return accessories;
	}
}
