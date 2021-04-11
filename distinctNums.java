/* Distinct Numbers in Window - Hashing
https://www.interviewbit.com/problems/distinct-numbers-in-window/
TC: O(N); SC:O(N); */

public class distinctNums {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        int n = A.size();
        if (B > n) {
          return new ArrayList<Integer>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B - 1; i++) {
          map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<>();
        int start = 0;
        for (int i = B - 1; i < n; i++) {
          map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
          arr.add(map.size());
          map.put(A.get(start), map.getOrDefault(A.get(start), 0) - 1);
          if (map.get(A.get(start)) <= 0) {
            map.remove(A.get(start));
          }
          start++;
        }
        return arr;
    }
}
