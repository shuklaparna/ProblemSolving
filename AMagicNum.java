/* Ath Magical Number
Problem Description:
Given three positive integers A, B and C.
Any positive integer is magical if it is divisible by either B or C.
Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.

Problem Constraints:
1 <= A <= 109
2 <= B, C <= 40000

Input Format:
The first argument given is an integer A.
The second argument given is an integer B.
The third argument given is an integer C.

Output Format:
Return the Ath magical number. Since the answer may be very large, return it modulo 109 + 7.

Example Input:-
Input 1:
 A = 1
 B = 2
 C = 3
Input 2:
 A = 4
 B = 2
 C = 3

Example Output:-
Output 1:
 2
Output 2:
 6

Example Explanation:-
Explanation 1:
 1st magical number is 2.
Explanation 2:
 First four magical numbers are 2, 3, 4, 6 so the 4th magical
TC: O(N); SC: O(1) */

public class AMagicNum {
    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    public int solve(int A, int B, int C) {
        long lcm = (1L*B*C)/gcd(B,C);
        long l = 2, h = (long)(1e18), m, ans = 2;
        long mod=1000000007;
        while(l <= h) {
            //m = (l+r)>>1;
			m = (h - l) / 2 + l;
            long temp = m/B + m/C - m/lcm;
            if(temp >= A){
                ans = m;
                h = m - 1;
            }
            else
                l = m + 1;
        }
        return (int)(ans%mod);
    }
}