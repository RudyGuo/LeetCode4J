package MiniCodeMarathonDemon2;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int row = sc.nextInt();
			int column = sc.nextInt();
			int[][] matrix = new int [row][column];
 			for(int i=0;i<row;i++){
				for(int j=0;j<column;j++){
					matrix[i][j] = sc.nextInt();
				}
			}
			int val = 2;
			for(int i=0;i<row;i++){
				for(int j=0;j<column;j++){
					if(matrix[i][j]==1){
						dfs(matrix,i,j,val,1);
						val++;
					}
				}
			}
			res = 0;
			help2(matrix,row,column);
			System.out.println(res);
		}
		sc.close();
	}
	
	static int res = 0;
	
	private static void dfs(int[][] matrix,int row,int column,int val,int comp){
		matrix[row][column] = val;
		if(column-1>=0&&matrix[row][column-1]==comp){
			dfs(matrix,row,column-1,val,comp);
		}
		if(row+1<matrix.length&&matrix[row+1][column]==comp){
			dfs(matrix,row+1,column,val,comp);
		}
		if(column+1<matrix[0].length&&matrix[row][column+1]==comp){
			dfs(matrix,row,column+1,val,comp);
		}
		if(row-1>=0&&matrix[row-1][column]==comp){
			dfs(matrix,row-1,column,val,comp);
		}
	}
	
	//是否是要修改的点，且修改之
	private static int help(int[][] matrix,int row,int column){
		Set<Integer> set1 = new HashSet<Integer>();
		for(int i=0;i<row;i++){
			if(matrix[i][column]>1){
				set1.add(matrix[i][column]);
			}
		}
		for(int i=row+1;i<matrix.length;i++){
			if(set1.contains(matrix[i][column])){
				matrix[row][column] = matrix[i][column];
				return matrix[i][column];
			}
		}
		
		Set<Integer> set2 = new HashSet<Integer>();
		for(int i=0;i<column;i++){
			if(matrix[row][i]>1){
				set2.add(matrix[row][i]);
			}
		}
		for(int i=column+1;i<matrix[0].length;i++){
			if(set2.contains(matrix[row][i])){
				matrix[row][column] = matrix[row][i];
				return matrix[row][i];
			}
		}
		return 0;
	}
	
	private static void help2(int [][]matrix,int row,int column){
		for(int i=0;i<row;i++){
			for(int j=0;j<column;j++){
				if(matrix[i][j]==0){
					int comNum = help(matrix,i,j);
					if(comNum!=0){
						res++;
						boolean foo = cotain(comNum,matrix,i,j);
						if(foo){
							help2(matrix,row,column);
							return;
						}
					}
				}
			}
		}
	}
	
	private static boolean cotain(int comNum,int [][]matrix,int row,int column){
		if(row-1>=0&&matrix[row-1][column]!=0&&matrix[row-1][column]!=comNum){
			int comp = matrix[row-1][column];
			dfs( matrix,row-1,column,comNum,comp);
			return true;
		}
		
		if(column-1>=0&&matrix[row][column-1]!=0&&matrix[row][column-1]!=comNum){
			int comp = matrix[row][column-1];
			dfs( matrix,row,column-1,comNum,comp);
			return true;
		}
		if(row+1<matrix.length&&matrix[row+1][column]!=0&&matrix[row+1][column]!=comNum){
			int comp = matrix[row][column-1];
			dfs( matrix,row+1,column,comNum,comp);
			return true;
		}
		if(column+1<matrix[0].length&&matrix[row][column+1]!=0&&matrix[row][column+1]!=comNum){
			int comp = matrix[row][column+1];
			dfs( matrix,row,column+1,comNum,comp);
			return true;
		}
		return false;
	}
}