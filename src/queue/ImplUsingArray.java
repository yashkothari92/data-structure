package queue;

/* Rear						Front
 *  |						|
 * 45  ->  47  ->  53  ->  66 	(...exit here)
 * */
public class ImplUsingArray {
	static final int MAX_SIZE = 10;
	String arrq[] = new String[MAX_SIZE]; 
	int front = -1;
	int rear = -1;
	
	//element will be always added to the rear of the queue
	private void add(String x) {
		//if rear points to the last index of array => can't add anything (Strategy: create double the size of array & copy oldArray to newArray - O(n))
		if(isFull()) {
			System.out.println("Queue is full! can't add anything");
			return;
		}
		//if front = -1, it means queue is empty, add an element to the front and increment both (front*, rear*)
		else if(isEmpty()){
			front = rear = 0;
		}//else simply add an element to ++rear
		else {
			rear++;
		}
		arrq[rear] = x;
	}
	;
	//element will be always removed from the front of the queue
	private void remove() {
		//if front is -1; queue is empty. There's nothing to remove
		if(isEmpty()) {
			System.out.println("Queue is empty! Nothing to remove");
			return;
		}
		//single element in queue (array)
		else if (front == rear) {
			front = rear = -1;
		}
		//remove an element from the front and increment front* & nullify A[front]
		else {
			int temp = front;
			front++;
			arrq[temp] = null;
		}
	}
	
		
	public static void main(String[] args) {
		ImplUsingArray arr = new ImplUsingArray();
		System.out.println("Queue Empty?  "+arr.isEmpty());
		arr.add("66");
		arr.traverseQueue();
		
		System.out.println();
		arr.add("116");
		arr.traverseQueue();
		
		System.out.println();
		arr.add("609");
		arr.traverseQueue();
		
		System.out.println();
		arr.add("783");
		arr.traverseQueue();
		
		System.out.println();
		arr.remove();
		arr.traverseQueue();
		
		System.out.println("\nQueue Empty?  "+arr.isEmpty());
	}

	private void traverseQueue() {
		for(int i = 0; i<arrq.length; i++) {
			System.out.print(arrq[i]+" -> ");
		}
	}
	
	private boolean isEmpty() {
		return (front == -1) ? true :  false;
	}

	private boolean isFull() {
		return (rear == MAX_SIZE-1) ? true :  false;
	}
}
