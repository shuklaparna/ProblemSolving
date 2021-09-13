/* Dice Throw
https://www.geeksforgeeks.org/dice-throw-dp-30/
Problem Description:
Given sum A, number of ways you can get that sum with dice roll[1-6].
As the number of ways can be large return its modulo by 1e9 + 7.

Problem Constraints
1 <= A <= 10 2

Input Format
The first argument is the integer A.

Output Format
Return an integer .

Example Input
Input 1:
A = 3
Input 2:
A = 4

Example Output
Output 1:
4
Output 2:
8

Example Explanation
Explanation 1:
The four possible ways to obtain 3 are: [1, 1, 1], [1, 2], [2, 1] and [3].
Explanation 2:
The eight possible ways to obrain 8 are: [1, 1, 1, 1], [1, 1, 2], [1, 2, 1], [2, 1, 1], [1, 3], [3, 1], [2, 2], [4].
TC: O(N) */

public class DiceThrowDP {
    public int solve(int n) {
            
    	int dp[] = new int[n + 1]; 
    	dp[0] = 1;
    	int mod = 1000000007;
    	for(int i = 1; i <= n; ++i){
    		dp[i] = 0;
    		for(int j = 1; j <= 6; ++j)
    			if(j <= i)
    				dp[i] = (dp[i] + dp[i - j])%mod;
    	
    	}
    	return dp[n];
    }
}