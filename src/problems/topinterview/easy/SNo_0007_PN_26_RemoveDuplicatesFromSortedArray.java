package problems.topinterview.easy;

import java.util.Scanner;

public class SNo_0007_PN_26_RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int res = removeDuplicates(arr);
		
		System.out.println("k == " + res);
		
		
		for(int i = 0 ; i< res ; i++) {
			System.out.print(arr[i]+ " ");
		}
		

	}

	private static int removeDuplicates(int[] nums) {
		// TODO Auto-generated method stub
		
		int i =0, j = 1;
		for(i=0, j=1; i<nums.length && j < nums.length ; i++) {
			while( nums[i] == nums[j]) {
				j++;
				if(j >= nums.length) {
					return i+1;
				}
			}
			nums[i+1] = nums[j];
			j++;
		}
		return i+1;
	}
	
	
	
	@SuppressWarnings("unused")
	private static int removeDuplicates_2(int[] nums) {
		  int n = nums.length;
	        if(n<=1){return n;}
	        
	        int left = 0; //everything to the left of left(inclusive) is good
	        int right = 1;//the current element we are processing
	        
	        while(right<=n-1){
	            if(nums[right] == nums[left]){
	                right++;
	            }
	            else{
	                nums[left+1] = nums[right];
	                left++;
	                right++;
	            }
	        }
	        
	        return left+1;
	}

}


/*

https://leetcode.com/problems/remove-duplicates-from-sorted-array/
-------------------------------------------------------------------

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

0 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.

**********************  Hints ***********************

1)
In this problem, the key point to focus on is the input array being sorted. 
As far as duplicate elements are concerned, 
what is their positioning in the array when the given array is sorted? 
Look at the image above for the answer. 
If we know the position of one of the elements,
do we also know the positioning of all the duplicate elements?

2)
We need to modify the array in-place and the size of the final array would 
potentially be smaller than the size of the input array. 
So, we ought to use a two-pointer approach here. One, 
that would keep track of the current element in the 
original array and another one for just the unique elements.

3)
Essentially, once an element is encountered, you simply need to bypass its 
duplicates and move on to the next unique element.

********************  Solution **********************

**********************  Input ***********************
3
1 1 2

output:
k == 2
1 2 

-------------

10
0 0 1 1 1 2 2 3 3 4

output:
k == 5
0 1 2 3 4 


*/
