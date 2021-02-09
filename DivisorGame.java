/* Question: Divisor Game [ScalerEdge]
Description: Scooby has 3 three integers A, B and C.
Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
You need to tell number of special integers less than or equal to A.
Problem Constraints: 1 <= A, B, C <= 109
Example Input: A = 12; B = 3; C = 2
Example Output: 2
Example Explanation: The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.
TC: O(logN)*/

public class DivisorGame {
    public int solve(int A, int B, int C) {
        int lcm = ((B * C) / gcd(B,C));
        return (A / lcm);
    }
    public int gcd(int B,int C) {
    if(C==0)
        return B;
    return gcd(C, B%C);
    }
}
