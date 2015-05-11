package Rotate_Array;

public class Solution {
    public void rotate(int[] nums, int k) {
        int cp[] = new int[nums.length];
        for(int i=0;i<cp.length;i++){
        	cp[i+k>=cp.length?(i+k)%cp.length:i+k] = nums[i];
        }
        for(int i=0;i<cp.length;i++){
        	nums[i] = cp[i];
        }
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    }
}
