package hobby.decoratorPattern;

public class MovieTicketDecorator implements Movie{

	Movie movie;
	
	public MovieTicketDecorator(Movie movie) {
		this.movie = movie;
	}
	public int getPrice() {
		return movie.getPrice();
	}
	
}
