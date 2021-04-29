/* K CLosest points to origin
https://leetcode.com/problems/k-closest-points-to-origin/ */

//FirstMethod (ArrayList) TC:O(N)
public class CloseOriginK {
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        int n = A.size(), c= 0;
        ArrayList<ArrayList<Integer> > al = new ArrayList<ArrayList<Integer> >();
        ArrayList<Double> dis = new ArrayList<Double>();
            for(int i = 0; i < n; i++) {
                dis.add(distance(A.get(i)));
            }
            Collections.sort(dis);
            for(int i = 0; i < n; i++) {
                double dist = distance(A.get(i));
                if(dist <= dis.get(B-1))
                    al.add((A.get(i)));
            }
        return al;
    }
    public double distance(ArrayList<Integer> list) {
        return (Math.sqrt(Math.pow((list.get(0)),2) + Math.pow((list.get(1)),2)));
    }
}

//SecondMethod (Array)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
         int N = points.length;
        int[] dists = new int[N];
        for (int i = 0; i < N; ++i)
            dists[i] = dist(points[i]);

        Arrays.sort(dists);
        int distK = dists[K-1];

        int[][] ans = new int[K][2];
        int t = 0;
        for (int i = 0; i < N; ++i)
            if (dist(points[i]) <= distK)
                ans[t++] = points[i];
        return ans;
    }

    public int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}

//ThirdMethod (Heap) TC:O(NlogN)
public class Solution {
    public int[][] kClosest(int[][] A, int B) {
        ArrayList < Pair > v = new ArrayList < Pair > ();
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            long x = (long) A[i][0];
            long y = (long) A[i][1];
            v.add(new Pair(x * x + y * y, i));
        }
        PriorityQueue < Pair > minHeap = new PriorityQueue < Pair > (new CustomComp());
        for (Pair a: v)
            minHeap.offer(a);
        int[][] ans = new int[B][2];
        // Extract B values
        for (int i = 0; i < B; i++) {
            Pair val = minHeap.poll();
            int[] row = A[val.ss];
            ans[i] = row;
        }
        return ans;
    }
}
class Pair {
    long ff;
    int ss;
    public Pair(long c, int d) {
        this.ff = c;
        this.ss = d;
    }
}
class CustomComp implements Comparator < Pair > {
    @Override
    public int compare(Pair a, Pair b) {
        if (a.ff > b.ff)
            return 1;
        return -1;
    }
}