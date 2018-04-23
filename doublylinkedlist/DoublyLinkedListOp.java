package doublylinkedlist;

public class DoublyLinkedListOp {

	Node head;
	Node tail;
	
	public void insertNode(String data) {
		Node newNode = new Node(data);
		Node node = head;
		//empty doubly linked-list
		if(head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = null;
			newNode.prev = null;
		}else { //not empty
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			
			
			/*Node lastNode = head;
			while(lastNode.next!=null) {
				lastNode = lastNode.next;
			}
			lastNode.next = newNode;
			newNode.prev = lastNode;
			lastNode = newNode;*/
		}
	}
	
	public void insertNodeToHead(String data) {
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			tail = newNode;
			newNode.next = null;
			newNode.prev = null;
		}else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void insertNodeAtPos(String data, int pos) {
		Node newNode = new Node(data);
		Node tmpNode = null;
		if(pos<=0) {
			System.out.println("***Not valid position***");
			return;
		}
		
		if(pos == 1) {
			insertNodeToHead(data);
		}else if(pos >= getSize()+1){
			insertNode(data);
		}else {
			int index = 1;
			Node node = head;
			while(node!=null) {
				tmpNode = node;
				node = node.next;
				index++;
				if(index == pos) {
					break;
				}
			}
			newNode.next = tmpNode.next; //next* of prev node is now next* of new
			tmpNode.next.prev = newNode;//prev* of prev's next is new
			tmpNode.next = newNode;//prev's next is newNode
			newNode.prev = tmpNode;//newNode's prev is prev
		}
	}
	
	public void deleteByVal(String data) {
		if(head.data == data) { //head to delete
			head = head.next;
			head.prev = null;
		}else if(tail.data == data){ //tail to delete
			tail = tail.prev;
			tail.next = null;
		}else { //anything in between head & tail to delete
			Node cur = head;
			while (cur.next != null) {
				if(cur.next.data == data) {
					cur.next = cur.next.next;
					cur.next.prev = cur;
				}
				cur = cur.next;
			}
		}
	}
	
	private int getSize() {
		Node node = head;
		int size = 0;
		while(node != null) {
			size++;
			node = node.next;
		}
		return size;
	}

	public void traverse() {
		Node nodeToTraverse = head;
		while(nodeToTraverse != null) {
			System.out.print(nodeToTraverse.data+" > ");
			nodeToTraverse = nodeToTraverse.next;
		}
	}
	
	public Node getHead() {
		return head;
	}
}
