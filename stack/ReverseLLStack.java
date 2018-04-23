package stack;

import java.util.Stack;

import linkedlist.LinkedListOp;
import linkedlist.Node;

/*Reverse linked-list elements only using stack*/
public class ReverseLLStack {

	static Stack<Node> stack = new Stack<Node>();
	
	public static void main(String[] args) {
		LinkedListOp<Integer> cont = new LinkedListOp<Integer>();
		cont.insertNode(1);
		cont.insertNode(9);
		cont.insertNode(11);
		cont.insertNode(19);
		cont.insertNode(21);
		Node<Integer> head = cont.returnHead();
		
		reverseLLUsingStack(head);
	}

	private static void reverseLLUsingStack(Node<Integer> head) {
		Stack stack = new Stack();
		Node nodeStack = head;
		
		while(nodeStack != null){
			stack.push(nodeStack.data);
			nodeStack = nodeStack.next;
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " > ");
		}
	}
}
