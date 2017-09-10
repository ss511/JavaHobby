package hobby.linkedList;


public class ReverseListPair {

	public static void main(String[] args) {
		LinkedLists linkedLists = new LinkedLists();
		ListNode node = null;
		node = linkedLists.insertAtEnd(node, 10);
		node = linkedLists.insertAtEnd(node, 120);
		node = linkedLists.insertAtEnd(node, 130);
		node = linkedLists.insertAtEnd(node, 20);
		node = linkedLists.insertAtEnd(node, 30);
		node = linkedLists.insertAtEnd(node, 100);
		node = linkedLists.insertAtEnd(node, 105);
		
		ListNode prev = null;
		ListNode curr = node;
		ListNode temp = node;
		int len = linkedLists.getListSize(node);
		if(len % 2 != 0){
			curr = node.getNext();
			temp = node.getNext();
			prev = node;
			prev.setNext(null);
		}
		while(temp != null){
			temp = temp.getNext().getNext();
			curr.getNext().setNext(prev);
			prev = curr;
			curr = temp;
		}
		node = prev;
		linkedLists.printList(node);
	}

}

