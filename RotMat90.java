/* Rotate Matrix by 90degrees without taking an additional array
https://leetcode.com/problems/rotate-image/
https://www.interviewbit.com/problems/rotate-matrix/
TC: O(N); SC: (1) */

//First Method
class RotMat90 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}

//Second Method
public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> A) {
        
        int n = A.size();
	  
	    if (A == null || n == 0)
	        return;
	    
	    int layers = n;
	    for (int layer = 0; layer < layers / 2; layer++) {
	        
	        int first = layer;
	        int last = n - layer - 1;
	        
	        for (int i = first; i < last; i++) {
	            
	            int offset = i - layer;
	            
	            int top = A.get(first).get(i);
	            
	            A.get(first).set(i, A.get(last - offset).get(first));
	            
	            A.get(last - offset).set(first, A.get(last).get(last - offset));
	            
	            A.get(last).set(last - offset, A.get(i).get(last));
	            
	            A.get(i).set(last, top);
	        }
	        
	    }
    }
}

//Third Method
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }
    
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
    
    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}