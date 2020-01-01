package com.sorting;

import java.util.Arrays;
import java.util.Random;

import com.sorting.common.Utilities;

public class SelectionSort {
	
	public int[] selectMe(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			int min_idx = findIndexMinimumElement(arr, i);
			//System.out.println("Minimum element found at "+min_idx);
			
			// swap ith pos with min_idex
			if(min_idx != i) {
				arr[i] = arr[i] ^ arr[min_idx];
				arr[min_idx] = arr[i] ^ arr[min_idx];
				arr[i] = arr[i] ^ arr[min_idx];
			}	
		}
		return arr;
	}

	private int findIndexMinimumElement(int[] arr, int index) {
		int min = arr[index];
		int min_idx = index;
		for (int i = index; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
				min_idx = i;
			}
		}
		return min_idx;
	}

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		int arr[] = rand.ints(100, 1, 1000).toArray(); 
		boolean result = new Utilities().isSorted(arr); 
		System.out.println("BEFORE: Is sorted? :-> "+  result);
	 	
	// Arrays.stream(arr).forEach(System.out::println);
		
		SelectionSort sort = new SelectionSort();
	//	int arr[] = {78, 31, 15, 67, 24, 43, 93, 59, 82, 6};
	//	int arr[] = {4, 8, 2 ,3};
	//	int arr[] = {4, 8, 2 ,3, 11, 6, 5, 0};
		
		long start = System.currentTimeMillis();
		arr = sort.selectMe(arr);
		long stop = System.currentTimeMillis();

		// print sorted array
		Arrays.stream(arr).forEach(System.out::println);
		
		// test if result array is sorted
		boolean result1 = new Utilities().isSorted(arr);
		System.out.println("\nIs sorted? :-> "+ result1);
		
		long timeElapsed = stop - start;
		System.out.println("Total time took by bubble sort is:"+timeElapsed);
	}
}
