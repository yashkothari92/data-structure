package com.sorting.common;

import java.util.stream.IntStream;

public class Utilities {

	public boolean isSorted(int[] arr) {
		/**
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			} else {
				return true;
			}
		}
		return false;
		*/
		return IntStream.range(0, arr.length-1).allMatch(i-> arr[i] <= arr[i+1]);
	}
}
