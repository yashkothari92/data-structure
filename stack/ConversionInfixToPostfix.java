package stack;

import java.util.Stack;

public class ConversionInfixToPostfix {
	public static void main(String[] args) {
		ConversionInfixToPostfix itp = new ConversionInfixToPostfix();
		//candidate input1 : "((A + B)*C-D)*E";
		//candidate input2 : "a+b*c-d*e";
		String infixExp = "(a/(b-c+d))*(c-a)*c"; 
		
		String pfix = itp.convertToPostFix(infixExp);
		System.out.println(pfix);
	}

	private String convertToPostFix(String infixExp) {
		Stack<Character> stack = new Stack<Character>();
		String postfix = "";
		for(Character c : infixExp.toCharArray()) {
			//ignore white space or commas
			if(c.equals(' ') || c.equals(','))
				continue;

			//if its operand, then append it to the result string (postfix expression).
			/*if its operator, then 
						i) if top has higher precedence than current char, 
								then pop and append to the postfix string
						ii) else push the operator to the stack
			*/
			if(isOperand(c)) {
				postfix += c;
			} else if (isOperator(c.charValue())) {
				while (!stack.isEmpty()
						&& (c != '(')
						&& hasHigherPrecedence(stack.peek(), c)) {
					postfix += stack.peek();
					stack.pop();
				}
				stack.push(c);
			} else if (c == '(') {
				//when we see '(', simply push them to stack
				stack.push(c);
			} else if (c == ')') {
				//when we see ')' [closing parenthesis] we're reaching to logical end of last '('
				//we'll pop off the stack until we get to the '(' 
				while(!(stack.peek() == '(')){
					postfix += stack.peek();
					stack.pop();
					break;
				}
				//now pop the '('
				stack.pop();
			}
		}
		
		while(!stack.isEmpty()) {
			postfix+=stack.peek();
			stack.pop();
		}
		
		return postfix;
	}
	
	private boolean hasHigherPrecedence(Character top, Character c){
		int op1Weight = getOperatorWeight(top);
		int op2Weight = getOperatorWeight(c);
		
		//if both operators have same weight => return true is they are left associative,
		//else if its rightAssociative, then return false => this will give the priority to the right operator (i.e. character 'c')
		//if operator is left-associative, left one should be given priority (i.e. Character top - top of the stack)
		if(op1Weight == op2Weight){
			if(isRightAssociative(c))
				return false;
			return true;
		}
		
		return (op1Weight > op2Weight) ? true : false;
	}
		
	//determines weight of operator, based on that return true or false
	/*for eg. 
	 * => 	+, - will have weight 1
	 * =>	*, / will have weight 2
	 * => 	^	will have weight 3 and rightAssociativity
	 * */
	private int getOperatorWeight(Character c) {
		/*if(pop == '*' || pop == '/'){
			if((c == '+' || c == '-')){
					return true; 
			}
		}
		return false;*/
		int weight = -1;
		switch (c) {
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
      /*  default:
            throw new IllegalArgumentException("Operator unknown: " + c);*/
		}
		return weight;
	}

	private boolean isOperator(Character c) {
		if(c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
			return true;
		return false;
	}

	private boolean isOperand(Character c) {
		/*if (c >= 0 || c <= 9)
			return true;
		else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
			return true;*/
		if(Character.isDigit(c))
			return true;
		else if(Character.isLetter(c)) 
			return true;
		return false;
	}

	private boolean isRightAssociative(Character c){
		if (c == '^')
			return true;
		return false;
	}
}
