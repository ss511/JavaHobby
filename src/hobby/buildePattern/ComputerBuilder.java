package hobby.buildePattern;

public class ComputerBuilder {
	
	public BuyComputer gamingComputer(){
		BuyComputer buyComputer = new BuyComputer();
		buyComputer.addComputers(new GamingDesktop());
		buyComputer.addComputers(new GamingLaptop());
		return buyComputer;
	}
	
	public BuyComputer nonGamingComputer(){
		BuyComputer buyComputer = new BuyComputer();
		buyComputer.addComputers(new AllinOneDesktop());
		buyComputer.addComputers(new Ultrabook());
		return buyComputer;
	}
}
