package array;

import java.util.Arrays;

public class ReverseArrayInplace {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		arr = reverse(arr);
		Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
	}

	private static int[] reverse(int[] arr) {
		int len = arr.length;

		if (len == 0)
			return null;

		if (len == 1)
			return arr;

		for (int i = 0; i < len / 2; i++) {
			// swap ith & (length-i)th elem
			int temp = arr[i];
			arr[i] = arr[len - 1 - i];
			arr[len - 1 - i] = temp;
		}
		return arr;
	}
}
