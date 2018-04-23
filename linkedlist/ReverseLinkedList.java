package linkedlist;

public class ReverseLinkedList {

	public Node<?> reverseLinkedList(Node<?> head) {
		Node<?> prev = null;
		Node<?> current = head;
		Node<?> next;
		
		while(current != head){
			next = current.next;
			current.next = (Node<?>) prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}
}
