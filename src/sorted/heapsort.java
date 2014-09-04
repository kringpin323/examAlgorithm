package sorted;

public class heapsort {
	
	// 堆的大小事 1~ length-1
	
	static void maxHeapify(Heap heap , int i){
		int l = left(i);
		int r = right(i);
		int largest;
		if(l<=heap.heapSize && heap.A[l]>heap.A[i])
			largest=l;
		else largest = i;
		if(r<=heap.heapSize && heap.A[r]>heap.A[largest])
			largest = r;
		if(largest!=i){
			// 将最大的放在父亲位
			Utils.swap(heap.A, i, largest);
			// 将改动过的重新调整
			maxHeapify(heap,largest);
		}
	}
	
	public static void buildMaxHeap(Heap heap){
		// 可以使用的 heap的实际值 heapSize
		heap.heapSize = heap.capacity;
		for(int i=heap.capacity/2;i>=1;i--)
			maxHeapify(heap,i);
	}
	
	public static void sortHeap(Heap heap){
		buildMaxHeap(heap);
		for(int i=heap.capacity;i>=2;i--){
			Utils.swap(heap.A, 1, i);
			heap.heapSize--;
			maxHeapify(heap,1);
		}
	}
	
	public static int parent(int i){
		return i/2;
	}
	
	public static int right(int i){
		return 2*i+1;
	}
	
	public static int left(int i){
		return 2*i;
	}
}



