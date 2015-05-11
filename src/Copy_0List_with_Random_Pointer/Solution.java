package Copy_0List_with_Random_Pointer;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class Solution {
	Map<RandomListNode,RandomListNode> map = new HashMap<>();
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode scan = head;
		RandomListNode res = new RandomListNode(0);
		RandomListNode dummy = res;
		while(scan!=null){
			RandomListNode rln = new RandomListNode(scan.label);
			map.put(scan, rln);
			dummy.next = rln;
			scan = scan.next;
			dummy = dummy.next;
			
		}
		
		RandomListNode scan2 = head;
		RandomListNode dummy2 = res.next;
		while(scan2!=null){
			if(scan2.random==null){
				dummy2.random = null;
			}else{
				dummy2.random = map.get(scan2.random);
			}
			dummy2 = dummy2.next;
			scan2 = scan2.next;
		}
		return res.next;
	}
	
	
}
