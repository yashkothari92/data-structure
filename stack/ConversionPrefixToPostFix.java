package stack;

import java.util.Stack;
/*
 * Given the prefix expression,
 * To convert it to Postfix :
 *  i) Reverse the given prefix expression
 *  ii) Read from left to right 
 *  		if (operand), push it to stack
 *  		if (operator), pop 1(top-1) & 2(top) and then
 *  						push (op2 + op1 + operator)
 *  [
 *  	I'm considering 1 as 1st element we pushed to the stack so top -1
 *  	and 2 as 2nd element we pushed to the stack, so top
 *  ]
 * */
public class ConversionPrefixToPostFix {

	public static void main(String[] args) {
		ConversionPrefixToPostFix prePo = new ConversionPrefixToPostFix();
		//candidate input1 : "((A + B)*C-D)*E";
		//candidate input2 : "a+b*c-d*e";
		String prefixExp = "+a*bc"; 
		System.out.println(prefixExp);
		String postfix = prePo.convertToPostFix(prefixExp);
		System.out.println(postfix);
	}

	private String convertToPostFix(String prefix) {
		Stack<String> stack = new Stack<String>();
		
		String rev = reverseString(prefix);
		//System.out.println(rev);
		for(Character c : rev.toCharArray()){
			if(isOperand(c))
				stack.push(String.valueOf(c));
			else if(isOperator(c)){
				//pop two elements
				String op2 = stack.pop();
				String op1 = stack.pop();
				//gets the top element (op2)+gets 2nd top (op1)+appends operator
				stack.push(op2+op1+c);
			}
		}
		//at the end of loop, stack will have single element, return that
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

	private String reverseString(String prefix) {
		int length = prefix.length();
		String rev = "";
		for(int i = length-1; i >= 0; i--){
			rev+= prefix.charAt(i);
		}
		return rev;
	}
}
