package Longest_Palindromic_Substring;

public class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("@");
        for(int i=0;i<s.length();i++){
        	sb.append("#"+s.charAt(i));
        }
        sb.append("#$");
        int m =1,j =1;
        int maxLen = 0;
        int idx =1;
        int p[]  = new int[sb.length()];
        for(int i=1;i<sb.length()-1;i++){
        	p[i] = Math.min(j-i, p[2*m-i]);
        	while(sb.charAt(i+p[i]+1)==sb.charAt(i-p[i]-1)){
        		p[i]++;
        	}
        	if(i+p[i]>j){
        		m = i;
        		j = i+p[i];
        	}
        	if(p[i]>maxLen){
        		maxLen = p[i];
        		idx = i;
        	}
        }
        String rr = sb.substring(idx-maxLen,idx+maxLen+1);
        StringBuilder res = new StringBuilder();
        for(int i=0;i<rr.length();i++){
        	if(rr.charAt(i)!='#'){
        		res.append(rr.charAt(i));
        	}
        }
        return res.toString();
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	String str = "abac";
    	System.out.println(so.longestPalindrome(str));
    }
}
