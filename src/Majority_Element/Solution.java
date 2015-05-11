package Majority_Element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] num) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<num.length;i++){
        	if(!map.containsKey(num[i])){
        		map.put(num[i], 1);
        	}else{
        		map.put(num[i], map.get(num[i])+1);
        	}
        }
        
        Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext()){
        	int val = it.next();
        	if(map.get(val)>num.length/2){
        		return val;
        	}
        }
        return -1;
    }
}
