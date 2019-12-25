package queue;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {
		
		QueueUsingStack obj = new QueueUsingStack();
		obj.enqueue(10);
		obj.enqueue(15);
		obj.enqueue(2);
		
		obj.enqueue(11);
		obj.enqueue(13);
		
		for(int i=0; i<3; i++) {
			int dequeued = obj.dequeue();
			System.out.println(dequeued);
		}
		
		obj.enqueue(34);
		obj.enqueue(40);
		
		for(int i=0; i<2; i++) {
			int dequeued = obj.dequeue();
			System.out.println(dequeued);
		}
		
		obj.enqueue(94);
		int dequeued = obj.dequeue();
		System.out.println(dequeued);	
	}

	private void enqueue(int i) {
		//always push to stack1
		stack1.push(i);
	}
	
	private int dequeue() {
		if (stack2.isEmpty()) {
			//push stack 1 to stack2
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
