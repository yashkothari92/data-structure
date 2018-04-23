package linkedlist;

public class LinkedListOp<T> {
	
	Node<T> head;
	Node<T> tail;
	
	/**Adding node to the tail of the linkedlist
	 * <p>1.1 empty linkedlist
	 * <p>1.2 non-empty linkedlist
	 * */
	public void insertNode(T data){
		Node<T> newNode = new Node<T>(data);
		
		if(head == null){		//1.1
			head = newNode;
			//tail = newNode;
		}else{					//1.2
			Node<T> tmpNode = findLastNode();
			tmpNode.next = newNode;
			newNode.next = null;
			//tail.next = newNode;
			//tail = newNode;
		}
	}
	
	/** Adding node to the beginning of the linked-list*/
	public void insertNodeToHead(T data){
		Node<T> newNode = new Node<T>(data);
		
		if(head == null){		//1.1
			head = newNode;
			//tail = newNode;
		}else{					//1.2
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void insertNodeToPos(T data, int pos){
	
		//if size = 10; an element which we're trying insert at position 11; then it should allow to (append)
		if (pos > getSize()+1){
			System.out.println("*****"+data+" can't be inserted!*****\nspecified position is more than the size of linkedlist\n");
			return;
		}
		
		Node<T> newNode = new Node<T>(data);
		Node<T> tmpNode = null;
		//reach to the prev node to set the 'advanced' pointers to the new node
		if (pos > 0) {
			if (pos == 1) {
				insertNodeToHead(data);
				return;
			}
			int index = 1;
			Node<T> node = head;
			while (node != null) {
				if (pos == index) {
					break;
				}
				tmpNode = node;
				node = node.next;
				index++;
			}
			newNode.next = tmpNode.next;
			tmpNode.next = newNode;
		}else{
			System.out.println("Invalid position to insert node to the linkedlist");
		}
	}
	
	public void deleteByVal(T val) {		
		//empty likedlist
		if(head == null) {
			return;
		}
		//element which is to be removed is head... advance head pointer
		if(head.data == val) {
			head = head.next;
			return;
		}
		
		//get the cur, cur.next, cur.next.next reference to adjust pointer
		Node<T> nodeToTrv = head;
		while(nodeToTrv.next != null) {
			if(nodeToTrv.next.data == val) {
				nodeToTrv.next = nodeToTrv.next.next ;
				return;
			}
			nodeToTrv = nodeToTrv.next;
		}
	}
	
	public void deleteByPos(int pos) {
		if(pos<0) {
			System.out.println("Invalid position to delete a node...You must supply positive value");
		}else if (pos>getSize()) {
			System.out.println("Invalid position to delete a node...size is "+getSize()+", and position is "+pos);
		}else {
			Node<T> node = head;
			if(pos == 1) {
				head = head.next;
			}else {
				int index = 2;//since we're dealing with head at pos 1
				while(node.next != null) {
				//	System.out.println("**"+node.data);
					if(index == pos) {
						node.next = node.next.next;
					}
					index++;
					node = node.next;
				}
			}
		}
	}
	
	public void traverse(){
		Node<T> node = head;
		while(node != null){
			String display = node.data+" -> ";		
			if(node.next == null){
				display = display.replace("->", "-> NULL");
			}
			System.out.print(display);
			node = node.next;		
		}		
	}
	
	/**returns the size of linked-list*/
	public int getSize(){
		int size = 0;

		Node<T> node = head;
		while (node != null) {
			node = node.next;
			size++;
		}
		return size;
	}
	
	/**returns the last node*/
	private Node<T> findLastNode() {
		Node<T> nodeToReturn = head;
		while(nodeToReturn.next != null) {
			nodeToReturn = nodeToReturn.next;
		}
		return nodeToReturn;
	}
	
	/*Reverses the linked-list using iterative approach*/
	public void ReverseListIterative() {
		Node<T> prev = null;
		Node<T> current = head;
		Node<T> next;
		while(current!=null) {
			next = current.next; //next node of current
			current.next = prev; //next pointer of current node
			prev = current;//advance prev
			current = next;//advance current
		}
		head = prev; //assing head to the prev, last element
		print(head);
	}
	
	/*returns head pointer of linked-list*/
	public Node<T> returnHead() {
		System.out.println();
		return head;
	}
	
	/*Reverses the linked-list using Recursive approach*/
	public void reverseListRecursion(Node<T> p) {
	//	Node node = head;
		if(p.next == null) {
			head = p;
			System.out.print(p.data+" ");		

			return;
		}
		reverseListRecursion(p.next);
		System.out.print(" "+p.data+" ");		

		Node<T> q = p.next;
		q.next = p;
		p.next = null;
	}
	
	public void print(Node<?> node) {
		while(node != null) {
			String display = node.data+" -> ";
			if(node.next == null){
				display = display.replace("->", "-> NULL");
			}
			System.out.print(display);
			node = node.next;
		}
	}
	
	/*Print linked-list in forward direction*/
	public void printRecursionForward(Node<?> p) {
		if(p == null)
			return;
		System.out.print(p.data+"\t");
		printRecursionForward(p.next);		
	}

	/*Print linked-list in reverse direction*/
	public void printRecursionReverse(Node<?> p) {
		if(p == null)
			return;
		printRecursionReverse(p.next);
		System.out.print(p.data+"\t");
	}
}