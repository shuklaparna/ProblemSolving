/* Largest Continuous Sequence Zero Sum
https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
TC: O(N); SC:O(N); */

public class LarSeqSumZ {
    public ArrayList<Integer> lszero(ArrayList<Integer> A) {
        Map<Integer, Integer> hmap = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        hmap.put(0,-1);
        int start = -1, end = -1, sum = 0, max = -1;
        for (int i=0;i<A.size();i++) {
            sum += A.get(i);
            if (hmap.containsKey(sum)) {
                if (max < (i - hmap.get(sum))) {
                    start = hmap.get(sum) + 1;
                    end = i;
                    max = i - hmap.get(sum);
                }
            }
            else {
                hmap.put(sum, i);
            }
        }
        
        if(start >= 0 && end >= 0) {
            for(int i = start; i <= end; i++) {
                ans.add(A.get(i));
            }
        }
        
        return ans;
    }
}