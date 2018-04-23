package stack;

import java.util.Arrays;
import java.util.Stack;

/* Original Infix expression: 	2 * 3 + 5 * 4 - 9
 * 		=> Prefix expression:	- + * 3 2 * 5 4 9
 * */
public class EvaluationPrefix {
	public static void main(String[] args) {
		EvaluationPrefix evalpre = new EvaluationPrefix(); 
		String expression = "-+*23*549";
		
		int evaluated = evalpre.evaluate(expression);
		System.out.println("Prefix expression evaluation:"+evaluated);
	}

	private int evaluate(String expression) {
		Stack<Integer> stack = new Stack<Integer>();
		
		//define an array of operators to distinguish between operand & operator
		Character operator [] = {'+','-','*','/','%','^'};
		
		//iterate over an expression string but from right to left
		int size = expression.length();
		for(int n = size -1 ; n>=0 ; n--) {
			Character ch = expression.charAt(n);
			
			//if expression contains space or comma, simple ignore them and move on
			if(ch.equals(',') || ch.equals(' '))
				continue;
			
			//i.e if reading character from expression string is operand, push it into the stack
			if(!Arrays.asList(operator).contains(ch)) {
				stack.push(Integer.parseInt(ch.toString()));
			}else {
				//pop the (last) 2 elements from the stack
				//[!] Check if stack is not empty; else will throw an exception like StackEmptyException
				//1st popped element will be stored in op1; & 2nd popped element will be stored in op2
				if(stack.isEmpty()) {
					continue;
				}
				Integer op1 = stack.pop();
				Integer op2 = stack.pop();
				
				char oper = ch.charValue();
				//perform operation and returns result
				int result = perfromOperation(op1, op2, oper);
				//push the result back to stack
				stack.push(result);
			}
		}
		
		// If expression is in correct format, Stack will finally have one element. This will be the output. 
		return stack.peek();
	}

	private int perfromOperation(Integer op1, Integer op2, char ch) {
		int result = 0;
		switch(ch) {
		
		case '+' :
			result = (op1 + op2);
			break;
		case '-' :
			result = (op1 - op2);
			break;
		case '*' :
			result = (op1 * op2);
			break;
		case '/' :
			result = (op1 / op2);
			break;
		case '%' :
			result = (op1 % op2);
			break;
		case '^' :
			result = (int) Math.pow(op1, op2);
			break;
		
		default:
		}
		
		return result;
	}
}

