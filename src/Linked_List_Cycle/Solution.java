package Linked_List_Cycle;

import java.util.HashSet;
import java.util.Set;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode detectCycle(ListNode head) {
		if(head==null) return null;
		ListNode slow2 = head;
		ListNode slow = head;
		ListNode fast = head;
		boolean isCycle = false;
		while(fast!=null&&fast.next!=null){
			if(slow ==fast) {
				isCycle =  true;
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		if(isCycle){
			while(slow2!=slow){
				slow = slow.next;
				slow2 = slow2.next;
			}
			return slow;
		}else{
			return null;
		}
	}
}