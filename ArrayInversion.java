/* Array Inversion
https://www.geeksforgeeks.org/java-program-for-count-inversions-in-an-array-set-1-using-merge-sort/
Time Complexity: O(n log n), Space Complexity: O(n) */


public class ArrayInversion {	
	public int solve(int[] A) {
		return (mergeSort(A, A.length));
    }
	/* This method sorts the input array and returns the 
	number of inversions in the array */
	static int mergeSort(int A[], int N) 
	{ 
		int temp[] = new int[N]; 
		return mergeSortCount(A, temp, 0, N - 1); 
	} 

	/* An auxiliary recursive method that sorts the input array and 
	returns the number of inversions in the array. */
	static int mergeSortCount(int A[], int temp[], int l, int r) 
	{ 
		int mid, count = 0; 
		if (r > l) { 
			/* Divide the array into two parts and call _mergeSortAndCountInv() 
		for each of the parts */
			mid = (r + l) / 2; 

			/* Inversion count will be sum of inversions in left-part, right-part 
		and number of inversions in merging */
			count = mergeSortCount(A, temp, l, mid); 
			count += mergeSortCount(A, temp, mid + 1, r); 

			/*Merge the two parts*/
			count += merge(A, temp, l, mid + 1, r); 
		} 
		return (count % 1000000007); 
	} 

	/* This method merges two sorted arrays and returns inversion count in 
	the arrays.*/
	static int merge(int A[], int temp[], int l, int mid, int r) 
	{ 
		int i, j, k; 
		int count = 0; 

		i = l; /* i is index for left subarray*/
		j = mid; /* j is index for right subarray*/
		k = l; /* k is index for resultant merged subarray*/
		while ((i <= mid - 1) && (j <= r)) { 
			if (A[i] <= A[j]) { 
				temp[k++] = A[i++]; 
			} 
			else { 
				temp[k++] = A[j++]; 

				/*this is tricky -- see above explanation/diagram for merge()*/
				count = count + (mid - i); 
			} 
		} 

		/* Copy the remaining elements of left subarray 
	(if there are any) to temp*/
		while (i <= mid - 1) 
			temp[k++] = A[i++]; 

		/* Copy the remaining elements of right subarray 
	(if there are any) to temp*/
		while (j <= r) 
			temp[k++] = A[j++]; 

		/*Copy back the merged elements to original array*/
		for (i = l; i <= r; i++) 
			A[i] = temp[i]; 

		return (count % 1000000007); 
	} 
}