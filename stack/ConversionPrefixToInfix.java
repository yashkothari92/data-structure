package stack;

import java.util.Stack;

/*
 * Convert prefix expression to infix expression
 * Prefix expression: +a*bc
 * Infix expression: a+b*c
 * 
 * i) Reverse prefix
 * iii) use stack to evaluate prefix
 * */
public class ConversionPrefixToInfix {

	public static void main(String[] args) {
		ConversionPrefixToInfix cpi = new ConversionPrefixToInfix();
		
		String prefix = "+a*bc";
		System.out.println("Given postfix = "+prefix);
		String reverse = cpi.reverseExp(prefix);
		System.out.println("Reverse = "+reverse);
		String infix = cpi.convertToInfix(reverse);		
		System.out.println("Converted Infix = "+infix);
	}

	private String convertToInfix(String reverse) {
		Stack<String> stack = new Stack();
		int length = reverse.length();
		
		//from left to right
		for(int n = 0 ; n<=length-1 ;n++) {
			Character ch = reverse.charAt(n);
			if(isOperand(ch)) {
				stack.push(String.valueOf(ch));
			}else if(isOperator(ch)) {
				if(!stack.isEmpty()) {
					String op1 = stack.pop();
					if(!stack.isEmpty()) {
						String op2 = stack.pop();
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

	
	private String reverseExp(String postfix) {
		String rev_infix = "";
		int length = postfix.length();
		
		for(int n=length-1; n>=0; n--) {
			rev_infix += postfix.charAt(n);
		}
		return rev_infix;
	}
}