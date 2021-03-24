/* Sum of Two Integers without using + & - operator
https://leetcode.com/problems/sum-of-two-integers/
TC: O(N) */

class SumAdder {
    public int getSum(int a, int b) {
        int ans = 0, carry = 0;
    
        while(b != 0){
            ans = a ^ b;
            carry = (a & b) << 1;
        
            a = ans;
            b = carry;
        }
    
        return a;
    
    }
}