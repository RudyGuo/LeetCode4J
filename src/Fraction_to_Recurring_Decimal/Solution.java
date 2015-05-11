package Fraction_to_Recurring_Decimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	class Pair{
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ans;
			result = prime * result + mod;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (ans != other.ans)
				return false;
			if (mod != other.mod)
				return false;
			return true;
		}
		int mod;
		int ans;
		Pair(int mod,int ans){
			this.mod = mod;
			this.ans = ans;
		}
		private Solution getOuterType() {
			return Solution.this;
		}
	}
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        int ans = numerator/denominator;
        int mod = numerator%denominator;
        if(mod == 0) return ans+"";
        StringBuilder sb = new StringBuilder();
        sb.append(ans+".");
        Map<Pair,Integer> map = new HashMap<>();
        while(mod!=0){
        	ans = (10*mod)/denominator;
        	mod = (10*mod)%denominator;
        	Pair p = new Pair(mod,ans);
        	if(map.containsKey(p)){
        		sb.insert(map.get(p)-1, "(");
        		sb.append(")");
        		break;
        	}else if(mod == 0){
        		sb.append(ans);
        		break;
        	}
        	sb.append(ans);
        	map.put(p, sb.length());
        }
        return sb.toString();
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	System.out.println(so.fractionToDecimal(1, 6));
    }
}