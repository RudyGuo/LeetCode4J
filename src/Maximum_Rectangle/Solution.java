package Maximum_Rectangle;

import java.util.Arrays;

public class Solution {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0)	return 0;
		int row = matrix.length;
		int column = matrix[0].length;
		int left[] = new int[column], right[] = new int[column], height[] = new int[column];
		Arrays.fill(right, column-1);
		int res = 0;
		for (int i = 0; i < row; i++) {
			int l = 0, r = column - 1;
			for (int j = 0; j < column; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(left[j], l);
					height[j]++;
				} else {
					l = j+1;
					left[j] =0;
					height[j] = 0;
					right[j] = column - 1;
				}
			}

			for (int j = column - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(r, right[j]);
					res = Math.max(res, height[j] * (right[j] - left[j]+1));
				} else {
					r = j-1;
				}
			}
		}
		return res;
	}
	
	public static void main(String args[]){
		Solution so = new Solution();
		char matrix[][] = {{'0','1'}};
		System.out.println(so.maximalRectangle(matrix));
	}
}