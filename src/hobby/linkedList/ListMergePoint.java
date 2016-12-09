package hobby.linkedList;

public class ListMergePoint {

	public static void main(String[] args) {
		LinkedLists linkedLists = new LinkedLists();
		ListNode node1 = null;
		ListNode node2 = null;
		node1 = linkedLists.insertAtEnd(node1, 10);
		node1 = linkedLists.insertAtEnd(node1, 120);
		node1 = linkedLists.insertAtEnd(node1, 130);
		node1 = linkedLists.insertAtEnd(node1, 10);
		node1 = linkedLists.insertAtEnd(node1, 20);
		node1 = linkedLists.insertAtEnd(node1, 30);
		node1 = linkedLists.insertAtEnd(node1, 100);
		node1 = linkedLists.insertAtEnd(node1, 40);
		node2 = linkedLists.insertAtEnd(node2, 101);
		node2 = linkedLists.insertAtEnd(node2, 201);
		node2 = linkedLists.insertAtEnd(node2, 102);
		node2 = linkedLists.insertAtEnd(node2, 104);
		node2 = linkedLists.insertAtEnd(node2, 110);
		node2 = linkedLists.insertAtEnd(node2, 100);
		node2 = linkedLists.insertAtEnd(node2, 40);
		linkedLists.printList(node1);
		linkedLists.printList(node2);
		
		int node1Size = linkedLists.getListSize(node1);
		int node2Size = linkedLists.getListSize(node2);
		
		int size = node1Size>node2Size ? (node1Size - node2Size) : (node2Size - node1Size);
		int i = 0;
		for(i = 0; i < size; i++){
			if(node1Size < node2Size)
				node2 = node2.getNext();
			else
				node1 = node1.getNext();
		}
		
		while(node1 != null){
			if(node1.getData() == node2.getData()){
				System.out.println(node1.getData()+" is the merge point of both linked lists");
				return;
			}
			node1 = node1.getNext();
			node2 = node2.getNext();
		}
		System.out.println("Lists doesn't have merge point");
	}

}
