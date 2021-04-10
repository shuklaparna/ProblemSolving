/* CodeX: Playing Regions (Graph Data Structure & Algorithms)
Problem Description:
Given a park in the form 2-D integer array A of size N * M containing 1 * 1 squares.
Each 1 * 1 square contains a wall or empty space. There are two types of walls with different directions:
'/' wall is represented by integer 1 in the array.
'\' wall is represented by integer 2 in the array.
empty space is represented by integer 0 in the array.
These walls divide the park into different contiguous playing regions. Find the number of playing regions in the park.
NOTE: Assume the park is surrounded by walls. See sample examples for more clarification.

Problem Constraints:
1 <= N * M <= 106
0 <= A[i][j] <=2

Input Format:
First and only argument is 2-D integer array A.

Output Format:
Return an integer denoting the number contiguous playing regions.

Example Input:
Input 1:
A = [ [1] ]
Input 2:
A = [  [2, 1]
       [1, 2]  ]
Input 3:
A = [  [1, 0, 1]
       [0, 0, 0]  ]

Example Output:
Output 1:
2
Output 2:
4
Output 3:
2

Example Explanation:
Explanation 1:
Given park in the form of 11 grid as: 
There are 2 contiguous regions in the park.
Explanation 2:
The 22 grid as: 
Dotted lines denote 11 squares. 
Park is divided into 4 regions by the walls(represented by dark lines).
Explanation 3:
The 23 grid as: 
Dotted lines represent the 1*1 squares of the grid.
Park is divided into 2 regions by the walls(represented by dark lines) */

public class PlayingRegionsGrph {
    public int solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;
    int totalNodes = 4*N*M;
    DSU dsu = new DSU(totalNodes);


    int curNode = 0;
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<M;j++)
        {
            int index = 4*(M*i + j);
            int top = index, right = index + 1 , bottom = index + 2, left = index + 3; 
            if(A[i][j]==1)
            {
                dsu.merge(top, left);
                dsu.merge(bottom, right);
            }
            else if(A[i][j]==2)
            {
                dsu.merge(top, right);
                dsu.merge(bottom, left);    
            }
            else 
            {   
                // connect all the parts of 1*1 square.
                dsu.merge(top, right);
                dsu.merge(right, bottom);
                dsu.merge(bottom, left);
            }

            if(j+1 < M)
            {
                dsu.merge(right, right + 6);
            }

            if(j-1 > 0)
            {
                dsu.merge(left, left - 6);
            }

            if(i+1 < N)
            {
                dsu.merge(bottom, bottom + 4*M - 2);
            } 

            if(i-1 > 0)
            {
                dsu.merge(top, top - 4*M + 2);
            }  
        }


    }

    int ans = 0;
    
    for(int i=0;i<totalNodes;i++)
    {
        if(dsu.find(i) == i)
        {
            ans++;
        }
    }
    
    return ans;
    }
}
class DSU{

    int[] rank;
    int[] parent;

    public DSU(int x)
        {
            parent = new int[x];
            rank = new int[x];
            Arrays.fill(rank,1);
            for(int i = 0 ; i < x; i++)
            {
                parent[i] = i;
            }
        }

        public int find(int x)
        {
            if(parent[x] != x)
                parent[x] = find(parent[parent[x]]);

            return parent[x];
        }

        public int merge(int x, int y)
        {
            int px = find(x), py = find(y);

            if(px == py) return 0;

            if(rank[px] < rank[py])
            {
                parent[px] = py;
                rank[py] += rank[px];
            }
            else
            {
                parent[py] = px;
                rank[px] += rank[py];
            }

            return 1;
        }
}