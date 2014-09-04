package test;

import java.util.LinkedList;

import org.junit.Test;

import binaryTree.*;

public class testTree {
	
	static int[] A =  {10000,7,9,0,2,0,2,8,1};
	
	@Test
	public void testBuildTree(){
		TreeNode tn = binaTree.buildTreeFrom1(A);
		System.out.print("先序： ");
		binaTree.preOrder(tn);
		System.out.print("\n中序： ");
		binaTree.midOrder(tn);
		System.out.print("\n后序： ");
		binaTree.lastOrder(tn);
		System.out.print("\n层序： ");
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(tn);
		binaTree.floorOrder(tn,queue);
		
		System.out.println("\n非递归先序：  ");
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		binaTree.preOrderLoop(tn, stack);
	}
}
