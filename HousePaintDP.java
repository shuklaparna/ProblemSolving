/* Minimize cost of painting N houses such that adjacent houses have different colors
https://www.geeksforgeeks.org/minimize-cost-of-painting-n-houses-such-that-adjacent-houses-have-different-colors/
https://www.interviewbit.com/problems/paint-house/
O(N) */
public class HousePaintDP {
    public int solve(int[][] A) {
        if(A.length == 0)
            return 0;
 
    /*for(int i = 1; i < A.length; i++){
        A[i][0] += Math.min(A[i-1][1], A[i-1][2]);
        A[i][1] += Math.min(A[i-1][0], A[i-1][2]);
        A[i][2] += Math.min(A[i-1][0], A[i-1][1]);
    }
    return Math.min(Math.min(A[n][0], A[n][1]), A[n][2]);
    */
    int n = A.length;
    int[][] dp = new int[n][3];
    dp[0][0] = A[0][0];
    dp[0][1] = A[0][1];
    dp[0][2] = A[0][2];
 
    for (int i = 1; i < n; i++) {
        dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + A[i][0];
        dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + A[i][1];
        dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + A[i][2];
    }
    return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}
