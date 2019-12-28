import java.util.Arrays;

public class QuickSort {
	static int arr[];
	
	public static void main(String[] args) {
		arr = new int[] { 90, 1, 51, 23, 87, 47}; // {3,8,4,2,7,5}  {7, 6, 10, 5, 9, 2, 1, 15, 7}
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	/*
	  private static void quickSort(int[] arr, int low, int high) {
	  
		 * while(low < high) { 
		 * 		int mid = partition(arr, low, high);
		 * 
		 * 		quickSort(arr, low, mid-1); 
		 * 		quickSort(arr, mid+1, high);
		 * }
	  }
	 */
	
	private static void quickSort(int[] arr, int lb, int ub) {
		
		if(lb < ub) {
			// choosing 1st element as pivot element
			int pivot = arr[lb];
			
			// have 2 pointers, (start & end)
			// start will point to left most element; end will point to right most element (initially)
			int start = lb;
			int end = ub;
			
			while (start < end) {
				// if start element is smaller than or equal (<=) to pivot, increment start
				while (arr[start] <= pivot) {
					if (start != arr.length-1)
						start++;
					else
						break;
				}
	
				// if end element is greater than (>) to pivot, decrement end
				while (arr[end] > pivot) {
					if (end != arr.length)
						end--;
				}
				
				if (start < end) { 
					  swap(start, end); 
				}
				 
			}
			swap(lb, end);
		
			quickSort(arr, lb, end-1); 
			quickSort(arr, end+1, ub); 
		}
	}

	private static void swap(int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] =temp;
	}
}
