/*Prime Modulo Inverse
Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
A-1 mod B is also known as modular multiplicative inverse of A under modulo B.
https://www.geeksforgeeks.org/multiplicative-inverse-under-modulo-m/
Time Complexity: O(log M) */

//MySolution
public class ModuloInv {
    public static long solve(int A, int B) {
        long X = power(A, B-2, B);
        return (X);
    }
    public static long power(long a, long b, long M) {
        if(b==0)
            return 1;
        if(b==1)
            return (a % M);
        long X = power(a, b/2, M) % M;
        if(b%2 == 0)
            return ((X*X) % M);
        else
            return ((((X*X) % M)* (a % M)) % M);
    }
}

//ScalerEdgeSolution
public class Solution {
 
    long power(long x, long y, long p) 
    { 
        long res = 1;      // Initialize result 
      
        x = x % p;  // Update x if it is more than or 
                    // equal to p 
      
        while (y > 0) 
        { 
            // If y is odd, multiply x with result 
            if ((y & 1) == (long)1) 
                res = (res*x) % p; 
       
            y = y>>1; 
            x = (x*x) % p; 
        } 
        return res; 
    }    
    
    public int solve(int A, int B) {
        // Modular inverse of A Modulo B = pow(A, B-2, B)
        
        return (int)power(A, B-2, B);
    }
}
