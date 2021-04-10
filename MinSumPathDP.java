/* CodeX: Revised Min Sum Path (Dynamic Programming)
Problem Description:
Given two integer arrays A and B of size N each, that represent 2 rows of N tiles each.
Assuming 0 based indexing, you can start from the first tile of either row A or B (i.e you can start from A[0] or B[0]) 
and your goal is to reach the last tile of either row (i.e the terminating position must be A[N-1] or B[N-1]).
You are supposed to reach the end of either row A or B through a series of jumps. You can jump from one tile to another tile, 
that is atmost C distance away from your current tile, in either row.
If you are at tile i of either of the 2 rows, in 1 move you can jump to any of the tiles from index i+1 to i+C (both inclusive) 
of any row. Let's call this index j.
Every tile has a cost associated with it, which is added to your total cost if you choose to use that tile. Depending on the 
row you choose to start with, cost of tile A[0] or B[0] is initially added, and then depending on the jumps made, the cost of 
each chosen tile is added.
There is one small problem though, if you jump from a tile in row A to a tile in row B, or vice-versa, an additional cost of D 
is incurred for changing rows (i.e if you jump from A[i] to any element from B[i+1] to B[i+C] or from B[i] to any element 
from A[i+1] to A[i+C]).
If you make the jump in the same array, no extra cost will be incurred (i.e jumping from A[i] to any element 
from A[i+1] to A[i+C] or from B[i] to any element from B[i+1] to B[i+C]).
Find the minimum cost needed to reach from the starting tiles to the ending tiles.
NOTE: As the answer can be very large, return your answer MOD 109+7.

Problem Constraints:
1 <= N <= 106
0 <= A[i] <= 106
0 <= B[i] <= 106
1 <= C <= 106
0 <= D <= 106

Input Format:
First argument given is an integer array A of size N.
Second argument given is an integer array B of size N.
Third argument given is an integer C.
Fourth argument given is an integer D.

Output Format:
Return a single integer denoting the minimum cost to reach from the start to the end of the array through jumps.

Example Input
Input 1:
 A = [1, 2, 3, 4]
 B = [3, 2, 1, 1]
 C = 2
 D = 2
Input 2:
 A = [1, 2, 30, 400]
 B = [30, 200, 1, 1]
 C = 2
 D = 2

Example Output
Output 1:
 5
Output 2:
 5
 
Example Explanation
Explanation 1:
 one of the optimal path is:
 B[0] -> B[2] -> B[3]
 3    +   1   +   1 = 5
Explanation 2:
 Optimal path is:
 A[0] -> B[2] -> B[3]
 1  +   (1 + 2(for changing row)) +  1  = 5. */
 
 public class MinSumPathDP {
    static long mod = 1000000007;
    public int solve(int[] a, int[] b, int k, int D) {
        int n = a.length;
        if (n == 1) {
            return Math.min(a[0], b[0]);
        }
        long p = D;
        ArrayDeque < Integer > minA = new ArrayDeque < > ();
        ArrayDeque < Integer > minB = new ArrayDeque < > ();
        long[][] dp = new long[2][n + 1];
        dp[0][0] = (long) a[0];
        dp[1][0] = (long) b[0];
        minA.addLast(0);
        minB.addLast(0);
        for (int i = 1; i < Math.min(n, k); i += 1) {
            dp[0][i] = Math.min(dp[0][0], dp[1][0] + p) + (long) a[i];
            dp[1][i] = Math.min(dp[0][0] + p, dp[1][0]) + (long) b[i];
            while (minA.size() > 0 && dp[0][i] <= dp[0][minA.peekLast()]) {
                minA.removeLast();
            }
            minA.addLast(i);
            while (minB.size() > 0 && dp[1][i] <= dp[1][minB.peekLast()]) {
                minB.removeLast();
            }
            minB.addLast(i);
        }
        for (int i = k; i < n; i += 1) {
            dp[0][i] = Math.min(dp[0][minA.peekFirst()], dp[1][minB.peekFirst()] + p) + (long) a[i];
            dp[1][i] = Math.min(dp[0][minA.peekFirst()] + p, dp[1][minB.peekFirst()]) + (long) b[i];
            // min a in last k elements
            while (minA.size() > 0 && minA.peekFirst() <= (i - k)) {
                minA.removeFirst();
            }
            while (minA.size() > 0 && dp[0][i] <= dp[0][minA.peekLast()]) {
                minA.removeLast();
            }
            minA.addLast(i);

            // min b in last k elements
            while (minB.size() > 0 && minB.peekFirst() <= (i - k)) {
                minB.removeFirst();
            }
            while (minB.size() > 0 && dp[1][i] <= dp[1][minB.peekLast()]) {
                minB.removeLast();
            }
            minB.addLast(i);
        }
        return (int)(Math.min(dp[0][n - 1], dp[1][n - 1]) % mod);
    }
}