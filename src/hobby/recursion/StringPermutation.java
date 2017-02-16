package hobby.recursion;

public class StringPermutation {

	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		String str = "boat";
		char[] ch = str.toCharArray();
		int length = ch.length;
		sp.perm(ch, 0, length);
	}

	private void perm(char[] ch, int k, int n){
		if(k == n-1){
			printPerm(ch);
			return;
		}
		else{
			char temp;
			for(int i = k; i < n; i++){
				temp = ch[k];
				ch[k] = ch[i];
				ch[i] = temp;
				perm(ch, k+1, n);
				temp = ch[k];
				ch[k] = ch[i];
				ch[i] = temp;
			}
		}
	}
	
	private void printPerm(char[] ch){
		String newStr = new String(ch);
		System.out.println(newStr);
	}
}
