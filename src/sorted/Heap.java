package sorted;

public class Heap {
	int[] A;
	int capacity;
	int heapSize;
	
	public Heap(int[] A){
		this.A = A;
		capacity= A.length-1;
	}
}
