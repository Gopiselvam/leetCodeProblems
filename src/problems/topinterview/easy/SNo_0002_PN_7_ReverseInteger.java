package problems.topinterview.easy;

import java.util.Scanner;

public class SNo_0002_PN_7_ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		sc.close();
		int res = reverse(x);
		System.out.println(res);

	}

	private static int reverse(int x) {
		
		if(x==0 || x == Integer.MIN_VALUE) {
			return 0;
		}
		long res = 0;
		int mod = 0;
		while(x != 0) {
			mod = x%10;
			res = res*10 +mod;
			x /= 10;
		}
		if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
			return 0;
		}
		return (int)res;
	}

}




/*
https://leetcode.com/problems/reverse-integer/
----------------------------------------------

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1

********************** Hint *********************************
Integer.MAX_VALUE + 1 = Integer.MIN_VALUE;
Integer.MIN_VALUE -1 = Integer.MAX_VALUE

2147483647 => reverse => 7463847412 (long value) => so return 0

-123%120 = -3

********************** Solution *********************************
res = 0
while x != 0
	mod = x%10 		-> getting the unit digit
	res = res*10+mod -> by multiplying with 10 we can make the number 1 digit higher, then add the mod
	x = x/10;		-> remove the last digit

********************** Input *********************************
2147483647

output:
0
---------------
-2147483647

output:
0
---------------
-214748364

output:
-463847412

-------------
210

output:
12


*/