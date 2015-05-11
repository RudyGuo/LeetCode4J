package Binary_Tree_Preorder_Traversal;

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
	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null) return new ArrayList<Integer>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode tn = stack.pop();
			res.add(tn.val);
			if(tn.right!=null){
				stack.push(tn.right);
			}
			if(tn.left!=null){
				stack.push(tn.left);
			}
		}
		return res;
	}
}