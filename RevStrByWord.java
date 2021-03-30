/* Reverse word by word
https://leetcode.com/problems/reverse-words-in-a-string
Runtime: 8ms; TC: O(N); SC: O(N) */

class RevStrByWord {
    public String reverseWords(String A) {
        String line[] = A.trim().split("\\s+");
        for(int i = 0, j = line.length-1; i <= j; i++, j--) {
            line = Swap(line, i, j);
        }
        StringBuffer strbuffer = new StringBuffer();
        for (String str : line) {
            strbuffer.append(str).append(" ");
        }
        String result = strbuffer.toString();
        
        return (result.trim());
    }
    
    public String[] Swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
        return str;
    } 
}