package doublylinkedlist;

public class RunDoublyLinkedList {

	public static void main(String[] args) {
		DoublyLinkedListOp op = new DoublyLinkedListOp();
		
		op.insertNode("Kate");
		op.insertNode("vim");
		op.insertNode("Eclipse");
		
		op.insertNodeToHead("Data-structure");
		op.traverse();
		System.out.println("\nAfter adding Algorithm at pos 2...");
		op.insertNodeAtPos("Algorithm", 2);
		//op.insertNodeAtPos("React", 2);
		System.out.println();
		op.traverse();
		System.out.println("\nAfter deleting Data-structure\n");
		op.deleteByVal("Data-structure");
		op.traverse();

		System.out.println("\nMy head is: "+op.getHead().data);
		
	}
}
