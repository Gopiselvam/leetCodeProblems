package problems.topinterview.easy;
/*

https://leetcode.com/problemset/all/?difficulty=EASY&listId=wpwgkgt
list = top interview questions
difficulty = easy

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TEMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("fsflight".indexOf("flsa"));
		

	}

}

/*

**********************  Hints ***********************
********************  Solution **********************
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		sc.close();
		String[] strarr1 = str1.replaceAll("[\\[\\]]", "").split(",",-1);
		String[] strarr2 = str2.replaceAll("[\\[\\]]", "").split(",",-1);
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		l1.addAll(Arrays.stream(strarr1).map(Integer::valueOf).collect(Collectors.toList()));
		l2.addAll(Arrays.stream(strarr2).map(Integer::valueOf).collect(Collectors.toList()));

**********************  Input ***********************

*/