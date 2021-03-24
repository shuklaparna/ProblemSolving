/* Container with Most Water
https://leetcode.com/problems/container-with-most-water/
TC: O(N); SC: O(1) */

public class MostWater {
    public int maxArea(int[] A) {
        int p1 = 0, p2 = A.length-1;
        int area = 0;
        while(p1 < p2) {
            area = Math.max(area, Math.min(A[p2], A[p1]) * (p2 - p1));
            if(A[p1] < A[p2])
                p1++;
            else
                p2--;
        }
        return area;
    }
}
