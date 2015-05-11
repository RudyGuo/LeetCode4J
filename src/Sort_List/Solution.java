package Sort_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class Solution {
    public ListNode sortList(ListNode head) {
    	if(head==null||head.next==null) return head;
    	ListNode fast = head,slow = head;
    	while(fast!=null&&fast.next!=null&&fast.next.next!=null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	fast = slow;
    	slow = slow.next;
    	fast.next = null;
    	ListNode left = sortList(head);
    	ListNode right = sortList(slow);
    	return merge(left,right);
    }
    
    
    private ListNode merge(ListNode left,ListNode right){
    	ListNode dummy = new ListNode(-1);
    	ListNode sc = dummy;
    	while(left!=null&&right!=null){
    		if(left.val<right.val){
    			sc.next = left;
    			left = left.next;
    		}else{
    			sc.next = right;
    			right = right.next;
    		}
    		sc = sc.next;
    	}
    	if(left!=null){
    		sc.next = left; 
    	}else{
    		sc.next = right;
    	}
    	return dummy.next;
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	ListNode head = new ListNode(3);
    	ListNode tail = new ListNode(2);
    	ListNode t = new ListNode(1);
    	head.next = tail;
    	tail.next = t;
    	ListNode res = so.sortList(head);
    	while(res!=null){
    		System.out.print(res.val+"->");
    		res = res.next;
    	}
    	
    	
    }
}