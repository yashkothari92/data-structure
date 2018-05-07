package queue;

public class CircularQueueUsingArray {
	int front = -1;
	int rear = -1;
	int MAX_SIZE = 10;
	int circq[] = new int[MAX_SIZE];
	
	private void enqueue(int x) {
		if(isFull()) {
			System.out.println("Err/1");
			return;
		}else if(isEmpty()) {
			front = rear = 0;
		}else {
			rear = (rear + 1)%MAX_SIZE;
		}
		circq[rear] = x;
	}
	
	private void dequeue() {
		if(isEmpty()) {
			System.out.println("Err/1");
		}else if (front == rear){
			front = -1;
			rear = -1;
		}
		else {	
			int temp = front;
			front = (front+1)%MAX_SIZE;
			circq[temp] = 0;
		}
	}
	
	private int front() {
		if(!isEmpty())
			return circq[front];
		else
			return -1;
	}
	
	private boolean isEmpty() {
		if(front == -1)
			return true;
		return false;
	}
	
	private boolean isFull() {
		if((rear+1)%MAX_SIZE == front)		
			return true;
		return false;
	}
	
	private void traverseQueue() {
		for(int i = 0; i<circq.length; i++) {
			System.out.print(circq[i]+" -> ");
		}
	}

	public static void main(String[] args) {
		CircularQueueUsingArray circArr = new CircularQueueUsingArray();
	
		System.out.println("Queue Empty?  "+circArr.isEmpty());
		circArr.enqueue(66);
		circArr.traverseQueue();
		
		System.out.println();
		circArr.enqueue(116);
		circArr.traverseQueue();
		
		System.out.println();
		circArr.enqueue(609);
		circArr.traverseQueue();
		
		System.out.println();
		circArr.enqueue(783);
		circArr.traverseQueue();
		
		System.out.println("\nFront->"+circArr.front());
		
		circArr.dequeue();
		circArr.traverseQueue();
		
		System.out.println("\nQueue Empty?  "+circArr.isEmpty());
		
		System.out.println("Front -> "+circArr.front());
	}
}
