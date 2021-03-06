/* Reverse Vowels
https://leetcode.com/problems/reverse-vowels-of-a-string/
Runtime: 2ms
Complexity: O(N) */

class ReverseVowels {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
	    int right = chars.length - 1;

	    while (left < right) {  

		    while (left < right && !isVowel(chars[left]))
			    left++;

	    	while (right > 0 && !isVowel(chars[right]))
		    	right--;

		    if (left < right) {
			    char temp = chars[left];
			    chars[left] = chars[right];
			    chars[right] = temp;
		    }

	    	right--;
		    left++;
	    }
        
        return new String(chars);
            
    }
    public boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        else
            return false;
    }
        
        
}


