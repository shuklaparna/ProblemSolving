/* Square Root of an Integer
https://www.interviewbit.com/problems/square-root-of-integer/
https://leetcode.com/problems/sqrtx/
TC: O(log(n)); SC: O(1) */

class SqRoot {
    public int mySqrt(int A) {
          int low = 1, high = A, root = 0;
      while (low <= high) {
         int mid = (low + high) / 2;
         if (mid == A / mid && (A % mid == 0))
            return mid;
         if (mid <= A / mid) {
            root = mid;
            low = mid + 1;
         } else {
            high = mid - 1;
         }
      }
      return root;
    }
}