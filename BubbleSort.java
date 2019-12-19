package com.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import com.sorting.common.Utilities;

public class BubbleSort {

	public int[] ret;
	
	public int[] goBubbly(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					//swap using XOR
					arr[j] = arr[j] ^ arr[j + 1];
					arr[j + 1] = arr[j] ^ arr[j+1]; 		//(j ^ j+1 ^ j+1) ==> j
					arr[j] = arr[j] ^ arr[j + 1];			//(j ^ j ^ j+1) ==> j+1
				}
			}
		}
		return arr;
	}
	
	public static void main(String[] args) {
		
		Random rand = new Random();
		int arr[] = rand.ints(1000, 1, 1000).toArray();
		boolean result = new Utilities().isSorted(arr);
		System.out.println("BEFORE: Is sorted? :-> "+ result);
		
	// Arrays.stream(arr).forEach(System.out::println);
		
		BubbleSort sort = new BubbleSort();
	//	int arr[] = {78, 31, 15, 67, 24, 43, 93, 59, 82, 6};
	//	int arr[] = {4, 8, 2 ,3};
	//	int arr[] = {4, 8, 2 ,3, 11, 6, 5, 0};
		
		long start = System.currentTimeMillis();
		arr = sort.goBubbly(arr);
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
