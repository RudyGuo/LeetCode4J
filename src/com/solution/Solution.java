package com.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
	List<String> res = new ArrayList<String>();
	public List<String> restoreIpAddresses(String s) {
		int len = s.length();
		if (len < 4 || len > 16) return res;
		StringBuilder sb = new StringBuilder(s);
		help(sb,1,0);
		return res;
	}

	public void help(StringBuilder s,int start,int num){
    	if(num>=3){
    		if(num==3){
    			String []str = s.toString().split("\\.");
    			boolean foo = true;
    			for(int i=0;i<str.length;i++){
    				int n = Integer.parseInt(str[i]);
    				if(n>255||n==0) {
    					foo = false;
    					break;
    				}
    			}
    			if(foo) res.add(s.toString());
    		}
    		return;
    	}
    	for(int i=start;i<s.length()-1;i++){
    		s.insert(i, ".");
    		help(s,i+2,num+1);
    		s.deleteCharAt(i);
    	}
    }

	public static void main(String args[]) {
		Solution so = new Solution();
		int[] num = { 1, 2, 3 };
		Integer.parseInt("048");
		System.out.println(so.restoreIpAddresses("6786374048"));
	}

}