package Number_of_Islands;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	class Pair{
		int x,y;
		Pair(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	
    public int numIslands(char[][] grid) {
    	if(grid==null||grid.length==0) return 0;
    	int row = grid.length,column = grid[0].length;
    	int res = 0;
        for(int i=0;i<row;i++){
        	for(int j=0;j<column;j++){
        		if(grid[i][j]=='1'){
        			bfs(grid, i, j);
        			res++;
        		}
        	}
        }
        return res;
    }
    
    private void bfs(char[][]grid,int i,int j){
    	Queue<Pair> que = new LinkedList<>();
    	que.offer(new Pair(i,j));
    	while(!que.isEmpty()){
    		Pair p= que.poll();
    		grid[p.x][p.y] = '*';
    		if(isIsland(grid, p.x-1, p.y)){
    			//非常重要，防止同层之间互相加
    			grid[p.x-1][p.y] ='*';
    			que.offer(new Pair(p.x-1,p.y));
    		}
    		if(isIsland(grid, p.x+1, p.y)){
    			grid[p.x+1][p.y] ='*';
    			que.offer(new Pair(p.x+1,p.y));
    		}
    		if(isIsland(grid, p.x, p.y-1)){
    			grid[p.x][p.y-1] ='*';
    			que.offer(new Pair(p.x,p.y-1));
    		}
    		if(isIsland(grid, p.x, p.y+1)){
    			grid[p.x][p.y+1] ='*';
    			que.offer(new Pair(p.x,p.y+1));
    		}
    	}
    }
    
    private void dfs(char[][]grid,int i,int j){
    	grid[i][j] = '*';
    	if(isIsland(grid, i-1, j)) dfs(grid,i-1,j);
    	if(isIsland(grid, i+1, j)) dfs(grid,i+1,j);
    	if(isIsland(grid, i, j-1)) dfs(grid,i,j-1);
    	if(isIsland(grid, i, j+1)) dfs(grid,i,j+1);
    }
    
    private boolean isIsland(char[][]grid,int i,int j){
    	if(i<0||i>=grid.length||j<0||j>=grid[0].length) return false;
    	if(grid[i][j]=='1') return true;
    	return false;
    }
    
    public static void main(String args[]){
    	Solution so = new Solution();
    	String str[] = {"11111011111111101011","01111111111110111110","10111001101111111111","11110111111111111111","10011111111111111111","10111111011101110111","01111111111101101111","11111111111101111011","11111111110111111111","11111111111111111111","01111111011111111111","11111111111111111111","11111111111111111111","11111011111110111111","10111110111011110111","11111111111101111110","11111111111110111100","11111111111111111111","11111111111111111111","11111111111111111111"};
    	char grid[][] = new char[str.length][str[0].length()];
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			grid[i][j] = str[i].charAt(j);
    		}
    	}
    	System.out.println(so.numIslands(grid));
    }
}
