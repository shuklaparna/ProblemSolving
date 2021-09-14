/* NUmber of Islands
https://leetcode.com/problems/number-of-islands/submissions/
TC: O(mXn); SC: O(mXn) */

class NumIslands 
{
    public int numIslands(char[][] grid) 
    {
        if(grid.length == 0)
            return 0;
        
        int answer = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1')
                {
                    helper(grid, i, j);
                    answer += 1;
                }
            }
        }
        
        return answer;
    }
    
    
    public void helper(char[][] grid, int i, int j)
    {        
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1')
            return;
        
        grid[i][j] = '0';
        
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
        helper(grid,i + 1, j);
        helper(grid, i - 1, j);
    }
}


/* If qs is like below:
Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

More formally, from any cell (i, j) if A[i][j] = 1 you can visit:

(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
Return the number of islands.
then solution is: */


public class Solution {
    static int[] dx = new int[] {0, 1, -1, 0, 1, -1, 1, -1};
    static int[] dy = new int[] {1, 0, 0, -1, -1, 1, 1, -1};
    static int tc = 0;
    static int[][] visited = new int[105][105];
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        ++tc;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && visited[i][j] != tc) {
                    dfs(i, j, n, m, A);
                    ans++;
                }
            }
        }
        return ans;
    }
    public static boolean check(int i, int j, int n, int m, int[][] A) {
        return (i >= 0 && i < n && j >= 0 && j < m && (A[i][j] == 1) && visited[i][j] != tc);
    }
    public static void dfs(int i, int j, int n, int m, int[][] A) {
        visited[i][j] = tc;
        int di, dj;
        for (int k = 0; k < 8; ++k) {
            di = i + dx[k];
            dj = j + dy[k];
            if (check(di, dj, n, m, A))
                dfs(di, dj, n, m, A);
        }
    }
}