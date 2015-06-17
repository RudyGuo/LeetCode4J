package Contains_Duplicate_III;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*Given an array of integers, find out whether there are two distinct
 *  indices i and j in the array such that the difference between nums[i] and nums[j] is
 *   at most t and the difference between i and j is at most k.
 */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
        	if(map.size()<2*t+1){
        		Iterator<Integer> it = map.keySet().iterator();
        		while(it.hasNext()){
        			int nn = it.next();
        			if(Math.abs(nn-nums[i])<=t&&Math.abs(map.get(nn)-i)<=k){
        				return true;
        			}
        		}
        	}else{
				for (int n = nums[i] - t; n <= nums[i] + t; n++) {
					if (map.containsKey(n)) {
						if (i - map.get(n) <= k)
							return true;
					}
				}
        	}

        	map.put(nums[i], i);
        }
        return false;
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	int[] nums = {0,2147483647};
    	System.out.println(so.containsNearbyAlmostDuplicate(nums, 1, 2147483647));

    }
}
