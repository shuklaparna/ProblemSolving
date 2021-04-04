/* PalindromeOneChar
https://www.geeksforgeeks.org/palindrome-by-swapping-only-one-character/
TC: O(N); SC: O(1) */

public class PalindromeOneChar {
    public String solve(String A) {
        char[] charStr = A.toCharArray();
        int len = A.length(), i, flag = 0;
        // counts the number of differences which prevents the string from being palindrome.
        int diffCount = 0;
        // keeps a record of the characters that prevents the string from being palindrome.
        char[][] diff = new char[2][2];
        for (i = 0; i < len / 2; i++) {
            if (charStr[i] != charStr[len - i - 1]) {
                // 3rd differences encountered and its no longer possible to make is palindrome by one swap
                if (diffCount == 2) {
                    flag = 0;
                    break;
                }
                
                // record the different character
                diff[diffCount][0] = charStr[i];
                // store the different characters
                diff[diffCount++][1] = charStr[len - i - 1];
            }
        }
        switch (diffCount) {
            case 0:
                // its already palindrome
                if(len%2 == 0) 
                    flag = 0;
                 else
                    flag = 1;
                 break;
            case 1:
                // only one difference is found
                char midChar = charStr[i];
                // if the middleChar matches either of the difference producing characters, return yes
                if (len % 2 != 0 && (diff[0][0] == midChar || diff[0][1] == midChar))
                    flag = 1;
                else if (len % 2 == 0)
                    flag = 1;
                else
                    flag = 0;
                break;
            case 2:
                // two differences are found
                // if the characters contained in the two sets are same, return yes
                if ((diff[0][0] == diff[1][0] && diff[0][1] == diff[1][1]) || (diff[0][0] == diff[1][1] && diff[0][1] == diff[1][0]))
                flag = 1;
        }
        if(flag == 1)
            return "YES";
        else
            return "NO";
    }
}
