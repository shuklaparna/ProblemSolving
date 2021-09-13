/* Contiguous Array
https://leetcode.com/problems/contiguous-array/
TC: O(N) */

class ContArr {
    public int findMaxLength(int[] A) {
        Map<Integer, Integer> hmap = new HashMap<>();
        int max = 0, cnt = 0;
        for(int i = 0; i < A.length; i++) {
            cnt += (A[i] == 1) ? 1 : -1;
            if(cnt == 0)
                max = Math.max(max, i+1);        
            if(hmap.containsKey(cnt)) {
                max = Math.max(max, i - hmap.get(cnt));
            } 
            else 
                hmap.put(cnt, i);
        }
        return max;
    }
}