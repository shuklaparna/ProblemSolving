/* n-th element in a series with only 2 digits
https://www.geeksforgeeks.org/find-n-th-element-series-2-digits-4-7-allowed-set-2-logn-method/
TC: O(logN); SC: O(1) */

public class Num2digLogN {
	static String findNthNo(int n){
		String res = "";
		while (n >= 1) {
			// If n is odd, append 4 and move to parent
			if ((n & 1) == 1){
				res = res + "4";
				n = (n - 1) / 2;	
			}
			// If n is even, append 7 and move to parent
			else {
				res = res + "7";
				n = (n - 2) / 2;	
			}
		}
		// Reverse res and return.
		StringBuilder sb = new StringBuilder(res);
		sb.reverse();
		return new String(sb);
	}
	public static void main(String args[]) {
		int n = 13;
		System.out.print( findNthNo(n) );
	}
}