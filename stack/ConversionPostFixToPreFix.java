package stack;

import java.util.Stack;

/*
 * Given the postfix expression,
 * To convert it to Prefix :
 *  i) Reverse the given postfix expression
 *  ii) Read from right to left 
 *  		if (operand), push it to stack
 *  		if (operator), pop 1(top-1) & 2(top) and then
 *  						push (operator + op1 + op2)
 *  [
 *  	I'm considering 1 as 1st element we pushed to the stack so top -1
 *  	and 2 as 2nd element we pushed to the stack, so top
 *  ]
 * */
public class ConversionPostFixToPreFix {

	public static void main(String[] args) {
		ConversionPostFixToPreFix poPre = new ConversionPostFixToPreFix();
		//candidate input1 : "((A + B)*C-D)*E";
		//candidate input2 : "a+b*c-d*e";
		String postfix = "abc*+"; 
		System.out.println("postfix = "+postfix);
		String prefix = poPre.convertToPreFix(postfix);
		System.out.println("prefix = "+prefix);
	}

	private String convertToPreFix(String postfix) {
		Stack<String> stack = new Stack<String>();
		String revPost = reverseString(postfix);
		int length = postfix.length();
		for(int i = length-1 ; i>=0; i--){
			Character c = revPost.charAt(i);
			if(isOperand(c)){
				stack.push(String.valueOf(c));
			}else if(isOperator(c)){
				//pop two elements
				String op2 = stack.pop();
				String op1 = stack.pop();
				
				stack.push(c + op1 + op2);
			}
		}
		return stack.peek();
	}

	private boolean isOperator(Character c) {
		if (c == '+' ||c == '-' ||c == '*' ||c == '/')
			return true;
		return false;
	}

	private boolean isOperand(Character c) {
		if(Character.isDigit(c)) return true;
		if(Character.isAlphabetic(c)) return true;
		return false;
	}
	
	private String reverseString(String postfix) {
		int length = postfix.length();
		String rev = "";
		for(int i = length-1; i >= 0; i--){
			rev+= postfix.charAt(i);
		}
		return rev;
	}
}
