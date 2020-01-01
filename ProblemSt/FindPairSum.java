package array;

import java.util.HashMap;
import java.util.Map;

public class FindPairSum {

	public static void main(String[] args) {
		
		int[] arr = { 2, 3, 4, 7, 0 };
		int target = 7;
		 
		/*
		 * int arr [] = {1, 5, 3, 2, 4}; int target = 9;
		 */
		
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			int delta = target-arr[i];
			if(map.containsKey(delta)) {
				System.out.println("sum at position "+i+", "+arr[i]+" "
						+ "and at position "+map.get(delta)+", "+ arr[map.get(delta)]
						+" matches target "+target);
			} else {
				map.put(arr[i], i);
			}
		}
	}
}
