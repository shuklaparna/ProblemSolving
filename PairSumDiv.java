/*PairSumDivisibility
https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/submissions/
TC: O(A+B); SC: O(B) */

public class PairSumDiv {
    public long solve(int[] A, int B) {
        long mod = 1000000007;
        int n = A.length;
        long freq[] = new long[B];
        for(int i=0; i<B; i++)
            freq[i] = 0;
        for(int i = 0; i < n; i++){
            ++freq[A[i] % B];
        }
        long sum = freq[0] * (freq[0] - 1) / 2;
        for (int i = 1; i <= B / 2 && i != (B - i); i++){
         sum += freq[i] * freq[B-i];
        }
        if(B % 2 == 0)
            sum += (freq[B / 2] * (freq[B / 2] - 1) / 2);
        return (sum % mod);
    }
}