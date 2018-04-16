package linkedlist;

/*Rotate the linked list counter-clockwise by k nodes. 
 * Where k is a given positive integer smaller than or equal to length of the linked list. 
 * For example, if the given linked list is 10->20->30->40->50->60 and k is 4, 
 * the list should be modified to 50->60->10->20->30->40.
 * */
public class RotateLinkedList {

	public static void main(String[] args) {
		RotateLinkedList rll = new RotateLinkedList();
		LinkedListOp<String> op = new LinkedListOp<String>();
		op.insertNode("10");
		op.insertNode("20");
		op.insertNode("30");
		op.insertNode("40");
		op.insertNode("50");
		op.insertNode("60");
		
		Node<String> head = op.returnHead();
		Node<String> newHead = rll.rotateLL(6, head);
		
		rll.traverse(newHead);
	}

	private void traverse(Node<String> newHead) {
		while (newHead != null) {
			System.out.print(newHead.data+"\t");
			newHead = newHead.next;
		}
	}

	private Node<String> rotateLL(int k, Node<String> node) {
		//if list has single node; nothing to rotate returns the same head
		if(node.next == null) return node;
		
		Node<String> oldHead = node;
		int index = 1;
		
		while(index != k) {
			node = node.next;
			index++;
		}
		Node<String> newHead = node.next;
		node.next = null;
		
		node = newHead;

		//if size is n & rotating by n; then it gives the same original linked list so better to return old head
		if(node == null) return oldHead;
		
		while(node.next != null) {
			node = node.next;
		}
		node.next = oldHead;
		
		return newHead;
	}
}
