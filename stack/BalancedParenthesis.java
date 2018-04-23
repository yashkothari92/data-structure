package stack;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParenthesis {
	/*char inArray [] = {'{','(','[','<'};
	String outArray [] = {"}",")","]",">"};*/
	//can take 2D- array [][]
	
	HashMap<Character, Character> tokens = new HashMap<Character, Character>();
	
	//key as opening terms & val as closing terms
	public BalancedParenthesis() {
		tokens.put('[', ']');
		tokens.put('{', '}');
		tokens.put('(', ')');
		tokens.put('<', '>');
	}
	
	public static void main(String[] args) {
		BalancedParenthesis bal = new BalancedParenthesis();
		String strToCheck = "[][][(())]";
		
		boolean result = bal.isBalanced(strToCheck);
		System.out.println(result);
	}

	public boolean isBalanced(String str){
		Stack<Character> stack = new Stack<Character>();
		for(char c : str.toCharArray()){
			if(tokens.containsKey(c)) {
				stack.push(c);
			}else if(stack.isEmpty() || c != tokens.get(stack.pop())){
				return false;
			}
		}
		return stack.isEmpty();
	}
}
