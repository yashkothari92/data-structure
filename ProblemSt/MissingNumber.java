package array;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumber {

	public static void main(String[] args) {
		int length = 10;
		int[] array = new int[] { 3, 4, 5, 6, 8 };
		
		printMissingNumbers(array, length);
		//int missedElem = findMissingNumber(array, length);
		
		//System.out.println("missedElem: "+missedElem);
	}

	private static void printMissingNumbers(int[] array, int n) {
		int totalMissingNums = n - array.length;
		BitSet bit = new BitSet(n);
		
		// convert int[] to List<Integer>
		List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
		
		// add list_elements to BitSet
		list.stream().forEach(i-> bit.set(i));
		
		int lastMissingIdx = 1;
		for(int i=0; i<totalMissingNums; i++) {
			lastMissingIdx = bit.nextClearBit(lastMissingIdx);
			System.out.println(lastMissingIdx++);
		}	
	}
	
	private static int findMissingNumber(int[] array, int n) {
		int sumOfOrigArray = (n * (n + 1))/2;
		
		// converting int[] to List<Integer> using Java 8
		List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toCollection(ArrayList::new));
		
		// summing array using collect
		int sumOfArray = list
						.stream()
						.collect(Collectors.summingInt(Integer::intValue));
		
		// summing array using reduce
		Integer sum = list
						.stream()
				  		.reduce(0, (a,b)->a+b);
		
		int missingNum = sumOfOrigArray - sumOfArray;
		return missingNum;
	}
}
