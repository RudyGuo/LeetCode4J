package Contains_Duplicate;

/*Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
        	if(set.contains(i)){
        		return true;
        	}
        	set.add(i);
        }
        return false;
    }

}
