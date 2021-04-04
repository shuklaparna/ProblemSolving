/* Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/
TC: O(NM log M) where, N = Number of strings, M = Length of the largest string
SC: O(M) */

public class CommonLongestPrefix {
    public String longestCommonPrefix(String[] A) {
        int n = A.length;
        if(n == 0) {
            return "";
        }
        int index = findMinLength(A, n);
        String prefix = ""; 
        int low = 0, high = index-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
  
            if (ContainsPrefix(A, n, A[0], low, mid)) {
                prefix = prefix + A[0].substring(low, mid + 1);
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }
        return prefix;
    }
    private int findMinLength(String arr[], int n) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
            }
        }
        return min;
    }
    private boolean ContainsPrefix(String arr[], int n, String str, int start, int end) {
        for (int i = 0; i <= (n - 1); i++) {
            String arr_i = arr[i];
            for (int j = start; j <= end; j++)
                if (arr_i.charAt(j) != str.charAt(j))
                    return false;
        }
        return true;
    }
}

