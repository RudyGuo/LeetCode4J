package Dungeon_Game;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	int[][] f;
	int[][]	mx;
	int res =1;
	class Node{
		int x,y;
		Node(int x,int y){
			x = this.x;
			y = this.y;
		}
	}
    public int calculateMinimumHP(int[][] dungeon) {
    	int row = dungeon.length;
    	int column = dungeon[0].length;
    	f = new int[row][column];
    	Queue<Node> queue = new LinkedList<>();
    	Queue<Node> rep = new LinkedList<>();
    	queue.offer(new Node(0,0));
    	f[row-1][column-1] = dungeon[row-1][column-1]>0?1:-dungeon[0][0]+1;
    	while(!queue.isEmpty()){
    		while(!queue.isEmpty()){
    			Node node = queue.poll();
    			int x = node.x,y = node.y;
    			if(x-1>=0) rep.offer(new Node(x-1,y));
    			if(y-1>=0) rep.offer(new Node(x,y-1));
    			if(x==row-1&&y==column-1) continue;
    			Integer left = null, up =null;
    			if(x+1<row){
    				up = Math.max(1, -dungeon[x][y]+f[x+1][y]);
    			}
    			if(y+1<column){
    				left = Math.min(1, -dungeon[x][y]+f[x][y+1]);
    			}
    			f[x][y] = Math.min(left, up);
    		}
    		Queue<Node> lin = queue;
    		queue = rep;
    		rep = lin;
    	}
    	return f[0][0];
    }
    
    
    public static void main(String args[]){
    	Solution so= new Solution();
    	int[][] dungeon={{-3},{5}};
		System.out.println(so.calculateMinimumHP(dungeon));
    }
}