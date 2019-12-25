package array;

import java.util.HashMap;
import java.util.HashSet;

public class SubArraySum {

	private static void printSubArray(int n) {
		int res = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				for (int k = i; k <= j; k++) {
					System.out.print(k);
					res+=k;
					//System.out.println(res);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
	
	private static boolean subarraySum(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		//HashSet<Integer> set = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] == 0 || sum == 0 || /*set.contains(sum)*/ hm.get(sum)!=null) {
			//	int inp = hm.get(sum);
			//	System.out.println(inp+1+" to "+i);
				return true;
			}
			
			hm.put(sum, i);
			//set.add(sum);
		}
		return false;
	}

	public static void main(String[] args) {
		int arr[] = {1, -1, 2, -1, 4};
		boolean result = subarraySum(arr);
		//printSubArray(3);
		System.out.println(result);
	}

}
