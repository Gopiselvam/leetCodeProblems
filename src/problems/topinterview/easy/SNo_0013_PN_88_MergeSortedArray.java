package problems.topinterview.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class SNo_0013_PN_88_MergeSortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] nums1 = new int[m+n] ;
		int[] nums2 = new int[n];
		for (int i = 0; i < m+n; i++) {
			nums1[i] = sc.nextInt();			
		}
		for (int i = 0; i < n; i++) {
			nums2[i] = sc.nextInt();			
		}
		sc.close();
		merge_3(nums1, m, nums2, n);
		for(int i=0; i< (m+n) ; i++) {
			System.out.print(nums1[i]+" ");
		}
	}

	@SuppressWarnings("unused")
	private static void merge(int[] nums1, int m, int[] nums2, int n) {
		int [] res = new int[m+n];
		int mp = 0;
		int np = 0;
		int i = 0;
		for(i=0; mp< m  && np<n ; i++) {
			if(nums1[mp] <= nums2[np] ) {
				res[i] = nums1[mp++];
			}else {
				res[i] = nums2[np++];
			}
		}
		while(mp < m) {
			res[i++] = nums1[mp++];
		}
		while(np < n) {
			res[i++] = nums2[np++];
		}
		System.arraycopy(res, 0, nums1, 0, (m+n));
	}
	
	// Effcienct code
	@SuppressWarnings("unused")
	private static void merge_2(int[] nums1, int m, int[] nums2, int n) {
		
		System.arraycopy(nums2, 0, nums1, m, n);
		Arrays.sort(nums1);
	}
	
	// without Arrays.sort()
    private static void merge_3(int[] nums1, int m, int[] nums2, int n) {
		
			
		
		
		int i=0,j=0,k=0;
	       int[] temp=Arrays.copyOf(nums1,m);
	       while(i<m && j<n){
	           if(temp[i]<=nums2[j]){
	               nums1[k++]=temp[i++];
	           }
	           else{
	               nums1[k++]=nums2[j++];
	           }  
	       }
	    
	        while(i<m){
	           nums1[k++]=temp[i++]; 
	        }
	         while(j<n){
	           nums1[k++]=nums2[j++]; 
	        }
	         
	         
	}

}

/*

https://leetcode.com/problems/merge-sorted-array/
-------------------------------------------------

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

 

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109
 

Follow up: Can you come up with an algorithm that runs in O(m + n) time?

**********************  Hints ***********************
1)
You can easily solve this problem if you simply think about two elements at a 
time rather than two arrays. We know that each of the individual arrays is sorted. 
What we don't know is how they will intertwine. Can we take a local decision and 
arrive at an optimal solution?

2)
If you simply consider one element each at a time from the two arrays and make 
a decision and proceed accordingly, you will arrive at the optimal solution.

********************  Solution **********************
System.arraycopy(res, 0, nums1, 0, (m+n));
Arrays.copyOf(nums1, m);

**********************  Input ***********************

3
3
1 2 3 0 0 0
2 5 6

1
1
2 0
1


*/
