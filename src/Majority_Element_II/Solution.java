package Majority_Element_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        Set<Integer> used = new HashSet<>();
        for(int i=0;i<len;i++){
        	if(used.contains(nums[i])) continue;
            map.put(nums[i],map.containsKey(nums[i])?map.get(nums[i])+1:1);
            if(map.get(nums[i])>len/3){
                res.add(nums[i]);
                used.add(nums[i]);
            }
        }
        return res;
    }
}