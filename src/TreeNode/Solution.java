package TreeNode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public String toString() {
		return "" + this.val;
	}
}

public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        if(root.left == null) return;
        
        TreeNode p = root.left;
        while(p.right!=null) p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }
    
	public static void main(String args[]) {
		Solution so = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		root.left = left1;
		
		so.flatten(root);
		
		System.out.println(root + "" +root.right);
		
	}
}
