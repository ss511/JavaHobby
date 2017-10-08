package hobby.decoratorPattern;

public class TicketNumber extends MovieTicketDecorator{

	int num;
	public TicketNumber(Movie movie, int num) {
		super(movie);
		this.num = num;
	}
	
	@Override
	public int getPrice() {
		return num*super.getPrice();
	}
	
}
