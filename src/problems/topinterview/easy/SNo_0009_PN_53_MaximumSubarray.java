package problems.topinterview.easy;

import java.util.Arrays;
import java.util.Scanner;

public class SNo_0009_PN_53_MaximumSubarray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		String[] strarr = str.replaceAll("[\\[\\]]", "").split(",", -1);

		int[] nums = Arrays.stream(strarr).filter(s -> isNumeric(s)).mapToInt(Integer::parseInt).toArray();
		int res = maxSubArray_2(nums);
		System.out.println(res);
	}

	// in efficient O(n^2)
	@SuppressWarnings("unused")
	private static int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = nums[i];
			max = Math.max(max, sum);
			for (int j = i + 1; j < nums.length; j++) {
				sum += nums[j];
				max = Math.max(max, sum);

			}
			sum = 0;
		}
		return max;
	}
	
	// 0 ms 100% faster than others
	private static int maxSubArray_2(int[] nums) {
		int maxSum = nums[0];
		int maxCurrent = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
			if (maxCurrent > maxSum) {
				maxSum = maxCurrent;
			}
		}
		return maxSum;
	}

	public static boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}

/*

https://leetcode.com/problems/maximum-subarray/
-----------------------------------------------
Given an integer array nums, find the contiguous subarray 
(containing at least one number) which has the largest sum and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
 

Constraints:

1 <= nums.length <= 3 * 104
-105 <= nums[i] <= 105
 

Follow up: If you have figured out the O(n) solution, 
try coding another solution using the divide and conquer approach, 
which is more subtle.

**********************  Hints ***********************

********************  Solution **********************

**********************  Input ***********************


*/