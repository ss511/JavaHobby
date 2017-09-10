package hobby.linkedList;

public class SwapNodes {

	public static void main(String[] args) {
		LinkedLists linkedLists = new LinkedLists();
		ListNode node = null;
		node = linkedLists.insertAtEnd(node, 10);
		node = linkedLists.insertAtEnd(node, 120);
		node = linkedLists.insertAtEnd(node, 130);
		node = linkedLists.insertAtEnd(node, 5);
		node = linkedLists.insertAtEnd(node, 20);
		node = linkedLists.insertAtEnd(node, 30);
		node = linkedLists.insertAtEnd(node, 100);
		node = linkedLists.insertAtEnd(node, 40);
		System.out.println("Linked List before swapping:::");
		linkedLists.printList(node);
		SwapNodes swapNodes = new SwapNodes();
		node = swapNodes.swap(node, 2, 5);
		System.out.println("Linked List after swapping:::");
		linkedLists.printList(node);
	}
	ListNode swap(ListNode node, int pos1, int pos2){
		ListNode prevX = node;
		ListNode prevY = node;
		ListNode currX = null;
		ListNode currY = null;
		
		for(int i = 0; i < pos1-1; i++){
			prevX = prevX.getNext();
		}
		currX = prevX.getNext();
		for(int i = 0; i < pos2-1; i++){
			prevY = prevY.getNext();
		}
		currY = prevY.getNext();
		prevX.setNext(currY);
		prevY.setNext(currX);
		ListNode temp = currX.getNext();
		currX.setNext(currY.getNext());
		currY.setNext(temp);
		return node;
	}
}
