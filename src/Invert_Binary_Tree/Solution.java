package Invert_Binary_Tree;

/*Invert a binary tree.

   4
 /   \
 2     7
/ \   / \
1   3 6   9
to
   4
 /   \
 7     2
/ \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can¡¯t invert a binary tree on a whiteboard so fuck off.
*/

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	dfs(root);
    	return root;
    }
    private void dfs(TreeNode root){
    	if(root==null) return;
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    	dfs(root.left);
    	dfs(root.right);
    }
    
    public static void main(String args[]){
    	TreeNode root = new TreeNode(1);
    	TreeNode root1 = new TreeNode(2);
    	TreeNode root2 = new TreeNode(3);
    	root.left = root1;
    	root.right = root2;
    	Solution so= new Solution();
    	so.invertTree(root);
    	System.out.println(root.left.val+" "+root.right.val);
    	
    }
}