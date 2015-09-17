package hobby.serialization;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;

public class SerializationDemo {

	public static void main(String[] args) {
		Employee e = new Employee();
		e.setId(20);
		e.setName("Ram");
		e.setPass("123");
		try{
			URL url = SerializationDemo.class.getClassLoader().getResource("resourceFile/employee.ser");
			FileOutputStream fileOut = new FileOutputStream(url.getFile());
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
			System.out.println("Serialized data saved");
		}catch(IOException ioe){
			System.out.println(ioe);
		}
		
		try{
			URL url = SerializationDemo.class.getClassLoader().getResource("resourceFile/employee.ser");
			FileInputStream fileIn = new FileInputStream(url.getFile());
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Employee emp = (Employee) in.readObject();
			System.out.println(emp.getId()+ " "+ emp.getName()+ " and "+emp.getPass() +" or " +e.getPass());
			in.close();
		}catch(Exception ioe){
			System.out.println(ioe);
		}

	}

}

//A class for serialization
class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1471214876412114267L;
	private int id;
	private String name;
	private transient String pass;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
