package hobby.linkedList;

/*
 * Segregated Even and Odd Numbers in a list
 * 
 */
public class SegregateEvenOdd {

	public static void main(String[] args) {
		LinkedLists linkedLists = new LinkedLists();
		ListNode node = null;
		node = linkedLists.insertAtEnd(node, 21);
		node = linkedLists.insertAtEnd(node, 2);
		node = linkedLists.insertAtEnd(node, 22);
		node = linkedLists.insertAtEnd(node, 1);
		node = linkedLists.insertAtEnd(node, 16);
		node = linkedLists.insertAtEnd(node, 5);
		node = linkedLists.insertAtEnd(node, 6);
		node = linkedLists.insertAtEnd(node, 30);
		node = linkedLists.insertAtEnd(node, 300);
		node = linkedLists.insertAtEnd(node, 130);
		node = linkedLists.insertAtEnd(node, 11);
		node = linkedLists.insertAtEnd(node, 9);
		node = linkedLists.insertAtEnd(node, 114);
		System.out.println("Initial List:::");
		linkedLists.printList(node);
		SegregateEvenOdd segregateEvenOdd = new SegregateEvenOdd();
		node = segregateEvenOdd.segregate(node);
		System.out.println("List after Segregation");
		linkedLists.printList(node);
	}

	ListNode segregate(ListNode node){
		ListNode temp1 = node;
		while(temp1.getNext() != null){
			temp1 = temp1.getNext();
		}
		ListNode end = temp1;
		ListNode current = node;
		ListNode prev = null;
		while(current != end){
			if((current.getData())%2 != 0){
				if(prev == null){
					node = current.getNext();
					prev = node;
				}
				else{
					prev.setNext(current.getNext());
				}
				current.setNext(null);
				temp1.setNext(current);
				temp1 = current;
				current = prev.getNext();
			}
			else{
				prev = current;
				current = current.getNext();
			}
		}
		return node;
	}
}
