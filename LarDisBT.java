/* Largest Distance between nodes of a Tree
https://www.interviewbit.com/problems/largest-distance-between-nodes-of-a-tree/
TC: O(N); SC: O(N) */

//ArrayMethod
public class LarDisBT {
    public int solve(int[] nums) {
        int [] arr = new int[nums.length];
        int i, k = 0;
        for (i = nums.length - 1; i > 0; --i)
        {
            k = Math.max(k, arr[nums[i]] + arr[i] + 1);
            arr[nums[i]] = Math.max(arr[nums[i]], arr[i] + 1);
        }
        return k;
    }
}

//ArrayListMethod
public class Solution {
    public int solve(ArrayList<Integer> A) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < A.size(); ++i) {
            arr.add(new int[2]);
        }
        int maxDistance = 0;
        for (int i = A.size() - 1; i > 0; --i) {
            int element = A.get(i);
            int[] parent = arr.get(element);
            int currentLength = arr.get(i)[0] + 1;
            
            parent[1] = Math.max(parent[1], currentLength + parent[0]);
            parent[0] = Math.max(parent[0], currentLength);
            maxDistance = Math.max(maxDistance, parent[1]);
        }
        return maxDistance == 0 ? 0 : maxDistance;
    }
}
