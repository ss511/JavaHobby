package hobby.stacks;

public class Stacks {

	public static void main(String[] args) {
		StackImpl<Integer> stackImpl = new StackImpl<Integer>();
		StackClass<Integer> stack = stackImpl.createStack();
		stack = stackImpl.push(stack, 10);
		stack = stackImpl.push(stack, 40);
		stack = stackImpl.push(stack, 15);
		stack = stackImpl.push(stack, 5);
		stack = stackImpl.push(stack, 25);
		stack = stackImpl.push(stack, 125);
		
		System.out.println("Top Element = "+stackImpl.peek(stack));
		stack = stackImpl.pop(stack);
		System.out.println("Top Element = "+stackImpl.peek(stack));
		stack = stackImpl.pop(stack);
		System.out.println("Top Element = "+stackImpl.peek(stack));
		stack = stackImpl.pop(stack);
		System.out.println("Top Element = "+stackImpl.peek(stack));
		stack = stackImpl.pop(stack);
		System.out.println("Top Element = "+stackImpl.peek(stack));
		stack = stackImpl.pop(stack);
		System.out.println("Top Element = "+stackImpl.peek(stack));
		stack = stackImpl.pop(stack);
		System.out.println("Top Element = "+stackImpl.peek(stack));
		stack = stackImpl.pop(stack);
		System.out.println("Top Element = "+stackImpl.peek(stack));
	}

}

class StackImpl<T>{
	public StackClass<T> createStack(){
		StackClass<T> stack = new StackClass<T>();
		return stack;
	}
	
	public StackClass<T> push(StackClass<T> stack, T data){
		StackClass<T> node = new StackClass<T>();
		node.setData(data);
		node.setNext(stack);
		stack = node;
		stack.setData(data);
		return stack;
	}
	
	
	public StackClass<T> pop(StackClass<T> stack){
		if(isEmpty(stack)){
			System.out.println("Stack is empty");
			return stack;
		}
		System.out.println("Top element getting removed is::"+stack.getData());
		StackClass<T> temp = stack;
		stack = stack.getNext();
		temp = null;
		return stack;
	}
	
	public T peek(StackClass<T> stack){
		if(isEmpty(stack)){
			System.out.println("No data present");
			return null;
		}
		return stack.getData();
	}
	
	public boolean isEmpty(StackClass<T> stack){
		return (stack == null);
	}
	
}

class StackClass<T>{
	private T data;
	private StackClass<T> next;
	public StackClass<T> getNext() {
		return next;
	}
	public void setNext(StackClass<T> next) {
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
