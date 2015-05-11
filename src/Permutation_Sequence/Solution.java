package Permutation_Sequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	int f[];
    public String getPermutation(int n, int k) {
    	f = new int[n+1];
    	if(k>factorial(n)) return "-1";
    	List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
        	list.add(i);
        }
        StringBuilder sb = new StringBuilder();
        k--;
        while(list.size()>0){
        	int mul = factorial(n-1);
        	int index = k/mul;
        	sb.append(list.get(index));
        	list.remove(index);
        	k = k%mul;
        	n--;
        }
        return sb.toString();
    }
    private int factorial(int num){
    	if(num == 0) return f[0]=1;
    	if(f[num]>0){
    		return f[num];
    	}else{
    		return f[num]=factorial(num-1)*num;
    	}
    	
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	System.out.println(so.getPermutation(4, 22));
    }
}
