package hobby.linkedList;

public class LinkedListsLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		//Create a loop for testing
		ListNode temp = node;
		while(temp.getNext()!=null){
			temp = temp.getNext();
			
		}
		temp.setNext(node.getNext().getNext().getNext());
		
		LinkedListsLoop linkedListsLoop = new LinkedListsLoop();
		node = linkedListsLoop.detectAndRemoveLoop(node);
		linkedLists.printList(node);
	}

	ListNode detectAndRemoveLoop(ListNode node){
		ListNode fast = node.getNext();
		ListNode slow = node;
		boolean loop = false;
		
		while(fast.getNext()!=null){
			fast = fast.getNext();
			if(fast!=null){
				fast = fast.getNext();
				slow = slow.getNext();
			}
			if(fast.getNext() == slow){
				System.out.println("Loop Exists"
						+ "\nBreaking the loop"
						+ "\nList after breaking the loop:::");
				loop= true;
				fast.setNext(null);
				break;
			}
		}
		if(loop == false){
			System.out.println("Loop doesn't exist");
		}
		return node;
	}
}
