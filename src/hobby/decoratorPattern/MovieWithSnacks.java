package hobby.decoratorPattern;

public class MovieWithSnacks extends MovieTicketDecorator{

	public MovieWithSnacks(Movie movie) {
		super(movie);
	}
	
	@Override
	public int getPrice() {
		return super.getPrice() + 100;
	}
}
