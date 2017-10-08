package hobby.decoratorPattern;

public class MovieUpperClassSeat extends MovieTicketDecorator{

	public MovieUpperClassSeat(Movie movie) {
		super(movie);
	}
	
	@Override
	public int getPrice() {
		return super.getPrice() + 100;
	}
}
