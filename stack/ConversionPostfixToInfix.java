package stack;

import java.util.Stack;

/*
 * Convert postfix expression to infix expression
 * Postfix expression: abc-d+/ca-*c*
 * Infix expression: (a/(b-c+d))*(c-a)*c
 * 
 * i) Reverse postfix
 * ii) Go from right to left &
 * iii) use stack to evaluate postfix
 * */
public class ConversionPostfixToInfix {

	public static void main(String[] args) {
		ConversionPostfixToInfix cpi = new ConversionPostfixToInfix();
		
		String postfix = "abc-d+/ca-*c*";
		System.out.println("Given postfix = "+postfix);
		String reverse = cpi.reverseExp(postfix);
		System.out.println("Reverse = "+reverse);
		String infix = cpi.convertToInfix(reverse);		
		System.out.println("Converted Infix = "+infix);
	}
	
	private String convertToInfix(String reverse) {
		Stack<String> stack = new Stack();
		int length = reverse.length();
		
		//from right to left
		for(int n = length-1 ; n>=0; n--) {
			Character ch = reverse.charAt(n);
			if(isOperand(ch)) {
				stack.push(String.valueOf(ch));
			}else if(isOperator(ch)) {
				if(!stack.isEmpty()) {
					String op2 = stack.pop();
					if(!stack.isEmpty()) {
						String op1 = stack.pop();
						String expr = performOperation(op1, op2, ch);
						stack.push(expr);
					}
				}
			}
		}
		return stack.peek();
	}
	
	private String performOperation(String op1, String op2, char operator) {
		String expr = null;
		switch(operator) {
			case '+':
				expr = op1+"+"+op2;
				break;
			case '-':
				expr = op1+"-"+op2;
				break;
			case '*':
				expr = op1+"*"+op2;
				break;
			case '/':
				expr = op1+"/"+op2;
				break;
		}
		return expr;
	}

	private boolean isOperator(Character c) {
		if(c == '+' || c == '-' || c == '*' || c == '/') {
			return true;
		}else {
			return false;
		}
	}

	private boolean isOperand(Character c) {
		if(Character.isDigit(c)) return true;
		if(Character.isAlphabetic(c)) return true;
		
		return false;
	}

	private String reverseExp(String postfixExp) {
		String rev_infix = "";
		int length = postfixExp.length();
		
		for(int n=length-1; n>=0; n--) {
			rev_infix += postfixExp.charAt(n);
		}
		return rev_infix;
	}
}
