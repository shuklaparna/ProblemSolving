/* PowerOfTwo
https://leetcode.com/problems/power-of-two/
TC: O(N) */

class PowerOfTwo {
    public boolean isPowerOfTwo(long n) {
        for(long i = 0; i >= 0; i++) {
            long pow = (long)(Math.pow(2, i));
            if(pow == n) {
                return true;
            }
            if(pow > n) {
                break;
            }
        }
        return false;
        
    }
}