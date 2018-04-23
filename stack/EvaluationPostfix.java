package stack;

import java.util.Arrays;
import java.util.Stack;

/* Original Infix expression: 	2 * 3 + 5 * 4 - 9
 * 		=> Postfix expression:	2 3 * 5 4 * + 9 -
 * */
public class EvaluationPostfix {

	public static void main(String[] args) {
		EvaluationPostfix evalpost = new EvaluationPostfix(); 
		String expression = "2,3*54*+9-";
		
		int evaluated = evalpost.evaluate(expression);
		System.out.println("Postfix expression evaluation:"+evaluated);
	}

	private int evaluate(String expression) {
		Stack<Integer> stack = new Stack<Integer>();
		
		//define an array of operators to distinguish between operand & operator
		Character operator [] = {'+','-','*','/','%','^'};
		
		//iterate over an expression string
		for(Character ch : expression.toCharArray()) {
			
			//if expression contains space or comma, simple ignore them and move on
			if(ch.equals(',') || ch.equals(' '))
				continue;
			
			//i.e if reading character from expression string if it is operand, then push it into the stack
			if(!Arrays.asList(operator).contains(ch)) {
				stack.push(Integer.parseInt(ch.toString()));
			}else {
				//pop the (last) 2 elements from the stack
				//[!] Check if stack is not empty; else will throw an exception like StackEmptyException
				//1st popped element will be stored in op2; & 2nd popped element will be stored in op1
				Integer op2 = stack.pop();
				Integer op1 = stack.pop();
				
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
