package hobby.linkedList;

import java.util.Scanner;

public class DoublyLinkedListImpl {

	public static void main(String[] args) {
		ListImpl listImpl = null;
		DoublyLinkedListImpl doublyLinkedListImpl = new DoublyLinkedListImpl();
		int choice;
		do{
			System.out.println("Enter choice::\n1-Insert Data\n2-Insert At Start\n3-Insert At Middle\n4-Search Data\n5-Remove Data\n6-Print Data\n7-Get List Size\n9-Exit");
			Scanner in = new Scanner(System.in);
			Scanner in1 = new Scanner(System.in);
			choice = in.nextInt();
			switch(choice){
			case 1: System.out.println("Enter data at end::");
					String data = in1.nextLine();
					listImpl = doublyLinkedListImpl.insertData(data, listImpl);
					break;
			case 2: System.out.println("Enter data at start::");
					data = in1.nextLine();
					listImpl = doublyLinkedListImpl.insertDataAtStart(data, listImpl);
					break;
			
			case 3: System.out.println("Enter position::");
					int pos = in.nextInt();
					System.out.println("Enter data at a position::");
					data = in1.nextLine();
					listImpl = doublyLinkedListImpl.insertDataAtPos(data, pos, listImpl);
					break;
			
			case 4: System.out.println("Enter data to search::");
					data = in1.nextLine();
					doublyLinkedListImpl.searchData(data, listImpl);
					break;
					
			case 5: System.out.println("Enter data to remove::");
					data = in1.nextLine();
					listImpl = doublyLinkedListImpl.removeData(data, listImpl);	
					break;
			
			case 6: doublyLinkedListImpl.printData(listImpl);
					break;
			case 7: System.out.println("Size of the list is::"+doublyLinkedListImpl.getSize(listImpl));
			case 9: break;
			default: System.out.println("Please Enter correct choice");
					 break;
			}
		}while(choice != 9);
	}
	
	ListImpl insertData(String data, ListImpl head){
		if(head == null){
			head = new ListImpl();
			head.setData(data);
			head.setNext(null);
			head.setPrev(null);
		}
		else{
			ListImpl node = head;
			while(node.getNext()!=null)
				node=node.getNext();
			ListImpl temp = new ListImpl();
			temp.setData(data);
			temp.setNext(null);
			temp.setPrev(node);
			node.setNext(temp);
		}
		return head;
	}
	
	ListImpl insertDataAtStart(String data, ListImpl head){
		if(head == null){
			head = new ListImpl();
			head.setData(data);
			head.setNext(null);
			head.setPrev(null);
		}
		else{
			ListImpl node = head;
			ListImpl temp = new ListImpl();
			temp.setData(data);
			temp.setPrev(null);
			temp.setNext(node);
			node.setPrev(temp);
			head = temp;
		}
		return head;
	}
	
	ListImpl insertDataAtPos(String data, int pos, ListImpl head){
		int i = 1;
		if(pos==1){
			head = insertDataAtStart(data, head);
			return head;
		}
		else{
			if(head == null){
				head = new ListImpl();
				head.setData(data);
				head.setNext(null);
				head.setPrev(null);
			}
			else{
				ListImpl node = head;
				while(node.getNext()!=null){
					if(i==pos)
						break;
					node = node.getNext();
					i++;
				}
				if(pos>i){
					head = insertData(data, head);
					return head;
				}
				ListImpl temp = new ListImpl();
				ListImpl prev = node.getPrev();
				temp.setData(data);
				prev.setNext(temp);
				temp.setPrev(prev);
				temp.setNext(node);
			}
			return head;
		}
	}
	
	void searchData(String data, ListImpl head){
		ListImpl node = head;
		int pos = 1;
		while(node.getNext() != null){
			if(node.getData().equalsIgnoreCase(data)){
				System.out.println(data+" found at pos--"+pos);
			}
			node=node.getNext();
			pos++;
		}
	}
	
	ListImpl removeData(String data, ListImpl head){
		ListImpl node = head;
		boolean flag = false;
		if(getSize(node) == 1){
			head = null;
			return head;
		}
		while(node!=null){
			if(node.getData().equalsIgnoreCase(data)){
				ListImpl temp = node;
				ListImpl prev = node.getPrev();
				if(prev!=null)
					prev.setNext(temp.getNext());
				else{
					head = temp.getNext();
					head.setPrev(null);
				}
				if(node.getNext()!=null && prev!=null)
					node.getNext().setPrev(prev);
				temp = null;
				System.out.println("Data deleted... The new List is:::");
				printData(head);
				flag = true;
				break;
			}
			node=node.getNext();
		}
		if(flag == false){
			System.out.println("Data not present in the list!!!");
		}
		return head;
	}
	
	void printData(ListImpl head){
		while(head!=null){
			System.out.println(head.getData());
			head = head.getNext();
		}
	}
	
	int getSize(ListImpl head){
		int i = 0;
		ListImpl node = head;
		while(node!=null){
			i++;
			node=node.getNext();
		}
		return i;
	}

}

class ListImpl{
	private String data;
	private ListImpl next;
	private ListImpl prev;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ListImpl getNext() {
		return next;
	}
	public void setNext(ListImpl next) {
		this.next = next;
	}
	public ListImpl getPrev() {
		return prev;
	}
	public void setPrev(ListImpl prev) {
		this.prev = prev;
	}
	
}
