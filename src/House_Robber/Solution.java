package House_Robber;

public class Solution {
    public int rob(int[] num) {
       if(num==null||num.length==0) return 0;
       int include = 0;
       int exclude = 0;
       for(int i=0;i<num.length;i++){
    	   int tmp = include;
    	   include = exclude+num[i];
    	   exclude = Math.max(tmp, exclude);
       }
       return Math.max(include, exclude);
    }
}
