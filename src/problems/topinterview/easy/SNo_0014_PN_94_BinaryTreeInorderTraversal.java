package problems.topinterview.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//Definition for a binary tree node.
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}


public class SNo_0014_PN_94_BinaryTreeInorderTraversal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		sc.close();
		String[] strarr1 = str1.replaceAll("[\\[\\]]", "").split(",", -1);

//		System.out.println(Arrays.toString(strarr1));
		TreeNode root = null;
		int i = 0;
		for (i = 0; i < strarr1.length; i++) {
			if (!"".equals(strarr1[i])) {
				Integer valu = Integer.parseInt(strarr1[i]);
				root = new TreeNode(valu);
				break;
			}
		}
		for (int j = i + 1; j < strarr1.length; j++) {
			if (!"".equals(strarr1[j])) {
				Integer valu = Integer.parseInt(strarr1[j]);
//				addNode(root, valu);
				insert(root, valu);
			}
		}
		
		List<Integer> list = inorderTraversal(root);
		System.out.println(list);

	}

	private static List<Integer> inorderTraversal(TreeNode root) {
//		List<Integer> list =  new ArrayList<Integer>();
//		 if(root == null) {
//			 return list;
//		 }
//		 list.addAll(inorderTraversal(root.left));
//		 list.add(root.val);
//		 list.addAll(inorderTraversal(root.right));
//		 return list;
		 
		 List<Integer> res = new ArrayList<>();
	        if(root == null) return res;
	        res.addAll(inorderTraversal(root.left));
	        res.add(root.val);
	        res.addAll(inorderTraversal(root.right));
	        return res;
	}

	

	private static TreeNode addNode(TreeNode node, Integer valu) {
		if(null == node) {
			return new TreeNode(valu);
		}else if(valu < node.val) {
			node.left =  addNode(node.left, valu);
		}else if(valu > node.val){
			node.right = addNode(node.right, valu);
		}
		return node;
	}
	
	
	public static void insert(TreeNode root, int i) {
		TreeNode newNode = new TreeNode(i);
		if (root == null) {
			root = newNode;
		} else {
			TreeNode current = root;
			TreeNode parent;
			while (true) {
				parent = current;
				if (i < current.val) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	
}

/*

https://leetcode.com/problems/binary-tree-inorder-traversal/
------------------------------------------------------------

Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
1
 \
  2
 /
3

Input: root = [1,null,2,3]
Output: [1,3,2]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Example 4:
  1
 /
2
Input: root = [1,2]
Output: [2,1]

Example 5:
1
 \
  2
Input: root = [1,null,2]
Output: [1,2]

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?

**********************  Hints ***********************

********************  Solution **********************

**********************  Input ***********************

*********************  Functions ********************






*/