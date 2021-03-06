import java.util.ArrayList;
import java.util.List;

public class Solution {
	boolean f[][];
	int res = Integer.MAX_VALUE;
	int h[];
	public int minCut(String s) {
		f = new boolean[s.length()][s.length()];
		for (int i = 0; i < s.length(); i++) {
			f[i][i] = true;
		}
		int maxLen = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				f[i][i + 1] = true;
				maxLen = 2;
			}
		}
		for (int len = 3; len <= s.length(); len++) {
			boolean in = false;
			for (int i = 0; i < s.length() - len + 1; i++) {
				if (s.charAt(i) == s.charAt(i + len - 1)
						&& f[i + 1][i + len - 2]) {
					f[i][i + len - 1] = true;
					in = true;
				}
			}
			if (in) {
				maxLen = len;
			}
		}
		if (maxLen == s.length())
			return 0;
		h = new int[s.length()+1];
		h[0] = -1;
		for(int i=1;i<=s.length();i++){
			h[i] = Integer.MAX_VALUE;
			for(int j=1;j<=i;j++){
				if(f[j-1][i-1]&&h[j-1]!=Integer.MAX_VALUE){
					h[i] = Math.min(h[i], h[j-1]+1);
				}
			}
		}
		return h[s.length()];
	}
	

	public static void main(String args[]) {
		Solution so = new Solution();
		String s = "cbbb";
		System.out.println(so.minCut(s));
	}
}