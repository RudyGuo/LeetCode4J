package Basic_Calculator_II;
/*Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.*/
import java.util.Stack;
public class Solution {
    public int calculate(String s) {
        int index = 0;
        Stack<String> stack = new Stack<>();
        while(index<s.length()){
        	int start = index;
        	char c = s.charAt(index);
        	if(c=='+'||c=='-'||c=='*'||c=='/'){
        		stack.push(c+"");
        		index++;
        	}else if(c==' '){
        		index++;
        		continue;
        	}else{
        		index++;
        		while(index<s.length()&&('0'<=s.charAt(index)&&s.charAt(index)<='9')){
        			index++;
        		}	
        		String str = s.substring(start,index);
        		if(stack.isEmpty()){
        			stack.push(str);
        			continue;
        		}
        		if(stack.peek().equals("*")){
        			stack.pop();
        			int itt = Integer.parseInt(stack.pop());
        			stack.push(itt*Integer.parseInt(str)+"");
        		}else if(stack.peek().equals("/")){
        			stack.pop();
        			int itt = Integer.parseInt(stack.pop());
        			stack.push(itt/Integer.parseInt(str)+"");
        		}else{
        			stack.push(str);
        		}
        	}
        }
        String[] a = new String[stack.size()];
		stack.toArray(a); 
		long res = Long.parseLong(a[0]);
		for(int i=1;i<a.length;i++){
			if(a[i].equals("+")){
				res += Long.parseLong(a[i+1]);
			}else{
				res -= Long.parseLong(a[i+1]);
			}
			i++;
		}
		return (int)res;
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	System.out.println(so.calculate("2-1"));
    }
}