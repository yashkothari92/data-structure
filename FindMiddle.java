package linkedlist;

/**Given a singly linked list, find middle of the linked list. 
 * For example, if given linked list is 1->2->3->4->5 then output should be 3.
 * If there are even nodes, then there would be two middle nodes, 
 * we need to print second middle element. 
 * For example, if given linked list is 1->2->3->4->5->6 then output should be 4.
 * */
public class FindMiddle {
	
	static Node<String> head;
	public static void main(String[] args) {
		FindMiddle object = new FindMiddle();
		LinkedListOp<String> op = new LinkedListOp<String>();
		
		op.insertNode("Pune");
		op.insertNode("Mumbai");
		op.insertNode("Frankfurt");
		op.insertNode("Milan");
		op.insertNode("Lugano");
		op.insertNode("Oberland");
		
		head = op.returnHead();

		/*approach#1: count the size of list(traverse) and then gets the middle element by traversing it*/
		Node<String> s = object.findMiddleNodeBySize();
		System.out.println(s.data);
		
		/*approach#2: uses 2 pointers (slow & fast) to determine the middle node*/
		Node<String> middle = object.findMiddleNode();
		System.out.println("Middle node is "+middle.data);

	}
	
	/**This method uses 2 pointers slow* & fast*.<p>
	 * slow* moves by 1 position, fast* moves by 2 position.
	 * <p>By the time fast* reaches to the end of a list, slow* will be pointing to middle node.*/
	public Node<String> findMiddleNode(){
		Node<String> fast = head;
		Node<String> slow = head;
		
		while(fast != null) {
			fast = fast.next;
			if(fast != null) {
				slow = slow.next;
				fast = fast.next;
			}
		}
		return slow;
	}
	
	/**Returns the size of linked-list*/
	public int findLinkedListSize(){
		Node<String> temp = head;
		int size = 0;
		
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		return size;
	}
	
	/*** If list size is odd, display ceil[Odd/2] element; (1->2->3->4->5 then output should be 3.)
	 * if list size is even, display 1+(size/2) element; (1->2->3->4->5->6 then output should be 4.)*/
	public Node<String> findMiddleNodeBySize() {
		int size = findLinkedListSize(); //gets the linked-list size
		int count; //counter (data to be displayed as middle node)
		int index = 1;
		if(size%2 == 0) {
			count = (size/2)+1;
		} else {
			Double half = ((double) size)/2;
			count = (int) Math.ceil(half);
		}
		Node<String> start = head;
		while(start != null) {
			if(index == count) {
				return start;
			}
			index++;
			start = start.next;
			
		}
		return null;
	}
}
