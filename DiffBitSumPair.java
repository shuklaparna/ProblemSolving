/* Different Bits Sum Pairwise
https://www.interviewbit.com/problems/different-bits-sum-pairwise/
O(N) */

public class DiffBitSumPair {
    final int M = (int) 1e9+7;
    public int cntBits(int[] A) {
        long sum = 0;
        for(int i = 31; i >= 0; i--) {
            long count = 0;
            for(int j = 0; j < A.length; j++){
                if((A[j] & (1<<i)) == 0) {
                    count++;
                }
            }
            sum = (sum + 2L*count*(A.length-count)) % M;
            sum  = sum % M;
        }
        return (int)(sum % M);
    }
}
