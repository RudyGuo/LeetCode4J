package Shortest_Palindrome;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public String shortestPalindrome(String s) {
        if(s.length()<=1) return s;
        for(int i=s.length()-1;i>=0;i--){
        	if(isPalindrome(s,0,i)){
        		if(i==s.length()-1) return s;
        		return new StringBuilder(s.substring(i+1)).reverse().toString()+s;
        	}
        }
        throw new IllegalArgumentException();
    }
    
    private boolean isPalindrome(String s,int left,int right){
    	while(left<right){
    		if(s.charAt(left)==s.charAt(right)){
    			left++;
    			right--;
    		}else{
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String args[]){
    	Scanner sc;
    	try {
			sc = new Scanner(new FileInputStream("D:\\Desktop\\test.dat"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Solution so = new Solution();
    	
    }
}
