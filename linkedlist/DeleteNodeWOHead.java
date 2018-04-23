package linkedlist;

public class DeleteNodeWOHead {

	/*simply advance the pointer and store it to temporary node
	 * now store next* data & next ref to the passed node */
	 void deleteNode(Node del)
	    {
		 
		 	if(del.next != null){
		        Node temp = del.next;
		        del.data = temp.data;
		        del.next = temp.next;
		 	}else{
		 		//this method only works for non-last node. 
		 	}
	    }
}
