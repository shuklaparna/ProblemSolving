/*Peak Element
https://leetcode.com/problems/find-peak-element/
Time Complexity: O(logN) */

class PeakElement {
    public int findPeakElement(int[] A) {
        int n = A.length;
        int l, h;
        if(n == 1)
            return A[0];
        if(A[0] >= A[1])
            return A[0];
        if(A[n-1] >= A[n-2])
            return A[n-1];
            
        for(l = 0, h = n-1; l <= h;) {
            int mid = (l + h) / 2;
            if(A[mid-1] < A[mid] && A[mid] > A[mid+1]) {
                return mid;
            }
            else if(A[mid] < A[mid+1]) {
                l = mid + 1;
            }
            else {
                h = mid - 1;
            }
        }
        return 0;
    }
}
        
