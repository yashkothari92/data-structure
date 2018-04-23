package stack;

import java.util.Stack;

import linkedlist.LinkedListOp;
import linkedlist.Node;

/*Reverse linked-list itself (along with next pointer) using stack*/
public class ReverseLLUsingStack {
	
	public static void main(String[] args) {
		LinkedListOp<Integer> cont = new LinkedListOp<Integer>();
		ReverseLLUsingStack revStack = new ReverseLLUsingStack();
		
		cont.insertNode(1);
		cont.insertNode(13);
		cont.insertNode(21);
		cont.insertNode(33);
		cont.insertNode(41);
		Node<Integer> head = cont.returnHead();
		System.out.println("Original LinkedList");
		revStack.traverse(head);
		System.out.println();
		System.out.println("LinkedList after reversing");
		revStack.reverseLL(head);				
	}

	private void traverse(Node reversed) {
		while(reversed != null) {
			System.out.print(reversed.data+" ");
			reversed = reversed.next;
		}
	}

	private void reverseLL(Node<Integer> head) {
		Stack<Node> stack = new Stack<Node>();
 		Node<Integer> temp = head;
		//pushing the references of the nodes to stack
 		while(temp != null) {
			stack.push(temp);
			temp = temp.next;
		}
		
 		//get the top (which is last node)
		temp = stack.peek();
		head = temp;
		
		//now pop & get to the last - 1
		stack.pop();
		
		//iterate until the stack gets empty
		while(!stack.isEmpty()) {
			temp.next = stack.peek();
			stack.pop();
			temp = temp.next;
		}
		temp.next = null;
		
		traverse(head);
		
	}
}
