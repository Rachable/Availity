package LISPCheck;

import java.util.*;

public class LISPCheck {
	
	public static boolean checkParenthesis(String input) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		try {
			for(int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(')
						stack.push(1);
				else if (input.charAt(i) == ')')
						stack.pop();
			}
			return stack.empty();
		}
		catch (EmptyStackException e) { 
			return false;
		}
	}
}
