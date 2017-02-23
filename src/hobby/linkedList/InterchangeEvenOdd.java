package hobby.linkedList;

/*
 * Rearranges list such that all odd nodes comes first and all even nodes last 
 * 
 */

public class InterchangeEvenOdd {

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
		InterchangeEvenOdd interchangeEvenOdd = new InterchangeEvenOdd();
		node = interchangeEvenOdd.interchange(node);
		System.out.println("After interchanging even and odd nodes:::");
		linkedLists.printList(node);
	}

	ListNode interchange(ListNode head){
		if(head == null){
			return head;
		}
		if(head.getNext() == null){
			return head;
		}

		ListNode odd = head;
		ListNode even = head.getNext();
		ListNode firstEven = even;
		while(true){

			odd.setNext(even.getNext());
			odd = even.getNext();
			
			if(odd.getNext() == null){
				even.setNext(null);
				odd.setNext(firstEven);
				break;
			}

			even.setNext(odd.getNext());
			even = odd.getNext();

			if(odd == null || even == null || even.getNext() == null){
				odd.setNext(firstEven);
				break;
			}
		}
		return head;
	}
}
