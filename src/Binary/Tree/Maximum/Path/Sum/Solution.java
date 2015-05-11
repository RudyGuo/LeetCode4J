package Binary.Tree.Maximum.Path.Sum;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }
    
    private int dfs(TreeNode root){
    	if(root==null) return 0;
    	int left = dfs(root.left);
    	int right =  dfs(root.right);
    	int sum = root.val;
    	if(left>0) sum += left;
    	if(right>0) sum += right;
    	maxPath = Math.max(sum, maxPath);
    	return Math.max(left, right)>0?root.val+Math.max(left, right):root.val;
    }
}
