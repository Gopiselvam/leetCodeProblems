package problems.topinterview.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SNo_0006_PN_21_MergeTwoSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		sc.close();
		String[] strarr1 = str1.replaceAll("[\\[\\]]", "").split(",",-1);
		String[] strarr2 = str2.replaceAll("[\\[\\]]", "").split(",",-1);
		List<Integer> list1 = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();
		
		list1.addAll(Arrays.stream(strarr1).filter(SNo_0006_PN_21_MergeTwoSortedList::isNumeric).map(Integer::valueOf).collect(Collectors.toList()));
		list2.addAll(Arrays.stream(strarr2).filter(SNo_0006_PN_21_MergeTwoSortedList::isNumeric).map(Integer::valueOf).collect(Collectors.toList()));
		if(list1.isEmpty() && list2.isEmpty()) {
			System.out.println("[]");
			return;
		}
		ListNode l1=null;
		if(!list1.isEmpty()) {
			l1 = new ListNode(list1.get(0));
		}
		ListNode l2 = null;
		if(!list2.isEmpty()) {
			l2 = new ListNode(list2.get(0));
		}
		
//		for(int i=1; i< list1.size(); i++) {
//			l1.next = new ListNode(list1.get(i));
//			l1 = l1.next;
//		}
		ListNode temp = l1;
		for(int i=1; i< list1.size(); i++) {
			temp.next = new ListNode(list1.get(i));
			temp = temp.next;
		}
		
		temp = l2;
		for(int i=1; i< list2.size(); i++) {
			temp.next = new ListNode(list2.get(i));
			temp = temp.next;
		}
			
		
		
		ListNode res = mergeTwoLists(l1, l2);
		
		while(null != res) {
			System.out.print(res.val + " ");
			res = res.next;			
		}

	}

	private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// TODO Auto-generated method stub
		if(l1==null && l2==null) {
			return null;
		}else if(l1 == null || l2 == null) {
			return (l1 == null)?l2:l1;
		}
		int trace = 0;
		if(l1.val <= l2.val) {
			trace = l1.val;
			l1 = l1.next;
		}else {
			trace = l2.val;
			l2 = l2.next;
		}
		ListNode n = new ListNode(trace);
		n.next = mergeTwoLists(l1, l2);
		return n;
	}

	

	public static boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

}



/*
https://leetcode.com/problems/merge-two-sorted-lists/
-----------------------------------------------------

Merge two sorted linked lists and return it as a sorted list. 
The list should be made by splicing together the nodes of the first two lists.

Example 1:

1 -> 2 -> 4
1 -> 3 -> 4

res:  1 -> 1 -> 2 -> 3 -> 4 -> 4 

Input: l1 = [1,2,4], l2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]
 

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.

**********************  Hints ***********************
accept input as a string [1,2,3]
remove the square brackets 1,2,3  => str.replaceAll("[\\[\\]]","")
create a string [] by splitting "," => str.split(",", -1)
Integer.parseInt(str) => returns int value of "[0-9]" or throws NumberFormatException
Integer.valueOf(str)  => returns Integer value of "[0-9]" or throws NumberFormatException

to create a custom linkedlist ListNode 
listnode1 = 1st element of list
temp = listnode1;
	for i in 1 -> list.size
		nextElem = new ListNode(list[i])
		temp.next = nextElem
		temp = temp.next
		
thus we formed linkedlist of ListNode

********************  Solution **********************

func(ListNode l1, ListNode l2)
	* if both l1 and l2 are null then we can terminate the recursion by
	* returning null. means res.next = null
	if l1 == null && l2 == null
		return null
	* if  l1 = null and l2 = not null we can return l2
	* res.next = l2 
	* in case we have completely traversed l1 and yet l2 have some numbers
	* then it will iterate the remaining numbers of l2
	* 
	else if l1 == null || l2 == null
		return l1 == null ? l2 : l1
	int trace = 0   // will be the min value from two ListNode
	
	* find the smaller value from list objects and set the value to trace
	* also move to the next node of used list
	* 
	if l1.val <= l2.val
		trace = l1.val
		l1 = l1.next
	else
		trace = l2.val
		l2 = l2.next
	
	* create the first node and recursively create the next nodes
	* 
	ListNode res = new ListNode(trace);
	res.next = func(l1, l2)
	return res;
	

**********************  Input ***********************
[1,2,3]
[4,5]

output:
1 2 3 4 5
--------------
[1,2,4]
[1,3,4]

output:
1 1 2 3 4 4 
--------------
[]
[]

output:
[]
--------------
[1,2,3]
[]

output:
1 2 3
--------------



*/