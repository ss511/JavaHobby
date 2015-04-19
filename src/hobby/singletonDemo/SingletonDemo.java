package hobby.singletonDemo;

public class SingletonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SingletonClass sc = SingletonClass.getInstance();
		sc.demo();

	}

}

class SingletonClass { 
	private static SingletonClass singleton = null;
	
	public static SingletonClass getInstance(){
		if(singleton == null)
			singleton = new SingletonClass();
		return singleton;
	}
	
	public void demo(){
		System.out.println("Hello Singleton World");
	}
}
