package problems.topinterview.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SNo_0003_PN_13_RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		int res = romanToInt(s);
		System.out.println(res);

	}

	private static int romanToInt(String s) {
		// TODO Auto-generated method stub
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
	
		int val = map.get(s.charAt(s.length()-1));
		for (int i = s.length() -2; i >= 0; i--) {
			if(!map.containsKey(s.charAt(i)) || s.length() < 1 || s.length() > 15) {
				return 0;
			}
			boolean cond = map.get(s.charAt(i)) < map.get(s.charAt(i+1));
			if(cond) {
				val -=  map.get(s.charAt(i));
			}else {
				val +=  map.get(s.charAt(i));
			}
		}
		
		
		return val;
	}

}

/*

https://leetcode.com/problems/roman-to-integer/
-----------------------------------------------

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

 

Example 1:

Input: s = "III"
Output: 3
Example 2:

Input: s = "IV"
Output: 4
Example 3:

Input: s = "IX"
Output: 9
Example 4:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

****************************  Hints ************************************

Problem is simpler to solve by working the string from back to front and using a map.

****************************  Solution ************************************

create a map and populate the values of     I, V, X, L, C, D, M
res = map value of str[len -1]
for i in (str.length() -2) -> 0
	if str[i] > str[i-1]
		res = res - map value of str[i]
	else
		res = res + map value of str[i]
return res;
****************************  Input ************************************

MCMXC008899IV

output:
0


*/