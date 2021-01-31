/* Shuffle the Array

https://leetcode.com/problems/shuffle-the-array/

Runtime: 0ms
Time Complexity:  O(n) */
import java.io.*;
class ShuffleArray {
    public static int[] shuffle(int[] nums, int n) {
        int arr[] = new int[2*n];
        for(int i = 0, k = 0, j = n; i < 2*n; i+=2, j++, k++) {
            arr[i] = nums[k];
            arr[i+1] = nums[j];
            
        }
        return arr;
    }
    
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[2*n];
        for(int  i = 0; i < 2*n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(shuffle(nums,n));
    }
}



