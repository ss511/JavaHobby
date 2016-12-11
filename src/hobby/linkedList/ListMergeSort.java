package hobby.linkedList;

public class ListMergeSort {

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
		System.out.println("Linked List before sort:::");
		linkedLists.printList(node);
		ListMergeSort listMergeSort = new ListMergeSort();
		node = listMergeSort.mergeSort(node);
		System.out.println("Linked List after sort:::");
		linkedLists.printList(node);
	}
	
	ListNode mergeSort(ListNode node){
		
		if (node == null || node.getNext() == null){
			return node;
		}
		
		ListNode[] nodes = partition(node);
		nodes[0] = mergeSort(nodes[0]);
		nodes[1] = mergeSort(nodes[1]);
		node = merge(nodes[0], nodes[1]);
		return node;
	}
	
	ListNode[] partition(ListNode node){
		ListNode[] nodes = new ListNode[2];
		if(node == null  || node.getNext() == null){
			nodes[0] = node;
			nodes[1] = null;
		}
		else{
			ListNode fast = node;
			ListNode slow = node;
			while(fast.getNext()!=null){
				fast = fast.getNext();
				if(fast.getNext()!=null){
					fast = fast.getNext();
					slow = slow.getNext();
				}
			}
			nodes[0] = node;
			nodes[1] = slow.getNext();
			slow.setNext(null);
		}
		return nodes;
	}
	
	ListNode merge(ListNode node1, ListNode node2){
		ListNode node = null;
		if(node1 == null){
			return node2;
		}
		if(node2 == null){
			return node1;
		}
		
		if(node1.getData() > node2.getData()){
			node = node2;
			node.setNext(merge(node1, node2.getNext()));
		}
		else if(node1.getData() <= node2.getData()){
			node = node1;
			node.setNext(merge(node1.getNext(), node2));
		}
		return node;
	}
	
}
