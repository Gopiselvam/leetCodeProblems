package problems.topinterview.easy;

import java.util.Scanner;

public class SNo_0004_PN_14_LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
//		String para = sc.nextLine();
//		String[] strs = para.split("[\\s\\n\\r]+");
		int n = sc.nextInt();
		sc.nextLine();
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = sc.nextLine();
		}
		sc.close();
//		String res = longestCommonPrefix(strs);
		String res = longestCommonPrefix_method2(strs);
//		String res = longestCommonPrefix_method3(strs);
		System.out.println(res);
	}
	
	
	
	
	@SuppressWarnings("unused")
	private static String longestCommonPrefix(String[] strs) {
		// TODO Auto-generated method stub
		if(strs.length < 1 || strs.length > 200) {
			return "";
		}
		String res = strs[0];
		char[] ch = new char[0];
		for(int i=1;i < strs.length; i++) {
			if(strs[i].isEmpty()) {
				return "";
			}
			ch = strs[i].toCharArray();
			for(int j = 0; j<res.length() && j < ch.length; j++) {
				if(ch.length < res.length()) {
					res = res.substring(0, ch.length);
				}
				if(ch[j] != res.charAt(j)) {
					res = res.substring(0, j);
				}
			}
			
		}
		return res;
	}
	
	
	/**
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
	 * Memory Usage: 37.1 MB, less than 67.57% of Java online submissions for Longest Common Prefix.
	 * @param strs
	 * @return
	 */
	private static String longestCommonPrefix_method2(String[] strs) {
		if(strs.length < 1 || strs.length > 200) {
			return "";
		}
		String res = strs[0];
		for(int i=1; i< strs.length; i++) {
			if(strs[i].isEmpty()) {
				return "";
			}
			while(strs[i].indexOf(res) != 0) {
				res = res.substring(0, res.length()-1);
			}
		}
		return res;
		
	}
	
	
	@SuppressWarnings("unused")
	private static String longestCommonPrefix_method3(String[] strs) {
		if(strs.length < 1 || strs.length > 200) {
			return "";
		}
		int len = strs[0].length();
		
		for (int i = 1; i < strs.length; i++) {
			if(strs[i].isEmpty()) {
				return "";
			}
			len = Math.min(len, strs[i].length());
			for(int j=0; j< len ; j++) {
				char x = strs[0].charAt(j);
				char y = strs[i].charAt(j);
				if(x!=y) {
					len = j;
					break;
				}
			}
				
		}
		return strs[0].substring(0, len);
		
	}

}

/*

https://leetcode.com/problems/longest-common-prefix/
----------------------------------------------------

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

****************************  Hints ************************************
1) 

****************************  Solution ************************************


****************************  Input ************************************

flower flow flight

output:
fl

ab a

output:
a

abab aba ""

output:
""

*/