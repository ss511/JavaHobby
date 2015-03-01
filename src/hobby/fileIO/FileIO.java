package hobby.fileIO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileIO fileIO = new FileIO();
		fileIO.fileReaderWriterDemo();
		fileIO.fileDemo();

	}
	/*
	 * FileReader and FileWriter Example
	 * Use BufferedWriter and BufferedReader to Write and Read respectively
	 */
	void fileReaderWriterDemo() throws IOException{
		FileWriter fileWriter = new FileWriter("file1.txt");
		BufferedWriter out = new BufferedWriter(fileWriter);
		out.write("File Reader Writer Demo Sample");
		out.append("\nThis is the second line");
		out.close();
		fileWriter.close();
		fileWriter = new FileWriter("file1.txt", true);
		out = new BufferedWriter(fileWriter);
		out.write("Second Time - File Reader Writer Demo Sample");
		out.append("\nThis is the second line");
		out.close();
		fileWriter.close();
		String inputRead; 
		FileReader fileReader = new FileReader("file1.txt");
		BufferedReader in = new BufferedReader(fileReader);
		while((inputRead=in.readLine()) != null)
			System.out.println("Content-"+inputRead);
		in.close();
		fileReader.close();
	}
	/*
	 * File Example
	 * Use Various File Properties
	 */
	void fileDemo() throws IOException{
		String fileName = "file2.txt";
		String workingDirectory = System.getProperty("user.dir");
		String absolutePath = workingDirectory+File.separator+fileName;
		File file = new File(absolutePath);
		if(file.createNewFile())
			System.out.println("File Creation Success");
		else
			System.out.println("File Already Exists");
		String content = "File Demo. Coverting String to Bytes";
		byte[] contentByte = content.getBytes();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(contentByte);
		fos.close();
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		while(dis.available()!=0){
			System.out.println(dis.readLine());
		}
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName()+" "+file.getParent()+" "+file.lastModified()+" "+file.getFreeSpace());
		
		fis.close();
	}
}
