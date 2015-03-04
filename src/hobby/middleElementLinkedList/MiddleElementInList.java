package hobby.middleElementLinkedList;

import java.util.Scanner;

/*
 * This Program finds middle element in LinkedList in single pass
 */
public class MiddleElementInList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		LinkedList.Node head = list.head();
		String input;
		System.out.println("Enter numbers to enter into linked list. Type 'exit' to finish");
		Scanner in = new Scanner(System.in);
		do{
			input = in.nextLine();
			if(!("exit".equalsIgnoreCase(input)))
				list.add(new LinkedList.Node(input));
		}while(!("exit".equalsIgnoreCase(input)));
		in.close();
		LinkedList.Node current = head;
		int length = 0;
		LinkedList.Node middle = head;
		while(current.next() != null){
			length++;
			if(length%2 == 0){
				middle = middle.next();
			}
			current = current.next();
		}
		if(length%2 == 1){
			middle = middle.next();
		}
		System.out.println("Length Of LinkedList::"+length);
		System.out.println("Middle Element Of LinkedList::"+middle);
	}

}
class LinkedList{
    private Node head;
    private Node tail;
  
    public LinkedList(){
        this.head = new Node("head");
        tail = head;
    }
  
    public Node head(){
        return head;
    }
  
    public void add(Node node){
        tail.next = node;
        tail = node;
    }
  
    public static class Node{
        private Node next;
        private String data;

        public Node(String data){
            this.data = data;
        }
      
        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
      
        public String toString(){
            return this.data;
        }
    }
}

