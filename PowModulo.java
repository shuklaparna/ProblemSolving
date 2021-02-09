/* PowerModuloFuntion [pow(x, n) % d]
https://www.interviewbit.com/problems/implement-power-function/
TC: O(logN) */

public class PowModulo {
    public long pow(int A, int B, int C) {
        long res = 0;
        if(A == 0) 
            return 0;
        if(B == 0)
            return 1;
        if(B== 1)
            res = (A % C);
        res = (pow(A, B/2, C));
        if(B % 2 == 1)
            res = (((res * res) % C) *A) % C;
        else 
            res = ((res % C) * (res % C)) % C;
        if(res < 0) 
            return Math.abs((res + C) % C);
        return Math.abs(res % C);
    }
}
