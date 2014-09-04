package sorted;

import java.util.Arrays;
import java.util.Random;

public class quicksort {
	public static void main(String[] args) {
		int[] A = {7,9,0,2,0,2,8,1};
		quicksort qs = new quicksort();
		qs.sort(A,0,A.length-1);
		System.out.println(Arrays.toString(A));
	}
	
	boolean sort(int[] A , int left, int right){
		// 这里是小于，因为如果是等于的话就只有一个，已经在合适位置，没必要继续循环
		while(left < right){
			int par = randomPartition(A, left, right);
			sort(A,par+1,right);
			right = par-1;
		}
		return true;
	}
	
	public static int randomPartition(int[] array, int left, int right){
		Random random = new Random(System.currentTimeMillis());
		// 请注意这里为什么要加1 ， 因为取值是从 left to right
		// 同时还要加绝对值
		int i = Math.abs(random.nextInt())%(right-left+1)+left;
		swap(array,right,i);
		return partition(array,left, right);
	}
	
	static int partition(int[] A, int left, int right){
		int x = A[right];
		int i = left-1;
		for(int j =left;j<right;j++){
			// 这里貌似 小于或者小于等于都可以，只是将等于的值放到不同地方
//			 if(A[j] < x){
			if(A[j] <= x){
				i += 1;
				swap(A,j,i);
			}
		}
		swap(A,i+1,right);
		return i+1;
	}
	
	static void swap(int[] array , int right, int i){
		int temp = array[right];
		array[right] = array[i];
		array[i] = temp;
	}
}
