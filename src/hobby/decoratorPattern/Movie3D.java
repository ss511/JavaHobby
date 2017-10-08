package hobby.decoratorPattern;

public class Movie3D extends MovieTicketDecorator{

	public Movie3D(Movie movie) {
		super(movie);
	}
	
	@Override
	public int getPrice() {
		return super.getPrice()+30;
	}
}
