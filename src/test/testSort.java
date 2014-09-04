package test;
import java.util.Arrays;

import linearAlgorithm.randomizedSelect;
import org.junit.Test;

import sorted.*;
import basicDataStruct.*;

public class testSort {
	
	static int[] A =  {10000,7,9,0,2,0,2,8,1};
	
	public static void main(String[] args) {
		int j = randomizedSelect.randomSelect(A, 0, A.length-1, 3);
		System.out.println("hello");
		System.out.println(j);
	}
	
	@Test
	public void testRandomSelect(){
		int j = randomizedSelect.randomSelect(A, 0, A.length-1, 3);
		System.out.println(j);
	}
	
	/**
	 * 使用了哨兵的双向循环链表
	 * */
	@Test
	public void testLinkList(){
		LinkList lList = new LinkList();
		for(int i=0;i<A.length;i++){
			Node n1 = new Node(A[i]);
			lList.listInsert(lList, n1);
		}
		lList.OutputList(lList);
		Node tempToDel = lList.listSearch(lList, 2);
		lList.listDelete(lList, tempToDel);
		tempToDel = lList.listSearch(lList, 2);
		lList.listDelete(lList, tempToDel);
		lList.OutputList(lList);
	}
	
	/**
	 * 引用的二进制表示
	 * */
	@Test
	public void testII(){
		SingleNode sn = new SingleNode();
		System.out.println("hello");
		System.out.println(sn.toString());
		System.out.println(sn.hashCode());
	}
}
