/*Search Insert Position
https://leetcode.com/problems/search-insert-position/
Time Complexity: O(logN) */

public class SearchInsertPos {
    public int searchInsert(int[] A, int B) {
        int n = A.length;
        int l, h, mid = 0, flag = 0;
        for(l = 0, h = n-1; l <= h;) {
            mid = (l + h) / 2;
            if(A[mid] == B) {
                return mid;
            }
            else if(A[mid] > B) {
                h = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        if(l == 0)
            return 0;
        else
            return l;
    }
}