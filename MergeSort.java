import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 90, 1, 51, 23, 87, 47}; 
		// { 90, 1, 51, 23, 87, 47} 
		// {3,8,4,2,7,5}  
		// {7, 6, 10, 5, 9, 2, 1, 15, 7}
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int[] arr, int l, int r) {
		if(l < r) {
			// find middle point
			int m = (l + (r - l) / 2);
			
			// sort both halves
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			
			// Merge the sorted arrays
			merge(arr, l, m, r);

		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		// differentiate left sub-array, and right sub-array
		int n1 = m - l + 1;
		int n2 = r - m;
		 
		// create L & R array of the same size of n1 & n2
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		// populate array L & R
		for(int i=0; i<n1; i++) {
			L[i] = arr[l + i];
		}
		
		for(int j=0; j<n2; j++) {
			R[j] = arr[m + 1 + j];
		}
		
		/* Merge arrays */
		int i =0, j=0;
		int k = l;

		while (i < n1 && j < n2 ) {
			 if(L[i] <= R[j]) {
				 arr[k] = L[i];
				 i++;
			 } else {
				 arr[k] = R[j];
				 j++;
			 }
			 k++;
		 }
		
		while (i < n1) {
			 arr[k] = L[i];
			 i++;
			 k++; 
		}
		
		while (j < n2) {
			 arr[k] = R[j];
			 j++;
			 k++; 
		}
	}
}
