package stack;

import java.util.Stack;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}

public class ImplUsingLinkedList {

	Stack<Integer> stack = new Stack<Integer>();
	Node top;
	
	public void push(int data) {
		Node newNode = new Node(data);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}
	
	public void pop() {
		if(top == null)
			return;
		
		Node temp = top;
		top = top.next;
		temp.next = null;
		temp = null;
	}
	
	public int top() {
		if(top!=null)
			return top.data;
		return -1;
	}
	
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public void print() {
		Node temp = top;
		while(temp != null) {
			System.out.println(temp.data+" ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		ImplUsingLinkedList impl = new ImplUsingLinkedList();
		
		impl.push(10);impl.push(20);impl.push(30);impl.push(40);impl.push(50);
		System.out.println("After 5 pushes");
		impl.print();
		
		impl.pop();impl.pop();
		System.out.println("After 2 pop");
		impl.print();
		
		int top = impl.top();
		System.out.println("Current top:"+top);
	}
}
