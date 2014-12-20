package hobby.char_occurence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CharOccurrences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CharOccurrences co = new CharOccurrences();
		String str;
		Map ocMap;
		Scanner in = new Scanner(System.in);
		System.out.println("Your String::");
		str = in.nextLine();
		ocMap = co.getOccurrences(str);
		in.close();
		Set keys = ocMap.keySet();
		Iterator it = keys.iterator();
		while(it.hasNext()){
			Character key = (Character) it.next();
			System.out.println("Character:"+key+" Occuerences:+"+ocMap.get(key));
		}
	}
	Map getOccurrences(String str){
		Map ocMap = new HashMap();
		int length = str.length();
		int oc;
		for(int i = 0; i<length; i++){
			Character ch = new Character(str.charAt(i));
			if(ocMap.containsKey(ch)){
				oc = Integer.parseInt(ocMap.get(ch).toString());
				oc++;
				ocMap.replace(ch, new Integer(oc));
			}
			else{
				ocMap.put(ch, new Integer(1));
			}
		}
		return ocMap;
	}

}
