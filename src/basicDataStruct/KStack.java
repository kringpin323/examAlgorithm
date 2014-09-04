package basicDataStruct;

public class KStack {
	int capacity;
	int top;
	int[] stack;
	
	public KStack(int[] A){
		stack = A;
		top = 0;
		capacity = A.length;
	}
	
	public boolean stackEmpty(KStack S){
		if(S.top==0)
			return true;
		else return false;
	}
	
	public void push(KStack S,int x){
		if(S.top==capacity-1){
			System.out.println("stack overflow ! ");
			return;
		}
		S.top = S.top+1;
		S.stack[S.top] = x;
	}
	
	public int pop(KStack S){
		if(stackEmpty(S)){
			System.out.println("stack is empty! ");
			return Integer.MAX_VALUE;
		}	
		else{
			S.top = S.top -1;
			return S.stack[S.top+1];
		}
	}
}
