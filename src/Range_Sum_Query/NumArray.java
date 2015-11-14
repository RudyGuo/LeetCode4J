package Range_Sum_Query;

public class NumArray {

	int sums[];
    public NumArray(int[] nums) {
    	if(nums==null||nums.length==0)return;
    	sums= new int[nums.length];
    	sums[0] = nums[0];
        for(int i=1;i<nums.length;i++){
        	sums[i] = sums[i-1]+nums[i];
        }
        
    }

    public int sumRange(int i, int j) {
    	if(sums==null) return 0;
        int left = i-1;
        int right = j;
        if(left==-1) return sums[right];
        return sums[right]-sums[left];
    }
    
    public static void main(String args[]){
    	int []nums = {-2, 0, 3, -5, 2, -1};
    	 NumArray numArray = new NumArray(nums);
    	 System.out.println(numArray.sumRange(0, 2));
    	 System.out.println(numArray.sumRange(2, 5));
    	 System.out.println(numArray.sumRange(0, 5));
    }
}

