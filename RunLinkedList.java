package linkedlist;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RunLinkedList {

	public static void main(String[] args) {
		LinkedList_controller cont = new LinkedList_controller();
		//Generate random numbers
		/*Random random = new Random();
		
		long start = System.nanoTime();
		for(int i = 0; i<=10000; i++){
			cont.insertNode(String.valueOf(random.nextInt(100)));
		}
		long stop = System.nanoTime();*/
		cont.insertNode("Water");
		cont.insertNode("Air");
		cont.insertNode("Fire");
/*		cont.insertNodeToHead("A");
		cont.insertNodeToHead("B");
		cont.insertNodeToHead("C");
		cont.insertNodeToPos("Canada", 3);
		cont.insertNodeToPos("India", 2);
		cont.insertNodeToPos("Switzerland", 8);
		cont.insertNodeToPos("Norway", 7);
		cont.insertNodeToPos("Brazil", 4);
*/
		cont.traverse();
		/*long duration = TimeUnit.MILLISECONDS.toSeconds(stop - start);
		System.out.println("\nTime taken to insert elements: "+duration+" milliseconds");*/
	}
	
}
