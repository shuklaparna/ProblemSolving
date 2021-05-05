/* DeleteOne
https://www.geeksforgeeks.org/remove-an-element-to-maximize-the-gcd-of-the-given-array/
TC: O(NlogM); SC: O(1); */

public class Del1MaxGcd {
    public int gcd(int a, int b) {
        if(a==0) return b;
        return gcd(b%a, a);
    }
    public int solve(int[] A) {
        int n = A.length, ans = 1;
        int[] suf = new int[n];
        int g = 0;
        for(int i=n-1;i>=0;i--) {
            g = gcd(g, A[i]);
            suf[i] = g;
        }
        int curGcd = 0;
        for(int i=0;i<n;i++) {
            if(i!=n-1) {
                ans = Math.max(ans, gcd(suf[i+1], curGcd));
            }
            else {
                ans = Math.max(ans, curGcd);                
            }
            curGcd = gcd(curGcd, A[i]);
        }
        return ans;
    }
}