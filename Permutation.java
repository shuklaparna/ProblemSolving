/* Permutations
https://www.interviewbit.com/old/problems/permutations/
https://leetcode.com/problems/permutations/
O(N!) O(N) */
//InterviewBit Solution
public class Permutation {
    private boolean[] marked;
    private ArrayList < ArrayList < Integer >> res;
    private ArrayList < Integer > A;
    private int n;
    public ArrayList < ArrayList < Integer >> permute(ArrayList < Integer > A) {
        n = A.size();
        marked = new boolean[n];
        res = new ArrayList < > ();
        this.A = A;
        rec(0, new ArrayList < > ());
        return res;
    }
    public void rec(int idx, ArrayList < Integer > temp) {
        if (idx == n) {
            res.add(new ArrayList < > (temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                marked[i] = true;
                temp.add(A.get(i));
                rec(idx + 1, temp);
                marked[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}


//leetcode Solution
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); //list to store results
        boolean [] vis = new boolean[nums.length]; // array to keep track of visited numbers
        helper( nums,0, res, new ArrayList<Integer>(),vis); 
        return res;
    }
    
    public void helper(int[] nums, int index, List<List<Integer>> res ,List<Integer> list, boolean[]vis){
        int n = nums.length;
        if(index == nums.length){
            res.add(new ArrayList(list));
            return;
        }
        
        for(int i= 0; i < n; i++){
            if(vis[i] == false){
                list.add(nums[i]);
                vis[i] = true;
                helper(nums,index+1, res, list,vis);
                list.remove(list.size() - 1);
                vis[i] = false;
            }
        }
        
    }
}