package Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+")) {
				int a = stack.pop();
				int b = stack.pop();
				int res = b + a;
				stack.push(res);
			} else if (tokens[i].equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				int res = b - a;
				stack.push(res);
			} else if (tokens[i].equals("*")) {
				int a = stack.pop();
				int b = stack.pop();
				int res = b * a;
				stack.push(res);
			} else if (tokens[i].equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				int res = b / a;
				stack.push(res);
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.peek();
	}

	public static void main(String args[]) {
		Solution so = new Solution();
		String str[] = { "6", "3", "/" };
		System.out.println(so.evalRPN(str));
	}
}
