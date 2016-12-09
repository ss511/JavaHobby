package hobby.linkedList;

import java.util.Scanner;

public class LinkedListImpl {

	public static void main(String[] args) {
		LinkedLists linkedLists = new LinkedLists();
		ListNode head = null;
		int choice;
		int data = 0;
		do{
			System.out.println("Enter Choice:"
					+ "\n1-Insert At Start"
					+ "\n2-Insert At End"
					+ "\n3-Insert At Pos"
					+ "\n4-Search"
					+ "\n5-Print"
					+ "\n6-Delete"
					+ "\n7-Get List Size:"
					+ "\n8-Exit");
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			switch(choice){
				case 1: 
					System.out.println("Enter Data: ");
					data = in.nextInt();
					head = linkedLists.insertAtStart(head, data);
					break;
				case 2:
					System.out.println("Enter Data: ");
					data = in.nextInt();
					head = linkedLists.insertAtEnd(head, data);
					break;
				case 3:
					System.out.println("Enter Data: ");
					data = in.nextInt();
					System.out.println("Enter position: ");
					int pos = in.nextInt();
					head = linkedLists.insertAtPos(head, data, pos);
					break;
				case 4:
					System.out.println("Enter data to be searched:");
					int searchData = in.nextInt();
					linkedLists.search(head, searchData);
					break;
				case 5:
					linkedLists.printList(head);
					break;
				case 6:
					System.out.println("Enter data to remove:");
					data = in.nextInt();
					head = linkedLists.deleteData(head, data);
					System.out.println(data+" is deleted.. The new list is::");
					linkedLists.printList(head);
					break;
				case 7:
					int size = linkedLists.getListSize(head);
					System.out.println("List size is::"+size);
					break;
				case 8:
					break;
				default:
					System.out.println("Please Enter Correct Choice:::");
					break;
					
			}
		}while(choice != 8);

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