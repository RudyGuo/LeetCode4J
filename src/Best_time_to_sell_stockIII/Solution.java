package Best_time_to_sell_stockIII;

public class Solution {
    public int maxProfit(int[] prices) {
    	if(prices.length<2) return 0;
    	int []left =new int[prices.length];
    	int []right = new int[prices.length];
        int minVal = prices[0];
        for(int i=1;i<prices.length;i++){
        	minVal = Math.min(minVal, prices[i]);
        	left[i] = Math.max(left[i-1], prices[i]-minVal);
        }
        int maxVal = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
        	maxVal = Math.max(maxVal, prices[i]);
        	right[i] = Math.max(right[i+1], maxVal -prices[i]);
        }
        int res =  left[0]+right[0];
        for(int i=1;i<prices.length;i++){
        	res = Math.max(res, left[i]+right[i]);
        }
        return res;
    }
}
