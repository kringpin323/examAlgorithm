package protocol;

import java.util.Arrays;

public class SafeTest {
	// TODO 数据结构
	// 不会超过 30 行

//	static line[] Lines = new line[30];
	static int count =0;

	//测试一下
	public static void main(String[] args) {
		count = 2;
		line line1 = new line();
		line1.income = 0.00;
		line1.spending = 51.90;
		line1.balance = 1945.45;
		
		line line2 = new line();
		line2.income = 0.00;
		line2.spending = 1000.00;
		
		line[] linesA = new line[]{line1,line2};
		count = linesA.length;
		
		SafeTest sf = new SafeTest();
		sf.queryBalance(linesA);
		
		for(line lineT : linesA){
			System.out.println(lineT.income+";"+lineT.spending+";"+lineT.balance);
		}
	}
	
	//TODO 写一个 method 逐行处理 输入数据
	public void pretreatment(String oneLine){

	}

	//TODO 核心算法 第N-1行余额(+第N行收入或-第N行支出)=第N行余额  
	public void queryBalance(line[] linesA){
		// 三者都不是模糊，但 下一个的 balance是模糊的情况
		//		if((!isNotNull(Lines[n].balance)) 
		//				&& isNotNull(Lines[n-1].balance)
		//				&&isNotNull(Lines[n].income)
		//				&&isNotNull(Lines[n].spending)){
		//			Lines[n].balance = Lines[n-1].balance + Lines[n].income - Lines[n].spending;
		//		}

		// 整张表都填满
		for(int i=0;i<count;i++){
			if(isNull(linesA[i].balance))
				cacular(linesA,i,"balance");
			if(isNull(linesA[i].spending) || isNull(linesA[i].income))
					cacular(linesA,i,"SpIn");
				
		}
	}

	//TODO 这个递归计算出 A的值
	public void cacular(line[] A,int nn, String type){
		if(nn >= 0 && nn < count ){
			if(type == "balance"){
				// 情况1
				if(!isNull(A[nn-1].balance)
						&&!isNull(A[nn].spending)
						&&!isNull(A[nn].income))
					A[nn].balance = A[nn-1].balance + A[nn].income
					-A[nn].spending;
				else if(!isNull(A[nn+1].balance)
						&& !isNull(A[nn+1].income)
						&& !isNull(A[nn+1].spending))
					A[nn].balance = A[nn+1].balance - A[nn+1].income
					+ A[nn].spending;
				else{
					// 该情况属于 上下游的 balance 空缺的时候
					if(isNull(A[nn-1].balance))
						cacular(A, nn-1,"balance");
					if(isNull(A[nn+1].balance))
						cacular(A,nn+1,"balance");
					// 该情况属于 中游 和下游 的 SpIn 空缺的时候
					if(isNull(A[nn].spending) || isNull(A[nn].income))
						cacular(A,nn,"SpIn");
					if(isNull(A[nn+1].spending) || isNull(A[nn+1].income))
						cacular(A,nn+1,"SpIn");
				}
			}
			else{ // 当 缺失的是 "SpIn"
				if(!isNull(A[nn].balance) 
						&&!isNull(A[nn-1].balance)
						&&!isNull(A[nn].income))
					A[nn].spending = A[nn-1].balance + A[nn].income - A[nn].balance;
				else if(!isNull(A[nn].balance) 
						&&!isNull(A[nn-1].balance)
						&&!isNull(A[nn].spending))
					A[nn].income = A[nn].balance + A[nn].spending - A[nn-1].balance;
				else{
					// 缺失情况
					if(isNull(A[nn].balance))
							cacular(A, nn, "balance");
					if(isNull(A[nn-1].balance))
							cacular(A, nn-1, "balance");
					if(isNull(A[nn].income) || isNull(A[nn].spending))
						cacular(A, nn , "SpIn");
				}
			}
		}
	}

	//TODO 递归 计算 当缺失

	public boolean isNull(double temp){
		if(temp == Double.MAX_VALUE)
			return true;
		else
			return false;
	}
}
