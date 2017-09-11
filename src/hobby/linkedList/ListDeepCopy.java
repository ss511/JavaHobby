package hobby.linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListDeepCopy {

	public static void main(String[] args) {
		ListDeepCopy ldc = new ListDeepCopy();
		Scanner in = new Scanner(System.in);
		ArbList head = null;
		System.out.println("Insert 7 Data.");
		int i = 0;
		while (i < 7) {
			int data = in.nextInt();
			head = ldc.insert(head, data);
			i++;
		}
		System.out.println("Print list");
		ldc.printList(head);
		ArbList node = head;
		node.arb = node.next.next;
		node = node.next;
		node.arb = node.next;
		node = node.next;
		node.arb = head;
		node = node.next;
		node.arb = node;
		node = node.next;
		node.arb = head.next;
		node = node.next;
		node.arb = node.next;
		node = node.next;
		node.arb = head;
		ldc.printListInArb(head);
		ArbList newHead = null;
		newHead =  ldc.deepCopy(head, newHead);
		System.out.println("After changing the original list");
		head.next.data = 10000;
		head.next.next.data = 9999;
		ldc.printList(head);
		ldc.printListInArb(head);
		System.out.println("Copied List");
		ldc.printList(newHead);
		ldc.printListInArb(newHead);
		in.close();
	}	
	
	ArbList deepCopy(ArbList head, ArbList newHead) {
		ArbList node = head;
		ArbList newNode = new ArbList(node.data, null, null);
		newHead = newNode;
		ArbList temp = null;
		Map<ArbList, ArbList> map = new HashMap<ArbList, ArbList>();
		map.put(head, newHead);
		while (node.next != null) {
			node = node.next;
			temp = new ArbList(node.data, null, null);
			map.put(node, temp);
			newNode.next = temp;
			newNode = temp;
		}
		node = head;
		newNode = newHead;
		while (node != null) {
			newNode.arb = map.get(node.arb);
			node = node.next;
			newNode = newNode.next;
		}
		return newHead;
	}
	
	ArbList insert(ArbList head, int data) {
		ArbList node = new ArbList(data, head, null);
		head = node;
		return head;
	}
	
	void printList(ArbList head) {
		System.out.println("Printing the list with next pointer");
		ArbList node = head;
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	void printListInArb(ArbList head) {
		System.out.println("Printing the list with arb pointer");
		ArbList node = head;
		while(node!=null) {
			System.out.print(node.arb.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
}

class ArbList{
	int data;
	ArbList next;
	ArbList arb;
	public ArbList(int data, ArbList next, ArbList arb) {
		this.data = data;
		this.next = next;
		this.arb = arb;
	}
}
