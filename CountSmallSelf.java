/* Count of smaller numbers after self
https://leetcode.com/problems/count-of-smaller-numbers-after-self/submissions/
TC: O(NLogN)*/

//First Method
public class CountSmallSelf {
    public int[] solve(int[] A) {
        int N = A.length;
        int[] res = new int[N]; 
        int[][] pairs = new int[N][2];
        for (int i = 0; i < N; i++) {
            pairs[i] = new int[]{A[i], i};
        }
        mergeSort(pairs, res, 0, N - 1);
        return res;
    }
    private void mergeSort(int[][] pairs, int[] res, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        mergeSort(pairs, res, lo, mid);
        mergeSort(pairs, res, mid + 1, hi);
        int[][] left = Arrays.copyOfRange(pairs, lo, mid + 1);      
        int[][] right = Arrays.copyOfRange(pairs, mid + 1, hi + 1); 
        for (int k = lo, i = 0, j = 0; k <= hi; k++) {
            if (j >= right.length || (i < left.length && left[i][0] <= right[j][0])) { 
                res[left[i][1]] += j;
                pairs[k] = left[i++];
            } 
            else {
                pairs[k] = right[j++];
            }
        }
    }
}

//Second Solution
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i]:min;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i],max);
        }
        int[] tree = new int[max+1];
        for (int i = nums2.length-1; i >= 0; i--) {
            res.add(0,get(nums2[i]-1,tree));
            update(nums2[i],tree);
        }
        return res;
    }
    private int get(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num +=tree[i];
            i -= i&(-i);
        }
        return num;
    }
    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i] ++;
            i += i & (-i);
        }
    }
}