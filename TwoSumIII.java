/* ScalerEdge: Pairs with given sum II (not necessarily distinct)
Problem Description:
Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of
integers ( A[i], A[j] )such that i != j have sum equal to B.
Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
Input Format:
The first argument given is the integer array A.
The second argument given is integer B.
Output Format:
Return the number of pairs for which sum is equal to B modulo (10^9+7).
Input:
A = [1, 1]
B = 2
Output: 1

TC: O(N); SC: O(1) */

public class TwoSumIII {
    public long solve(int[] A, int B) {
        int P1 = 0, P2 = A.length-1;
        long mod = 1000000007, count = 0;
        while(P1 < P2) {
            long sum  = A[P1] + A[P2];
            if(sum > B) {
                P2--;
            }
            else if(sum < B) {
                P1++;
            }
            else {
                if(A[P1] == A[P2]) {
                    long C = P2 - P1 + 1;
                    count += ((C * (C-1))/2);
                    break;
                }
                else {
                    long c1 = 0;
                    int j = P1;
                    while(A[j] == A[P1]) {
                        c1++;
                        P1++;
                    }
                    j = P2;
                    long c2 = 0;
                    while(A[j] == A[P2]) {
                        c2++;
                        P2--;
                    }
                    count += c1*c2;
                }
            }
        }
        return count % mod;
    }
}
