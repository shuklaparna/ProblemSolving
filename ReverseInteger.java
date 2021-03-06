/*Reverse Integer
https://leetcode.com/problems/reverse-integer/
Runtime: 1ms
Time Complexity: O(log(base10)N) */

class ReverseInteger {
    public int reverse(int x) {
        long rnum = 0, f=0;
        if(x < 0) {
            f = 1;
            x *= -1;
        }
        for(int i = x; i > 0; i/=10) {
            rnum = rnum*10 + i%10;
        }
        
        if(f == 1)
            rnum *= -1;
       
        if((rnum <= Math.pow(-2, 31)) || (rnum >= Math.pow(2,31)-1))
            return 0;
       
         return (int)rnum;
    }
}
