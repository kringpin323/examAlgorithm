package linearAlgorithm;
import sorted.*;

public class randomizedSelect {
	public static int randomSelect(int[] A,int p, int r, int i){
		if(p==r)
			return A[p];
		int q = quicksort.randomPartition(A,p,r);
		int k = q-p+1;// 本次排序中排名第k大或者小的元素
		if(i==k) // 如果要找的就是排名第k大的元素就直接返回
			return A[q];
		else if(i<k) 
			return randomSelect(A,p,q-1,i); // 大于，在右边找
		return randomSelect(A,q+1,r,i-k); // 小于，在左边找
	}
	/*------------------------------
	 * 在算法导论中有详细的证明，
	 * 简要理解为：快排始终需要处理所有的元素（无论是双递归还是尾递归），但这里只需要处理一半的一半的一半的元素。
	 * 1/2 + 1/4 + 1/8 + ... 1/2^n = 1 (等比数列公式加上理想情况)
	 * ----------------------------*/
}
