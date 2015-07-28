package Summary_Ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/*Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

*/
public class Solution {
    public List<String> summaryRanges(int[] nums) {
    	List<String> res = new ArrayList<>();
    	int i=0;

        while(i<nums.length){
        	int start = i;
        	String str = nums[i]+"";
        	while(i+1<nums.length&&nums[i]+1==nums[i+1])i++;
        	if(start==i){
        		res.add(str);
        	}else{
        		res.add(str+"->"+nums[i]);
        	}
        	i++;
        }
        return res;
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	int nums[] = {0,1,2,4,5,7};
    	List<String> res =so.summaryRanges(nums);
    	for(String str:res){
    		System.out.println(str);
    	}
    	
    }
}