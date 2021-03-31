/* Amazing Substring
https://www.interviewbit.com/problems/amazing-subarrays/
TC: O(N); SC:O(1) */

public class AmazeSubStr {
    public int solve(String A) {
        long n = A.length();
        long mod = 10003; long count = 0;
        for(int i=0;i<n;i++){
            char c = A.charAt(i);
            if(c=='A' || c=='E' || c=='I' || c=='O' || c=='U' || c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){            
            count = count + n-i;
            }
        }
        return (int)(count % mod);
    }
}
