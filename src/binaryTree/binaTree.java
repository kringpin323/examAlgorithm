package binaryTree;

import java.util.LinkedList;
import sorted.heapsort;

public class binaTree {
	public static void preOrder(TreeNode tn){
		if(tn != null){
			System.out.print(tn.key+" ");
			preOrder(tn.left);
			preOrder(tn.right);
		}
	}
	
	/**
	 * 循环 前缀遍历，借助stack实现
	 * 学习link：http://www.cnblogs.com/dolphin0520/archive/2011/08/25/2153720.html
	 * */
	public static void preOrderLoop(TreeNode tn,LinkedList<TreeNode> stack){
		TreeNode temp = tn;
		while(temp!=null || stack.size()!=0){
			while(temp!=null){
				System.out.print(temp.key+" ");
				stack.push(temp);
				temp = temp.left;
			}
			if(stack.size()!=0){
				temp = stack.peek();
				stack.pop();
				temp = temp.right;
			}
		}
	}
	
	public static void midOrder(TreeNode tn){
		if(tn != null){
			midOrder(tn.left);
			System.out.print(tn.key+" ");
			midOrder(tn.right);
		}
	}
	
	public static void lastOrder(TreeNode tn){
		if(tn != null){
			lastOrder(tn.left);
			lastOrder(tn.right);
			System.out.print(tn.key+" ");
		}
	}
	
	
	
	public static void floorOrder(TreeNode tn,LinkedList<TreeNode> queue){
		if(tn != null){
			TreeNode temp = queue.poll();
			System.out.print(temp.key+" ");
			queue.offer(temp.left);
			queue.offer(temp.right);
			floorOrder(temp.left,queue);
			floorOrder(temp.right,queue);
		}
	}
	
	public static void buildTree(int[] A,int i,TreeNode root){
		int capacity = A.length -1;
		int leftC = heapsort.left(i);
		int rightC = heapsort.right(i);
		
		if(leftC<= capacity){
			TreeNode left = new TreeNode(A[leftC]);
			root.left = left;
			buildTree(A,leftC,root.left);
		}
		if(rightC <= capacity){
			TreeNode right = new TreeNode(A[rightC]);
			root.right = right;
			buildTree(A,rightC,root.right);
		}
		
	}
	
	public static TreeNode buildTreeFrom1(int[] A){
		TreeNode root = new TreeNode(A[1]);
		buildTree(A,1,root);
		return root;
	}
	
}
