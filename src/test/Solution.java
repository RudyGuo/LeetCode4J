package test;

public class Solution {
	public int climb(int n){
		int prev = 0;
		int cur = 1;
		for(int i=1;i<=n;i++){
			int temp = cur;
			cur += prev;
			prev = temp;
		}
		return cur;
	}
	
	public static void main(String args[]){
		Solution so = new Solution();
		double d = 0.12;
		System.out.println(Double.toString(d));
	}
}
