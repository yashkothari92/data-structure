package queue;

class Node {
	int data;
	Node next;
	
	public Node (int data) {
		this.data = data;
	}
}

public class ImplUsingLinkedList {
	
	Node front;
	Node rear;
	
	public static void main(String[] args) {
		ImplUsingLinkedList ll = new ImplUsingLinkedList();
		Node front = ll.front;
		if(front!=null)
			System.out.println(front.data);
		ll.enqueue(6);
		ll.enqueue(11);
		ll.enqueue(15);
		ll.enqueue(19);
		ll.enqueue(24);
		
		ll.traverse();
		System.out.println();
		ll.dequeue();
		ll.traverse();
		
		front = ll.front;
		if(front!=null)
			System.out.println("\nHere you go ->"+front.data);
	}

	private void traverse() {
		Node node = front;
		while(node != null) {
			System.out.print(node.data+"\t");
			node = node.next;
		}
	}

	private void enqueue(int data) {
		Node node = new Node(data);
		
		//if queue is null
		if(front == null) {
			front = node;
			rear = node;
		}else {
			rear.next = node;
			rear = node;
		}
	}
	
	private void dequeue() {
		
		//if queue is null
		if(front == null) {
			System.out.println("Err! queue is empty");
			return;
		}else {
			Node temp = front;
			front = front.next;
			//freeing up the memory
			temp.next = null;
			temp = null;
		}
	}
	
	@SuppressWarnings("unused")
	private Node front() {
		return (!isEmpty()) ? front : null;
	}

	private boolean isEmpty() {
		return (front == null)? true : false;
	}
}
