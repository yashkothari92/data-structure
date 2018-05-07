package queue;

/*
 * Few of the items I'm procrastinating...
 * 
 * 	i) Priority Queue (using Binary heap performance is quite better as compared to array & liked list)
 * 		using Array: insertion - O(1)
 * 					findHighestPriority - O(n)
 * 					removeHighestPriority - O(n)
 * 
 * 		using Linked list: insertion - O(1)
 * 							findHighestPriority - O(n)
 * 							removeHighestPriority - O(n)	
 * 		although removing element will take O(n), but like array, we don't need to move every other element 1 position ahead
 * 		By that means Linked list has better edge against array
 * 
 * 		using Heap
 * 		Heap is generally preferred for priority queue implementation 
 * 		because heaps provide better performance compared arrays or linked list. 
 * 
 * 		In a Binary Heap, getHighestPriority() can be implemented in O(1) time, 
 * 							insert() can be implemented in O(Logn) time and 
 * 							deleteHighestPriority() can also be implemented in O(Logn) time.
 * 
 * 		With Fibonacci heap, insert() and getHighestPriority() can be implemented in O(1) amortized time and 
 * 							deleteHighestPriority() can be implemented in O(Logn) amortized time.
 * 
 * 		[P.S - One I'll have better understanding of heap data-structure I'll move to solving priority queue]
 * 
 * 
 * 	ii) DEQUE (Double Ended Queue)
 * 		a generalized version of Queue data structure that allows insert and delete at both ends.
 * 
		insertFront(): Adds an item at the front of Deque.
		insertLast(): Adds an item at the rear of Deque.
		deleteFront(): Deletes an item from front of Deque.
		deleteLast(): Deletes an item from rear of Deque.
		
		In addition to above operations, following operations are also supported
		getFront(): Gets the front item from queue.
		getRear(): Gets the last item from queue.
		isEmpty(): Checks whether Deque is empty or not.
		isFull(): Checks whether Deque is full or not.
		
		A Deque can be implemented either using a doubly linked list or circular array. 
		In both implementation, we can implement all operations in O(1) time
 * */
public class Todo {
	public static void main(String[] args) {
		
	}
}
