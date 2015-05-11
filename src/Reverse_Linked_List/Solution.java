package Reverse_Linked_List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode reverseList(ListNode head) {
    	return reverseList(null, head);
    }
    
    private ListNode reverseList(ListNode left,ListNode right){
    	if(right==null) return left;
    	ListNode rnext = right.next;
    	right.next = left;
    	return reverseList(right,rnext);
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	ListNode head = new ListNode(1);
    	ListNode h1= new ListNode(2);
    	ListNode h2= new ListNode(3);
    	head.next = h1;
    	h1.next = h2;
    	ListNode res = so.reverseList(head);
    	while(res!=null){
    		System.out.print(res.val+"->");
    		res = res.next;
    	}
    }
}