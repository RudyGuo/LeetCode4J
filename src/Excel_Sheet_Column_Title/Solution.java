package Excel_Sheet_Column_Title;

public class Solution {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			int apd = n % 26;
			char c;
			if (apd == 0) {
				c = 'Z';
				n = n / 26 - 1;
			} else {
				c = (char) (apd + 'A' - 1);
				n = n / 26;
			}
			sb.append(c);
		}
		return sb.reverse().toString();
	}

	public static void main(String args[]) {
		Solution so = new Solution();
		for (int i = 1; i < 100; i++) {
			System.out.println(so.convertToTitle(i));
		}

	}
}
