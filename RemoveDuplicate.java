package linkedlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicate {
	HashMap<Object, Integer> uniqueMap = new HashMap<Object, Integer>();
	ArrayList<Integer> deleteList = new ArrayList<Integer>();
	static LinkedListOp<Integer> ob = new LinkedListOp<Integer>();
	Node<Integer> head = ob.head;
	
	public static void main(String[] args) {
		RemoveDuplicate rdup = new RemoveDuplicate();
		HashMap<Object, Integer> map = new HashMap<Object, Integer>();
		ob.insertNode(11);
		ob.insertNode(11);
		ob.insertNode(11);
		ob.insertNode(17);
		ob.insertNode(43);
		ob.insertNode(43);
		ob.insertNode(60);
		ob.insertNode(17);
		ob.insertNode(17);
		ob.traverse();
		Node<Integer> node_tmp = ob.head;
		
		map = rdup.deleteDuplicate(node_tmp);
		
		for(Map.Entry<Object, Integer> amp : map.entrySet()){
			int val = amp.getValue();
			//we'll delete only duplicate elements. so we'll need to keep Unique copy of it.
			while(val>1){
				Integer key = (Integer) amp.getKey();
				ob.deleteByVal(key);
				val = val-1;//after removing its one of the duplicate occurrence, decrement the counter by 1, and resume.
			}
		}
		System.out.println();
		ob.traverse();
	}
	/**This will return map with key being data and its value being the count of data (repetition)
	<p>For eg. {17=3, 11=3, 43=2, 60=1}*/
	public HashMap<Object, Integer> deleteDuplicate(Node<Integer> node_tmp){
		while(node_tmp != null){
			if(uniqueMap.get(node_tmp.data) != null){
				int count = uniqueMap.get(node_tmp.data);
				count++;
				uniqueMap.put(node_tmp.data, count);
			}else{
				uniqueMap.put(node_tmp.data, 1);	
			}
			node_tmp = node_tmp.next;
		}
		return uniqueMap;
	}
}
