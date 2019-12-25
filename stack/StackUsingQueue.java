package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
	public static void main(String[] args) {
		StackUsingQueue stack = new StackUsingQueue();
		stack.push(10);
		stack.push(19);
		stack.push(26);
		
		int del = stack.pop();
		System.out.println(del);

		int de = stack.pop();
		System.out.println(de);
		
		stack.push(20);
		stack.push(42);
		stack.push(32);
		
		int de11 = stack.pop();
		System.out.println(de11);
	}

	private void push(int i) {
		q1.add(i);
	}
	
	private int pop() {
		// put everything to Q2 but leave the last one and return it
		if (q2.isEmpty()) {
			while(q1.size()!=1) {
				q2.add(q1.poll());
			}
		}
		
		int res = q1.poll();
		
		// swap Q1 & Q2
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
		
		return res;
	}
}
