/* Longest Palindrome Substring
https://leetcode.com/problems/longest-palindromic-substring/
TC: O(N2); SC: O(1); Runtime: 23ms */

public class LongestPalinSub {
    public String longestPalindrome(String A) {
        String substr = "";
        int n = A.length();
        for(int i = 0; i < n; i++) {
            substr = expand(A, i, i, substr);
            substr = expand(A, i, i+1, substr);
        }
        return substr;
    }
    private String expand(String s, int p1, int p2, String substr) {
        while((p1 >= 0 && p2 < s.length()) && (s.charAt(p1) == s.charAt(p2))) {
            p1--;
            p2++;
        }
        if((p2 - p1 - 1) > substr.length()) {
            substr = s.substring(p1+1, p2);
        }
        return substr;
    }
}
