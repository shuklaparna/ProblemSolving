/* Palindrome Number
https://leetcode.com/problems/palindrome-number/
Runtime: 7 ms
Time Complexity: O(N) */
class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int l = s.length();
        int f = 0, i, j; 
        for(i = 0, j = l-1; i < l/2; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                f = 1;
                break;
            }
            
        }
        if(f == 1)
            return false;
        else
            return true;
        
    }
}
