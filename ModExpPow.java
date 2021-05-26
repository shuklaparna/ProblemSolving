/* Modular Expression - Backtracking
https://www.geeksforgeeks.org/modular-exponentiation-recursive/
https://www.interviewbit.com/problems/modular-expression/
TC: O(logB); SC: O(1) */

public class ModExpPow {
	public int Mod(int a, int b, int c) {
	    if (a == 0)
	        return 0;
	        
        int res = (int)powMod(a, b, c);
        
        return (res + c) % c;
	}
	
	private long powMod(int a, int b, int c) {
	    if (b == 0)
	        return 1;
	        
	    if (b % 2 == 0) {
	        long res = powMod(a, b / 2, c) % c;
	        
	        return (res * res) % c;
	    } else {
	        long res = powMod(a, b - 1, c) % c;
	        return ((a % c) * res % c);
	    }
	}
}