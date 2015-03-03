package hobby.XMLParsing;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			File xmlFile = new File("sample.xml");
			/*
			 * DocumentBuilderFactory and DocumentFactory are used for XML Parsing using DOM Parser
			 */
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root Node Name::"+doc.getDocumentElement().getNodeName());
			NodeList nl = doc.getElementsByTagName("employee");
			for(int i=0; i<nl.getLength(); i++){
				Node node = nl.item(i);
				System.out.println("Node Name:"+node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) node;
					System.out.println("Employee Id:"+element.getAttribute("id"));
					System.out.println("Employee Name:"+element.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Employee Salary:"+element.getElementsByTagName("salary").item(0).getTextContent());
					System.out.println("Employee Department:"+element.getElementsByTagName("dept").item(0).getTextContent());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
