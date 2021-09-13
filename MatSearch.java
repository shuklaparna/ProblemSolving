/* Matrix Search
https://www.interviewbit.com/problems/matrix-search/
https://leetcode.com/problems/search-a-2d-matrix/
O(log(rc)) = O(log(r) + log(c)) ;; O(1) */

public class MatSearch {
    public int searchMatrix(int[][] a, int b) {
        int r=a.length;
        int i,j;
        for(i=0;i<r;i++){
            if(a[i][a[i].length-1]>=b) break;
        }
        if(i==r) return 0;
        for(j=0;j<a[i].length;j++){
            if(a[i][j]==b) return 1;
        }
        return 0;
    }
}
