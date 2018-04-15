package linkedlist;

class LinkedList{
	NodeA head1, head2;
}

class NodeA {
	 
    int data;
    NodeA next;

    NodeA(int d) {
        data = d;
        next = null;
    }
}

public class IntersectionPoint_YLL {

	public static void main(String[] args) {
		LinkedListOp<Integer> cont = new LinkedListOp<Integer>();
		IntersectionPoint_YLL yl = new IntersectionPoint_YLL();
		
		LinkedList list = new LinkedList();
		   
        // creating first linked list
        list.head1 = new NodeA(3);
        list.head1.next = new NodeA(6);
        list.head1.next.next = new NodeA(15);
        list.head1.next.next.next = new NodeA(15);
        list.head1.next.next.next.next = new NodeA(30);
 
        // creating second linked list
        list.head2 = new NodeA(10);
        list.head2.next = new NodeA(15);
        list.head2.next.next = new NodeA(30);
        
       System.out.println(findIntersectNode(list.head1, list.head2));
       
	}
	
	static int findIntersectNode(NodeA head1, NodeA head2) {
		int m = findLength(head1);
		int n = findLength(head2);
		       
		 NodeA a = head1;
		 NodeA b = head2;
		       
	     int d;
	       
	     if(m>n){
	    	 d = m - n; //originally 'a' is longer
	     }else{
		      d = n - m;
		      //make it a longer now for b
		      NodeA temp = a;
		      a = b;
		      b = temp;
	      }
	      
	       //walk through d nodes of longer list i.e. A 
	       for(int i = 0; i < d; i++){
	    	   a = a.next;
	       }
	       
	       //Now a & b are at equal distance from the merge point
	       while(a!=null && b!=null){
	    	   if(a.data == b.data){  //why a == b is not working?
	    		   return a.data;
	    	   }
	    	   a = a.next;
	    	   b = b.next;
	       }
	       return -1;
		}		

		static int findLength(NodeA head) {
			NodeA node = head;
			int size = 0;
			while (node != null) {
				size++;
				node = node.next;
			}
			return size;
		}
	} 
