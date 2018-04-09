package linkedlist;

import java.util.LinkedList;

public class LinkedList_controller {
	
	LinkedList ll = new LinkedList();
	Node head;
	Node tail;
	
	/**Adding node to the tail of the linkedlist
	 * <p>1.1 empty linkedlist
	 * <p>1.2 non-empty linkedlist
	 * */
	public void insertNode(String data){
		Node newNode = new Node(data);
		
		if(head == null){		//1.1
			head = newNode;
			tail = newNode;
		}else{					//1.2
			tail.next = newNode;
			tail = newNode;
		}
	}
	/** Adding node to the begining of the linkedlist
	 * */
	public void insertNodeToHead(String data){
		Node newNode = new Node(data);
		
		if(head == null){		//1.1
			head = newNode;
			tail = newNode;
		}else{					//1.2
			newNode.next = head;
			head = newNode;
		}
	}
	
	public void insertNodeToPos(String data, int pos){
	
		//if size = 10; an element which we're trying insert at position 11; then it should allow to (append)
		if (pos > getSize()+1){
			System.out.println("*****"+data+" can't be inserted!*****\nspecified position is more than the size of linkedlist\n");
			return;
		}
		
		Node newNode = new Node(data);
		Node tmpNode = null;
		//reach to the prev node to set the 'advanced' pointers to the new node
		if (pos > 0) {
			if (pos == 1) {
				insertNodeToHead(data);
			}
			int index = 1;
			Node node = head;
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
	
	public void traverse(){
		Node node = head;
		while(node != null){
			String display = node.data+" -> ";
			
			if(node.next == null){
				display = display.replace("->", "-> NULL");
			}
			System.out.print(display);
			
			node = node.next;
			
		}		
	}
	
	public int getSize(){
		int size = 0;

		Node node = head;
		while (node != null) {
			node = node.next;
			size++;
		}
		return size;
	}
}
