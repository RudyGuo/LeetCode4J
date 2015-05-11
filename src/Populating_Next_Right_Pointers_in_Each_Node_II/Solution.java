package Populating_Next_Right_Pointers_in_Each_Node_II;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class Solution {
	Queue<TreeLinkNode> que = new LinkedList<>();
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		que.offer(root);
		while (!que.isEmpty()) {
			TreeLinkNode tln = que.poll();
			if (tln.left != null) {
				que.offer(tln.left);
				tln.left.next = dfs2(tln);
			}
			if (tln.right != null) {
				que.offer(tln.right);
				tln.right.next = dfs3(tln.next);
			}
		}
	}
	
	private TreeLinkNode dfs2(TreeLinkNode root){
		if(root == null) return null;
		if(root.right!=null) return root.right;
		if(root.next!=null&&root.next.left!=null){
			return root.next.left;
		}
		return dfs2(root.next);
	}
	
	private TreeLinkNode dfs3(TreeLinkNode root){
		if(root ==null) {
			return null;
		}else{
			if(root.left!=null) return root.left;
			if(root.right!=null)return root.right;
		}
		return dfs3(root.next);
	}
	
	public static void main(String args[]){
		Solution so = new Solution();
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		t1.right = t2;
		so.connect(t1);
	}
	
}