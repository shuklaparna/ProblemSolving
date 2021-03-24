/*Two Sum (Sorted Input)
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
TC: O(N); SC: O(1)*/

class TwoSumII {
    public int[] twoSum(int[] A, int B) {
        int soln[] = {-1, -1};
        int p1 = 0, p2 = A.length - 1;
        while (p1 < p2) {
            int sum  = A[p1] + A[p2];
            if (sum == B){
                soln[0] = p1+1;
                soln[1] = p2+1;
                break;
            }
            else if (sum < B)
                p1++;
            else
                p2--;
        }
        return soln;
    }
}