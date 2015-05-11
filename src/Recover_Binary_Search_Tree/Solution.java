package Recover_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
	List<TreeNode> list = new ArrayList<>();
    public void recoverTree(TreeNode root) {
    	mid(root);
    	int left = -1;
    	int right = -1;
    	for(int i=0;i<list.size()-1;i++){
    		if(list.get(i).val>list.get(i+1).val){
    			left = i;
    			break;
    		}
    	}
    	for(int j=list.size()-1;j>0;j--){
    		if(list.get(j).val<list.get(j-1).val){
    			right = j;
    			break;
    		}
    	}
    	if(left == -1||right == -1){ 
    		throw new IllegalArgumentException("ÎÞ·¨»Ö¸´ËÑË÷¶þ²æÊ÷");
    	}
    	int temp = list.get(left).val;
    	list.get(left).val = list.get(right).val;
    	list.get(right).val = temp;
    }
    
    private void mid (TreeNode root){
    	if(root==null) return;
    	mid(root.left);
    	list.add(root);
    	mid(root.right);
    }
}