package Surrounded_Regions;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	boolean f[][];
	boolean path = true;
    public void solve(char[][] board) {
        f = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='O'&&!f[i][j]){
        			path = true;
        			dfs(board,i,j);
        		}
        	}
        }
    }
    
    private void dfs(char[][] board,int i,int j){
    	f[i][j] = true;
    	if(i==0||j==0||i==board.length-1||j==board[0].length){
    		path = false;
    	}
    	if(i-1>0&&board[i-1][j]=='O'&&f[i-1][j]==false) dfs(board,i-1,j);
    	if(i+1<board.length&&board[i+1][j]=='O'&&f[i+1][j]==false) dfs(board,i+1,j);
    	if(j-1>0&&board[i][j-1]=='O'&&f[i][j-1]==false) dfs(board,i,j-1);
    	if(j+1<board[0].length&&board[i-1][j]=='O'&&f[i][j+1]==false) dfs(board,i,j+1);
    	if(path){
    		change(board,i,j,'X');
    	}
    }
    
    private void change(char[][]board,int i,int j,char c){
    	board[i][j] = c;
    	if(i-1>0&&board[i-1][j]=='O') dfs(board,i-1,j);
    	if(i+1<board.length&&board[i+1][j]=='O') dfs(board,i+1,j);
    	if(j-1>0&&board[i][j-1]=='O') dfs(board,i,j-1);
    	if(j+1<board[0].length&&board[i-1][j]=='O') dfs(board,i,j+1);
    }
    
    
    public static void main(String args[]){
    	List<Integer> list = new ArrayList<Integer>();
    }
}
