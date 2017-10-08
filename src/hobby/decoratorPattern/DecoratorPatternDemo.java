package hobby.decoratorPattern;

import java.util.Scanner;

public class DecoratorPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Basic Ticket Price");
		Movie movie= new BasicTicket();
		System.out.println(movie.getPrice());
		System.out.println("3D Movie");
		movie = new Movie3D(new BasicTicket());
		System.out.println(movie.getPrice());
		System.out.println("Movie in upper class seating");
		movie = new MovieUpperClassSeat(new BasicTicket());
		System.out.println(movie.getPrice());
		System.out.println("3D Movie in upper class seating");
		movie = new MovieUpperClassSeat(new Movie3D(new BasicTicket()));
		System.out.println(movie.getPrice());
		System.out.println("Movie in upper class seating with snacks");
		movie = new MovieUpperClassSeat(new MovieWithSnacks(new BasicTicket()));
		System.out.println(movie.getPrice());
		System.out.println("3D Movie in upper class seating with snacks");
		movie = new MovieUpperClassSeat(new Movie3D(new MovieWithSnacks(new BasicTicket())));
		System.out.println(movie.getPrice());
		Scanner in  = new Scanner(System.in);
		System.out.println("Number of tickets required");
		int num = in.nextInt();
		System.out.println("3D movie with upper class seating for " + num + "people");
		movie= new TicketNumber(new MovieUpperClassSeat(new Movie3D(new BasicTicket())), num);
		System.out.println(movie.getPrice());
		System.out.println("3D movie with upper class seating for " + num + "people with snacks");
		movie= new TicketNumber(new MovieUpperClassSeat(new Movie3D(new MovieWithSnacks(new BasicTicket()))), num);
		System.out.println(movie.getPrice());
		in.close();
	}

}
