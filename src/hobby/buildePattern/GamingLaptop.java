package hobby.buildePattern;

import java.util.ArrayList;
import java.util.List;

public class GamingLaptop extends Laptop{

	public String getType() {
		return "Gaming Laptop";
	}

	public int getPrice() {
		return 90000;
	}

	public Delivery getDelivery() {
		return new HomeDelivery();
	}

	public boolean isGraphicsCardPresent() {
		return true;
	}

	@Override
	public List<String> getOptionalAccessories() {
		List<String> accessories = new ArrayList<String>();
		accessories.add("Gaming Mouse");
		accessories.add("Gaming Keyboard");
		accessories.add("Stereo Headset");
		return accessories;
	}
}
