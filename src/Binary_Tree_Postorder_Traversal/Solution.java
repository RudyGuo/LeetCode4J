package Binary_Tree_Postorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	List<Integer> res = new ArrayList<>();
	Stack<TreeNode> stack = new Stack<>();
	public List<Integer> postorderTraversal(TreeNode root) {
		if(root == null) return res;
		stack.push(root);
		while(!stack.isEmpty()){
			stack.push(root.right);
			stack.push(root.left);
		}
		return res;
	}
	
	private void dfs(TreeNode root){
		if(root == null) return;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		res.add(root.val);
	}
}