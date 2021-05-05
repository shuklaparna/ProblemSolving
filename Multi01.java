/* Smallest Multiple with 0 & 1
https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/ */

public class Multi01 {
    public String multiple(int A) {
        Queue<String> q = new LinkedList<String>();
        Set<Integer> visit = new HashSet<>();
        String t = "1";
        q.add(t);
        while (!q.isEmpty()) {
            t = q.remove();
            // Find remainder of t with respect to N.
            int rem = mod(t, A);
            // If remainder is 0 then solution found
            if (rem == 0)
                return t;
            else if(!visit.contains(rem)) {
                visit.add(rem);
                q.add(t + "0");
                q.add(t + "1");
            }
        }
        return "";
    }
    public static int mod(String t, int N) {
    int r = 0;
    for(int i = 0; i < t.length(); i++) {
        r = r * 10 + (t.charAt(i) - '0');
        r %= N;
    }
    return r;
    }
}
