/*  K-diff Pairs in an Array
https://leetcode.com/problems/k-diff-pairs-in-an-array/
Runtime: 3ms; TC: O(N); SC: O(1) */

class DiffK {
    public int findPairs(int[] A, int B) {
        Arrays.sort(A);
        int p1 = 0, p2 = 1, count = 0;
        B = Math.abs(B);
        while(p2 < A.length && p1 < A.length) {
            if(p1 == p2) {
                    p2++;
                    continue;
                }
            if (p1 > 0 && A[p1] == A[p1 - 1]) {
                p1++;
                continue;
            }
            
            int val = A[p2] - A[p1];
            if(val > B) {
                p1++;
            }
            else if(val < B) {
                p2++;
            }
            else {
                count++;
                p2++;
                p1++;
            }
        }
        return count;
        
    }
}