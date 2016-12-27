package hobby.stacks;

public class StringReverse {

	public static void main(String[] args) {
		StackImpl<Character> stackImpl = new StackImpl<Character>();
		StackClass<Character> stack = new StackClass<Character>();
		String str = "Hello World";
		char[] ch = str.toCharArray();
		int length = ch.length;
		for(int i = 0; i < length; i++){
			stack = stackImpl.push(stack, ch[i]);
		}
		for(int i = 0; i < length; i++){
			ch[i] = stackImpl.peek(stack);
			stack = stackImpl.pop(stack);
		}
		System.out.println("Reverse String is::: "+new String(ch));
		
	}

}
