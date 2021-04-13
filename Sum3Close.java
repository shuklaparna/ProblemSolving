/* 3 Sum
https://www.interviewbit.com/problems/3-sum/
TC: O(N^2); SC:O(1) */

public class Sum3Close {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        if(A.size() < 3) {
            return 0;
        }
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.size() - 2; i++) {
            int p1 = i + 1, p2 = A.size() - 1;
            while (p1 < p2) {
                int sum = A.get(i) + A.get(p1) + A.get(p2);
                int diff = Math.abs(B - sum);
                if(diff == 0) {
                    return B;
                }
                if(diff < min) {
                    min = diff;
                    ans = sum;
                }
                if(sum < B){
                    p1++;
                }
                else{
                    p2--;
                }
            }
        }

        return ans;
    }
}
