package Wildcard_Matching;

public class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        if(len1==0&&len2==0){ 
        	return true;
        }else if(len1 == 0||len2 == 0){
        	return false;
        }
        boolean f[][] = new boolean[len1][len2];
        if(p.charAt(0)=='*'){
        	for(int i=0;i<len1;i++){
        		f[i][0] = true;
        	}
        }else if(p.charAt(0)=='?'||p.charAt(0)==s.charAt(0)){
        	f[0][0] = true;
        }else{
        	return false;
        }
        for(int j=1;j<len2;j++){
        	if(p.charAt(j)=='*'){
				while (j<len2&&p.charAt(j) == '*') {
					j++;
				}
				j--;
        	}
        	boolean flag = false;
        	for(int i=1;i<len1;i++){
        		if(p.charAt(j)=='*'&&f[i-1][j-1]){
        			f[i][j] = true;
        			flag = true;
        		}else{
        			if(p.charAt(j)=='?'&&f[i-1][j-1]){
        				f[i][j] = true;
        				flag = true;
        			}else if(p.charAt(j)==s.charAt(i)&&f[i-1][j-1]){
        				f[i][j] = true;
        				flag = true;
        			}
        			if(p.charAt(j-1)!='*') break;
        		}
        	}
        	if(!flag) return false;
        }
        return f[len1-1][len2-1];
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	String s = "ab";
    	String p = "?*";
    	System.out.println(so.isMatch(s, p));
    }
}
