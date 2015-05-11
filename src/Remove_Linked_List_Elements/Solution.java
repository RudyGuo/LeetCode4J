package Remove_Linked_List_Elements;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode dummy = new ListNode(-1);
		ListNode pre = dummy;
		ListNode cur = head;
		dummy.next = head;
		while (cur != null) {
			if (cur.val == val) {
				pre.next = cur.next;
				cur.next = null;
				cur = pre.next;
			}else{
				pre = pre.next;
				cur = cur.next;
			}
			
		}
		return dummy.next;
	}
}
