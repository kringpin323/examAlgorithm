package binaryTree;

import java.util.LinkedList;

public class binaTree {
	public static void preOrder(TreeNode tn){
		if(tn != null){
			System.out.print(tn.key+" ");
			preOrder(tn.left);
			preOrder(tn.right);
		}
			
	}
	
	public static void buildTree(int[] A){
		LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
		
		TreeNode first = new TreeNode(A[0]);
		TreeNode left = new TreeNode(A[1]);
		TreeNode right = new TreeNode(A[2]);
		
		ll.push(first);
		
		
		
		System.out.println("hello world");
		// test for modify in github
		
		
		
	}
	
}
