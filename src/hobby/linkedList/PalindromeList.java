package hobby.linkedList;

/*
 * Find whether the list is palindrome or not
 * 
 */
public class PalindromeList {

	public static void main(String[] args) {
		LinkedLists linkedLists = new LinkedLists();
		ListNode node = null;
		node = linkedLists.insertAtEnd(node, 2);
		node = linkedLists.insertAtEnd(node, 3);
		node = linkedLists.insertAtEnd(node, 5);
		node = linkedLists.insertAtEnd(node, 3);
		node = linkedLists.insertAtEnd(node, 2);
		System.out.println("Initial List:::");
		linkedLists.printList(node);
		PalindromeList palindromeList = new PalindromeList();
		int isPalindrome = palindromeList.isPalindrome(node);
		if(isPalindrome == 1){
			System.out.println("List is Palindrome");
		}
		else{
			System.out.println("List is not palindrome");
		}
	}
	
	int isPalindrome(ListNode head){
		
		ListNode middle = getMiddle(head);
		ListNode end = reverseList(middle);
		int flag = 1;
		while(end.getNext() != null){
			System.out.println(end.getData());
			if(head.getData() == end.getData()){
				flag = 1;
			}
			else{
				flag = 0;
				break;
			}
			head = head.getNext();
			end = end.getNext();
		}
		return flag;
	}

	ListNode getMiddle(ListNode head){
		ListNode fast = head;
		ListNode slow = head;
		while(fast.getNext() != null){
			fast = fast.getNext();
			if(fast.getNext() != null){
				fast = fast.getNext();
				slow = slow.getNext();
			}
		}
		return slow;
	}
	
	ListNode reverseList(ListNode head){
		ListNode temp = null;
		ListNode nextNode = null;
		ListNode current = head;
		while(current != null){
			nextNode = current.getNext();
			current.setNext(temp);
			temp = current;
			current = nextNode;
		}
		return temp;
	}
}	
