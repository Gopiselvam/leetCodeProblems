package problems.topinterview.easy;

import java.util.Arrays;
import java.util.Scanner;

public class SNo_0010_PN_66_PlusOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		sc.close();
		String[] strarr = str.replaceAll("[\\[\\]]", "").split(",", -1);

		int[] digits = Arrays.stream(strarr).mapToInt(Integer::parseInt).toArray();
		int[] res = plusOne(digits);
		System.out.println(Arrays.toString(res));

	}

	private static int[] plusOne(int[] digits) {
		int len=digits.length,
				carry=1;
        
		// if carry is 0 then we don't need to update values
        while(--len >= 0 && carry!=0){
           carry= digits[len]+ 1 >=10 ? 1:0; 
            digits[len]=(digits[len]+1)%10;
        }
		// if carry is 1 then we can say that our while loop terminated with (len >=0) condition,
		//so we need to increase the size.
		// Just update first value , all other values are by default 0 in java. so [9,9]-> [1,0,0].
        int ans[]=new int[digits.length+1];
        if(carry==1) ans[0]=1;
    
            
        return carry==1 ? ans : digits;
	}

}

/*

https://leetcode.com/problems/plus-one/
---------------------------------------

Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]
 

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9

**********************  Hints ***********************

********************  Solution **********************

**********************  Input ***********************


*/