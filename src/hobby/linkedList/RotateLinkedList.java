package hobby.linkedList;

import java.util.Scanner;

public class RotateLinkedList {

	public static void main(String[] args) {
		RotateLinkedList rotateLinkedList = new RotateLinkedList();
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
		System.out.println("Linked List before rotation:::");
		linkedLists.printList(node);
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the rotation index considering first node is at index 0:::");
		int index = in.nextInt();
		node = rotateLinkedList.rotateList(node, index);
		System.out.println("Linked List after rotation:::");
		linkedLists.printList(node);
		in.close();
	}
	
	ListNode rotateList(ListNode node, int index){
		
		ListNode firstNode = node;
		ListNode temp = node;
		ListNode temp1 = node;
		int i = 0;
		while(i<index){
			temp = temp.getNext();
			if(i>0){
				temp1 = temp1.getNext();
			}
			i++;
		}
		node = temp;
		temp1.setNext(null);
		while(temp.getNext()!=null){
			temp = temp.getNext();
		}
		temp.setNext(firstNode);
		return node;
	}
}
