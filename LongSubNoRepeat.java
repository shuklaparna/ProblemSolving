/* Longest Substring without repeat
https://leetcode.com/problems/longest-substring-without-repeating-characters
TC: O(N); SC: O(N); Runtime: 2ms */

//first method
class LongSubNoRepeat {
    public int lengthOfLongestSubstring(String A) {
        int n = A.length();
        int ans = 0;
        int [] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        int i = 0;
        for(int j = 0; j < n; j++) {
            i = Math.max(i, lastIndex[A.charAt(j)] + 1);
            ans = Math.max(ans, j - i + 1);
            lastIndex[A.charAt(j)] = j;
        }
        return ans;
    }
}

//another method using hashmap
//Runtime: 5ms
class LongSubNoRepeat1 {
	public int lengthOfLongestSubstring(String A) {
	    
        int count = 0;
        int max = 0;
	    int n = A.length();
	    HashMap<Character, Integer> hashMap = new HashMap<>();
	    char c;
	    int prevIndex;
	    
	    for (int i = 0; i < n; i++) {
	        
	        c = A.charAt(i);
	        
	        if (hashMap.containsKey(c)) {
	            prevIndex = hashMap.get(c);
	            count = Math.min(count + 1, i - prevIndex);
	            hashMap.put(c, i);
	        } else {
	            count++;
	            hashMap.put(c, i);
	        }
	        
	        max = Math.max(max, count);
	    }
	    
	    return max;
	}
}
