package Happy_Number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	Set<Integer> used = new HashSet<>();
    public boolean isHappy(int n) {
    	int bs = bitSum(n);
        if(n==1){
        	return true;
        }else if(used.contains(n)){
        	return false;
        }
        used.add(n);
        return isHappy(bs);
    }
    
    private int bitSum(int n){
    	int res = 0;
    	String str = n+"";
    	for(int i=0;i<str.length();i++){
    		res  += Math.pow((str.charAt(i)-'0'),2);
    	}
    	return res;
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	System.out.println(so.isHappy(19));
    }
}
