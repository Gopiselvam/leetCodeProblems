package problems.topinterview.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SNo_0001_PN_1_TwoSum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int len = sc.nextInt();
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		sc.close();
		int[] res = twoSum(arr, target);
		if (res.length > 0) {
			System.out.println(res[0] + " " + res[1]);
		} else {
			System.out.println("No elements found");
		}

	}

	private static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hm.containsKey(target - nums[i])) {
				return new int[] { hm.get(target - nums[i]), i };
			} else {
				hm.put(nums[i], i);
			}
		}
		return new int[0];
	}

}

/*

https://leetcode.com/problems/two-sum/
-----------------------------------------

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
************************** Hints ************************************
Hint2:

So, if we fix one of the numbers, say
x
, we have to scan the entire array to find the next number
y
which is
value - x
where value is the input parameter. Can we change our array somehow so that this search becomes faster?

***************************** Solution *********************************

create hasmap<value, index>;

for arr in 0 -> n-1
	if map contains target - arr[i]
		return {i, map.get(arr[i])}
	else
		map.add(arr[i], i)
return new int[0]

****************************** Input ***********************************

4
2 7 11 15
9

output:
0 1
--------------

3
3 2 4
6

output:
1 2
--------------

2
3 3
6

output:
0 1
--------------

*/