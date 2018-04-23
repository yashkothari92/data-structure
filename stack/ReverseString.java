package stack;

import java.util.Stack;

public class ReverseString {

	public static void main(String[] args) {
		String str = "YASH KOTHARI";
		
		String res = ReverseString.reverseStringUsingStack(str);
		System.out.println(res);
	}

	private static String reverseStringUsingStack(String str) {
		//taking Stack<Character> data type to deal with String
		Stack<Character> stack = new Stack<Character>();
		//initially top would be pointing at -1 pos, indicating stack is empty
		int top = -1;
		
		//iterating over string, and pushing one character at a time to stack
		for(Character c: str.toCharArray()) {
			stack.push(c);
			top++;
		}
		//creating new String which will holds the final result.
		String newString = "";
		
		//we'll pop off the stack as long as top is pointing to any value (which is not -1)
		while (top >= 0) {
			Character ch = stack.pop();
			top--;
			newString += ch.toString();
		}
		return newString;
	}
}
