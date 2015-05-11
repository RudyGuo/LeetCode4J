package Binary_Search_Tree_Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

public class BSTIterator {
	List<TreeNode> list = new ArrayList<>();
	int len;
	int index = 0;
    public BSTIterator(TreeNode root) {
        inorderTraversal(root);
        len = list.size();
    }
    
    private void inorderTraversal(TreeNode root){
    	if(root==null) return;
    	inorderTraversal(root.left);
    	list.add(root);
    	inorderTraversal(root.right);
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index<len;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++).val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
