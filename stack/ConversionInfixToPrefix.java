package stack;

import java.util.Stack;

public class ConversionInfixToPrefix {

	/* Conversion of Infix expression to Prefix expression
	 * 	-> Given the infix expression
	 * 		i) Reverse the infix string
	 * 		ii) Convert it to postfix
	 * 		iii) Again the reverse postfix result
	 * 		=> and you'll have your prefix
	 * */
	public static void main(String[] args) {
		ConversionInfixToPrefix cip = new ConversionInfixToPrefix();
		
		String infixExp = "a+(b*c)";
		System.out.println("Given infix = "+infixExp);
		String reverse = cip.reverseInfixExp(infixExp);
		System.out.println("Reverse of infix = "+reverse);
		String postfix = cip.convertToPostfix(reverse);
		
		if(postfix != null) {
			System.out.println("Postfix of rev_infix = "+postfix);
		}
		String prefix = cip.reverseInfixExp(postfix);
		System.out.println("My prefix = " +prefix);
	}

	private String convertToPostfix(String reverse) {
		Stack<Character> stack = new Stack<Character>();
		String res_postfix = "";
		for(Character c: reverse.toCharArray()) {
			if(c == ' ' || c == ',') return null;
			
			if(isOperand(c)) {
				res_postfix += c;
			}else if(isOperator(c)) {
				while(!stack.isEmpty() 
						&& (!isOpeningParenthesis(c)) 
						&& hasHigherPrecedence(stack.peek(), c)) 
				{
					res_postfix += stack.peek();
					stack.pop();
				}	
				stack.push(c);
			}else if (isOpeningParenthesis(c)) {
				stack.push(c);
			}else if(isClosingParenthesis(c)) {
				while(!stack.isEmpty() && !(isOpeningParenthesis(stack.peek()))) {
					res_postfix += stack.peek();
					stack.pop();
					break;
				}
				stack.pop();
			}
		}
		while(!stack.isEmpty()) {
			res_postfix += stack.peek();
			stack.pop();
		}
		return res_postfix;
	}

	private boolean hasHigherPrecedence(Character peek, Character c) {
		int top, current;
		top = getOperatorWeight(peek);
		current = getOperatorWeight(c);
		
		if(top == current) {
			if(isRightAssociative(c)) return false;
			return true;
		}
		
		return (top>current) ? true : false;
	}

	private boolean isRightAssociative(Character c) {
		if(c == '^') return true;
		return false;
	}

	private int getOperatorWeight(Character c) {
		int weight = -1;
		switch(c) {
			case '+':
			case '-':
				weight = 1;
				break;
			case '*':
			case '/':
				weight = 2;
				break;
			case '^':
				weight = 3;
				break;
		}
		return weight;
	}

	private boolean isOpeningParenthesis(Character c) {
		if(c == '(' || c == '[' || c == '{') {
			return true;
		}else {
			return false;
		}
	}

	private boolean isClosingParenthesis(Character c) {
		if(c == ')' || c == ']' || c == '}') {
			return true;
		}else {
			return false;
		}
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

	private String reverseInfixExp(String infixExp) {
		String rev_infix = "";
		int length = infixExp.length();
		
		for(int n=length-1; n>=0; n--) {
			rev_infix+=infixExp.charAt(n);
		}
		return rev_infix;
	}
}
