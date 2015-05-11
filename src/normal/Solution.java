package normal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Solution {
    public int singleNumber(int[] A) {
    	Map<Integer,Integer> map = new HashMap<>();
    	for(int i=0;i<A.length;i++){
    		if(map.containsKey(A[i])){
    			map.put(A[i], map.get(A[i])+1);
    		}else{
    			map.put(A[i], 1);
    		}
    	}
    	Iterator<Integer> it = map.keySet().iterator();
    	while(it.hasNext()){
    		int num = it.next();
    		if(map.get(num)==1) return num;
    	}
    	return -1;
    }
	
	public static void main(String args[]){
		Solution so = new Solution();
		int num[] = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		System.out.println(so.singleNumber(num));
//		System.out.println(Integer.toBinaryString(-1));
		//System.out.println(Integer.valueOf("11111111111111111111111111111111", 2));
	}
}
