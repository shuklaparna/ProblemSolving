/*Peak Element
https://leetcode.com/problems/single-element-in-a-sorted-array/
Time Complexity: O(logN) */

class SingleEle {
    public int singleNonDuplicate(int[] A) {
        int n = A.length;
        int l, h;
        if(n == 1)
            return A[0];
        if(A[0] != A[1])
            return A[0];
        if(A[n-1] != A[n-2])
            return A[n-1];
            
        for(l = 0, h = n-1; l <= h;) {
            int mid = (l + h) / 2;
            if(A[mid-1]!= A[mid] && A[mid] != A[mid+1]) {
                return A[mid];
            }
            if(A[mid] == A[mid-1]) {
                mid = mid - 1;
            }
            if(mid%2 == 0) {
                l = mid + 2;
            }
            else {
                h = mid - 1;
            }
        }
        return 0;
    }
}