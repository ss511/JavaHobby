package hobby.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.URL;

public class ExternalizationDemo {

	public static void main(String[] args) {
		Employees e = new Employees();
		Employees emp = new Employees();
		e.setId(100);
		e.setName("Hari");
		e.setPass("abc");
		try{
			URL url = ExternalizationDemo.class.getClassLoader().getResource("resourceFile/employees.ser");
			FileOutputStream fileOut = new FileOutputStream(url.getFile());
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(e);
			out.close();
		}
		catch(Exception ee){
			System.out.println(ee);
		}
		
		try{
			URL url = ExternalizationDemo.class.getClassLoader().getResource("resourceFile/employees.ser");
			FileInputStream fileIn =  new FileInputStream(url.getFile());
			ObjectInputStream in = new ObjectInputStream(fileIn);
			emp = (Employees) in.readObject();
			in.close();
		}catch(Exception ee){
			System.out.println(ee);
		}
		System.out.println(emp.getId()+ " "+ emp.getName()+" "+emp.getPass());
	}

}

/*
 * A class for externalizable. Note it overrides two methods from Externalizable and uses one base constructor to call super().
 * It Depends on those two methods to serialize the desired properties, since the main class simply invokes ObjectOutputStream writeObject with Employees object as parameter
 * 
 */

class Employees implements Externalizable{
	int id;
	String name;
	String pass;
	public Employees(){super();}
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
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		setId(in.readInt());
		setName((String)in.readObject());
		
	}
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(getId());
		out.writeObject(getName());
	}
}
