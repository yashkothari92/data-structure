package linkedlist;

import java.util.Stack;

/*
 * 1 -> 2 -> 3 -> 2 -> 1
 * 
 * #1: split the list into half 
 * 		If odd, then ignore the middle element (3)
 * 		then reverse the second linked list 2 <- 1
 * 		now compare 1st and 2nd linked-list
 * 
 * #2: reverse the entire L1 linked-list ( 1 <- 2 <- 3 <- 2 <- 1) to L2
 * 	and compare L1 & L2
 * 
 * #3: Using stack
 * */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		LinkedListOp<Integer> cont = new LinkedListOp<Integer>();
		cont.insertNode(1);
		cont.insertNode(4);
		cont.insertNode(2);
		cont.insertNode(3);
		cont.insertNode(1);
		Node head = cont.head;
		boolean result = PalindromeLinkedList.isPalindrome(head);
		System.out.println(result);
	}

	/*
	 * 1 -> 3 -> 2 -> 3 -> 1
	 * */
	private static boolean isPalindrome(Node head) {
		Stack<Integer> stack = new Stack<Integer>();
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null){
			stack.push((Integer)slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null){
			slow = slow.next;
		}
		
		while(slow != null){
			if (!stack.pop().equals(slow.data)){
				return false;
			}
		}
		return true;
	}
}
