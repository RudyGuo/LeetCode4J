package Divide_Two_Integers;

public class Solution {
	public int divide(int dividend, int divisor) {
		long a = dividend > 0 ? dividend : -(long)dividend;
		long b = divisor > 0 ? divisor : -(long)divisor;
		int sgn =(((dividend>0&&divisor>0)||(dividend<0&&divisor<0))?1:-1);
		int res = 0;
		System.out.println(a+ "   "+b);
		while (a >= b) {
			long c = b;
			int i = 1;
			while (a >= c) {
				a -= c;
				if(a>=0){
					res += sgn*(Math.pow(2, i - 1));
				}else{
					break;
				}
				c <<= 1;
				i++;
			}
		}
		return  res;
	}
	
	public static void main(String args[]){
		Solution so = new Solution();
		int a = -2147483648;
		int b = 1;
		
		System.out.println(a/b );
		System.out.println(so.divide(a, b));
	}
}