package hobby.linkedList;

import java.util.Scanner;

public class ReverseList {

	public static void main(String[] args) {
		ReverseList reverseList = new ReverseList();
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
		linkedLists.printList(node);
		System.out.println("Enter Choice"
				+ "\n1-Iterative Method"
				+ "\n2-Reccursive Method");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		if(choice == 1){
			node = reverseList.reverseIt(node);
		}
		else if(choice == 2){
			node = reverseList.reverseRe(node, null);
		}
		System.out.println("After Reversal");
		linkedLists.printList(node);
		in.close();
	}
	
	ListNode reverseIt(ListNode node){
		ListNode next = node;
		ListNode prev = null;
		ListNode current = node;
		while(next != null){
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}
	
	ListNode reverseRe(ListNode node, ListNode prev){
		ListNode head = null;
		if(node.getNext() == null){
			head = node;
			node.setNext(prev);
			return head;
		}
		ListNode next = node.getNext();
		node.setNext(prev);
		head = reverseRe(next, node);
		return head;
	}

}
