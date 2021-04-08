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

//Another Solution
public class Solution {
    public int solve(String str) {
        int count = 0;
        Character[] v = {'a', 'e', 'i', 'o', 'u'};
        Set<Character> vowel = new HashSet<>(Arrays.asList(v));

        //ABEC
        for (int i = 0; i < str.length(); i++) {
            Character ch = Character.toLowerCase(str.charAt(i));
            if (vowel.contains(ch)) {
                count += str.length() - i;
                if (count > 10003) {
                    count %= 10003;
                }
            }
        }
        return count;
    }
}
