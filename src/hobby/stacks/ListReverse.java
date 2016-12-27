package hobby.stacks;

public class ListReverse {

	public static void main(String[] args) {
		LinkedLists linkedLists = new LinkedLists();
		ListNode node = null;
		node = linkedLists.insertAtEnd(node, 10);
		node = linkedLists.insertAtEnd(node, 120);
		node = linkedLists.insertAtEnd(node, 130);
		node = linkedLists.insertAtEnd(node, 10);
		node = linkedLists.insertAtEnd(node, 20);
		node = linkedLists.insertAtEnd(node, 30);
		node = linkedLists.insertAtEnd(node, 100);
		node = linkedLists.insertAtEnd(node, 40);
		
		StackImpl<ListNode> stackImpl = new StackImpl<ListNode>();
		StackClass<ListNode> stack = stackImpl.createStack();
		
		ListNode temp = node;
		while(temp!=null){
			stack = stackImpl.push(stack, temp);
			temp = temp.getNext();
		}
		
		ListNode reverseTemp = stackImpl.peek(stack);
		node = reverseTemp;
		stack = stackImpl.pop(stack);
		while(!stackImpl.isEmpty(stack)){
			reverseTemp.setNext(stackImpl.peek(stack));
			stack = stackImpl.pop(stack);
			reverseTemp = reverseTemp.getNext();
		}
		linkedLists.printList(node);
	}

}

class LinkedLists{
	public ListNode insertAtStart(ListNode head, int data){
		ListNode newNode = new ListNode();
		newNode.setData(data);
		if(head == null){
			newNode.setNext(null);
			head = newNode;
		}
		else{
			ListNode temp = head;
			newNode.setNext(temp);
			head = newNode;
		}
		
		return head;
	}
	
	public ListNode insertAtEnd(ListNode head, int data){
		ListNode newNode = new ListNode();
		newNode.setData(data);
		newNode.setNext(null);
		if(head == null){
			head = newNode;
		}
		else{
			ListNode temp = head;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		
		return head;
	}
	
	public ListNode insertAtPos(ListNode head, int data, int pos){
		ListNode newNode = new ListNode();
		newNode.setData(data);
		if(head == null){
			newNode.setNext(null);
			head = newNode;
		}
		else{
			ListNode temp = head;
			int i = 0;
			while(temp.getNext()!=null){
				if(i == pos)
					break;
				temp = temp.getNext();
				i++;
			}
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		return head;
	}
	
	public void search(ListNode head, int data){
		ListNode temp = head;
		while(temp!=null){
			if(temp.getData() == data){
				System.out.println("Element present in the linked list");
				return;
			}
			temp = temp.getNext();
		}
		System.out.println("Element not present in the linked list");
	}
	
	public void printList(ListNode head){
		ListNode temp = head;
		if(temp == null){
			System.out.println("List is empty");
			return;
		}
		while(temp != null){
			System.out.print(temp.getData()+" ");
			temp = temp.getNext();
		}
		System.out.println();
	}
	
	public ListNode deleteData(ListNode head, int data){
		if(head == null){
			System.out.println("List is empty");
			return head;
		}
		ListNode temp = head;
		if(head.getData() == data){
			head = temp.getNext();
			return head;
		}
		while(temp.getNext() != null){
			if(temp.getNext().getData() == data){
				temp.setNext(temp.getNext().getNext());
				return head;
			}
			temp = temp.getNext();
		}
		System.out.println("Element not present in the linked list");
		return head;
	}
	
	public int getListSize(ListNode head){
		int i = 0;
		while(head != null){
			i++;
			head = head.getNext();
		}
		return i;
	}
}

class ListNode{
	int data;
	ListNode next;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	
}
