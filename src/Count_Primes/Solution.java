package Count_Primes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Integer> prime = new ArrayList<>();
    public int countPrimes(int n) {
        int res = 0;
        for(int i=2;i<n;i++){
        	if(isPrime(i)) res++;
        }
        return res;
    }
    
    private boolean isPrime(int n){
    	int m = (int) Math.sqrt(n);
    	if(n==1) return false;
    	for(int itt:prime){
    		if(itt>m) break;
    		if(n%itt==0) return false;
    	}
    	prime.add(n);
    	return true;
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	System.out.println(so.countPrimes(10000000));
    }
}
