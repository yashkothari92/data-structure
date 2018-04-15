package linkedlist;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RunLinkedList {

	public static void main(String[] args) {
		LinkedListOp cont = new LinkedListOp();
		//Generate random numbers
		/*Random random = new Random();
		
		long start = System.nanoTime();
		for(int i = 0; i<=10000; i++){
			cont.insertNode(String.valueOf(random.nextInt(100)));
		}
		long stop = System.nanoTime();*/

		/*long duration = TimeUnit.MILLISECONDS.toSeconds(stop - start);
		System.out.println("\nTime taken to insert elements: "+duration+" milliseconds");*/
		cont.insertNode("Water");
		cont.insertNode("Air");
		cont.insertNode("Fire");
		cont.insertNodeToHead("A");
		cont.insertNodeToHead("B");
		cont.insertNodeToHead("C");
		cont.traverse();
		System.out.println("\nDeleting val: Fire...");
		cont.deleteByVal("Fire");
		cont.traverse();
		System.out.println("\nDeleting pos 3...");
		cont.deleteByPos(3);
		/*cont.insertNodeToHead("A");
		cont.insertNodeToHead("B");
		cont.insertNodeToHead("C");
		cont.insertNodeToPos("Canada", 3);
		cont.insertNodeToPos("India", 2);
		cont.insertNodeToPos("Switzerland", 8);
		cont.insertNodeToPos("Norway", 7);
		cont.insertNodeToPos("Brazil", 1);*/
		cont.traverse();
		System.out.println("\nReversubg kust,,,");
		Node head = cont.returnHead();
		System.out.print("\nForward recursion");
		cont.printRecursionForward(cont.returnHead());
		System.out.print("\nReverse recursion");
		cont.printRecursionReverse(cont.returnHead());
		
		//cont.ReverseListIterative();
		System.out.println();
		cont.reverseListRecursion(head);
				
	}

	
	
}
