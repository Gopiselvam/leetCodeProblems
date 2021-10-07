package problems.topinterview.easy;

import java.util.Scanner;

public class SNo_0011_PN_69_SqrtOfX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		int res = mySqrt(x);
		System.out.println(res);

	}

	private static int mySqrt(int x) {
		return (int) binsearch(x, 0, x);
	}

	@SuppressWarnings("unused")
	private static int mySqrt_2(int x) {
		if (x <= 1)
			return x;
		int left = 1, right = x;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (mid <= x / mid) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left - 1;
	}

	private static long binsearch(long target, long low, long high) {
		if (low > high) {
			return -1;
		}
		long mid = (low + high) / 2;
		long square = mid * mid;
		if (square == target) {
			return mid;
		} else if ((mid - 1) * (mid - 1) < target && square > target) {
			return mid - 1;
		} else if ((mid + 1) * (mid + 1) > target && square < target) {
			return mid;
		} else if (square > target) {
			high = mid - 1;
		} else if (square < target) {
			low = mid + 1;
		}

		return binsearch(target, low, high);
	}

}


/*

https://leetcode.com/problems/sqrtx/
-----------------------------------------------
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1

**********************  Hints ***********************

1 = 1*1
2 = 1*1
3 = 1*1
4 = 2*2
8 = 2*2
9 = 3*3
10 = 3*3

we take 10, then the low = 0, high = 10
mid = 5, sqrt = 25
 if (mid-1) 4*4 < 10 and (sqrt) 25 > 10 means 
  	we can conclude that 4 is ans
 if (mid+1) 6*6 = 36 > 10 and 25 < 10 means
 	we can conclude that 6 is ans
 
 if sqrt = 25 > 10 we need to search something before mid
 	so high = mid -1
 
 if sqrt < 10 we need to search for ans above mid
 	so low = mid+1
 
 recurse func(target, low, high)
 

********************  Solution **********************

**********************  Input ***********************




*/