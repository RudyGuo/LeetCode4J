package Different_Ways_to_Add_Parentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


Example 1
Input: "2-1-1".

((2-1)-1) = 0
(2-(1-1)) = 2
Output: [0, 2]


Example 2
Input: "2*3-4*5"

(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
Output: [-34, -14, -10, -10, 10]

Credits:
Special thanks to @mithmatt for adding this problem and creating all test cases.*/
public class Solution {
	List<Integer> numbers = new LinkedList<>();
	List<Character> opraters = new ArrayList<>();
    public List<Integer> diffWaysToCompute(String input) {
        StringBuilder num = new StringBuilder();
        for(int i=0;i<input.length();i++){
        	if('0'<=input.charAt(i)&&input.charAt(i)<='9'){
        		num.append(input.charAt(i));
        	}else{
        		numbers.add(Integer.parseInt(num.toString()));
        		opraters.add(input.charAt(i));
        		num = new StringBuilder();
        	}
        }
        numbers.add(Integer.parseInt(num.toString()));
        List<Integer> res = dfs(numbers,opraters);
        Collections.sort(res);
        return res;
    }
    
    private List<Integer> dfs(List<Integer> numbers,List<Character> opraters){
    	List<Integer> res = new ArrayList<>();
    	if(numbers.size()==1){
    		res.add(numbers.get(0));
    		return res;
    	}/*else if(opraters.size()==1){
    		res.add(opRes(numbers.get(0),numbers.get(1),opraters.get(0)));
    		return res;
    	}*/
    	for(int i=0;i<opraters.size();i++){
    		char c = opraters.get(i);
    		List<Integer> leftRes = dfs(numbers.subList(0, i+1),opraters.subList(0, i));
    		List<Integer> rightRes = dfs(numbers.subList(i+1,numbers.size()),opraters.subList(i+1,opraters.size()));
    		for(int left:leftRes){
    			for(int right:rightRes){
    				res.add(opRes(left,right,c));
    			}
    		}
    	}
    	return res;
    }
    
    private int opRes(int a,int b,char op){
    	switch(op){
    		case '*' :
    			return a*b;
    		case '+':
    			return a+b;
    	}
    	return a-b;
    }
    
    public static void main(String args[]){
    	Solution so =new Solution();
//   	List<Integer> list = new ArrayList<>();
    	System.out.println(so.diffWaysToCompute("15-7*6+24"));
    }
}