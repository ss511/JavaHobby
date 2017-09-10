package hobby.replaceChars;

public class ReplaceChars {

	public static void main(String[] args) {
		char[] ch = new char[30];
		ch[0] = 'a';
		ch[1] = 'b';
		ch[2] = 'c';
		ch[3] = 'd';
		ch[4] = 'a';
		ch[5] = 'e';
		ch[6] = 'a';
		ch[7] = 'f';
		System.out.println(ch.length);
		int count = 0;
		System.out.println("Before Replacement::");
		for(char c : ch) {
			if(c == '\0')
				break;
			System.out.print(c + " " );
			count++;
		}
		System.out.println();
		int initialSize = count;
		int i = 0;
		while(i < initialSize) {
			if(ch[i] == 'a') {
				ch[count] = '%';
				ch[++count] = '2';
				ch[++count] = '0';
				count++;
				ch[i] = '\0';
				i++;
			}
			else {
				ch[count] = ch[i];
				count++;
				ch[i] = '\0';
				i++;
			}
		}
		count = initialSize;
		i = 0;
		while(ch[count] != '\0') {
			ch[i] = ch[count];
			ch[count] = '\0';
			count++;
			i++;
		}
		System.out.println("After Replacement::");
		for(char c : ch) {
			if(c == '\0')
				break;
			System.out.print(c + " ");
		}
	}

}
