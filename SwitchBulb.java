/* CodeX: Switch on the Bulbs (Math)
Problem Description:
You are given a circuit of A bulbs, numbered 1 to A, and A - 1 switches, numbered 1 to A - 1.
Initially, all the switches and bulbs are switched off. Now, a bulb can be switched On by the i or the i - 1 switch. 
The bulb will be switched On if any of the switch is On.
Now, you wrote all the switch numbers from 1 to A - 1 and permuted them and then switched on the switches in the order 
received in the permutation.
The efficiency of a permutation is measured by the number of switches that have to be turned on before all of the bulbs are 
switched on.
Find the sum of efficiencies of all possible permutations modulo 109 + 7.

Problem Constraints:
2 <= A <= 106

Input Format:
The first and the only argument of input contains the integer A.

Output Format:
Return an integer representing the the sum of efficiencies of all possible permutations.

Example Input:
Input 1:
 A = 3 
Input 2:
 A = 4 

Example Output:
Output 1:
 4 
Output 2:
 16 

Example Explanation:
Explanation 1:
 Permutation : Efficiency
 [1, 2]      : 2
 [2, 1]      : 2
 Sum of all efficiencies = 2 + 2 = 4. 
Explanation 2:
 Permutation : Efficiency
 [1, 2, 3]   : 3
 [1, 3, 2]   : 2
 [2, 1, 3]   : 3
 [2, 3, 1]   : 3
 [3, 1, 2]   : 2
 [3, 2, 1]   : 3
 Sum of all efficiencies = 3 + 2 + 3 + 3 + 2 + 3 = 16. */
 
 public class SwitchBulb {
    static long MAXN = 1000000 + 10;
    static long MOD = 1000000000 + 7;
    static long[] fact = new long[(int) MAXN];
    static long[] inv = new long[(int) MAXN];
    static int flag = 1;
    public static long binpow(long a, long b, long mod) {
        long ans = 1;
        while (b > 0) {
            if (b % 2 != 0)
                ans = (ans * a) % mod;
            a = (a * a) % mod;
            b /= 2;
        }
        return ans;
    }

    public static void precompute() {
        fact[0] = 1;
        flag = 0;
        for (int i = 1; i < MAXN; i++) {
            fact[i] = ((long) i * fact[i - 1]) % MOD;
        }

        for (int i = 0; i < MAXN; i++)
            inv[i] = binpow(fact[i], MOD - 2, MOD);
    }

    public static long combi(int n, int r) {
        if (r > n)
            return 0;
        long ret = fact[n];
        ret = (ret * inv[r]) % MOD;
        ret = (ret * inv[n - r]) % MOD;
        return ret;
    }

    public int solve(int A) {
        if (flag == 1)
            precompute();
        ArrayList < Long > ans = new ArrayList < > ();
        ans.add((long) 0);
        for (int i = 1; i < A; i++) {
            ans.add(((combi(i - 1, A - i - 1) * fact[i]) % MOD * fact[A - i - 1]) % MOD);
        }
        long ret = 0;
        for (int i = 1; i < A; i++)
            ret = (ret + ((long) i * (ans.get(i) - ans.get(i - 1) + MOD) % MOD)) % MOD;
        return (int) ret;
    }
}