/* Closed Differences
Problem Description:
You are given an integer array A of size N.
Consider any pair i , j, if the difference | A[i] - A[j] | doesn't belongs to A then append the difference value to the array.
Keep on adding the elements untill no new elements can be formed.
Find the size of the final array.
Note: Initially no two elements are equal.

Problem Constraints:
1 <= N <= 100000
1 <= A[i] <= 1e9

Input Format:
Input contains an integer array A

Output Format:
Return an integer denoting the size of the final array.

Example Input: A = [0, 3, 4]
Example Output: 5

Example Explanation: Initially, array A = [0, 3, 4]. Consider two elements 4 , 3 and their difference |4 - 3| = 1. 
1 is not present in the array. Now, the array becomes [0, 3, 4, 1]. Take another pair 1 , 3 and their difference |1 - 3| = 2.
2 is added to the array. Now, no pair exists which gives us a new element. Final array is [0, 3, 4, 1, 2].
So, our answer is 5.
TC: O(n); SC: O(1) */

public class ClosedDiff {
    public int solve(int[] A) {
        int gcd = A[0], max = A[0], flag = 0;
        for(int i = 0; i < A.length; i++) {
            gcd = ggcd(gcd, A[i]);
            max = Math.max(max, A[i]);
            if(A[i] == 0)
                flag = 1;
        }
        if(gcd == 0 || max == 0) {
            return 1;
        }
        else {
            return((max/gcd) + flag);
        }
    }
    int ggcd(int a, int b) {
        if(a == 0)
            return b;
        if(b == 0)
            return a;
        return ggcd(b, a % b);
    }
}
