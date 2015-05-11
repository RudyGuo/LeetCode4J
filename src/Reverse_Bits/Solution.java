package Reverse_Bits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
    	if(n==1) return Integer.MAX_VALUE+1;
 String str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<32-str.length();i++){
        	sb.append("0");
        }
        StringBuilder sbb = new StringBuilder(sb+str);
        sbb.reverse();
//System.out.println(sbb.length());
        long res = Long.valueOf(sbb.toString(), 2);
        return (int)res;
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	System.out.println(so.reverseBits(1));
    }
}
