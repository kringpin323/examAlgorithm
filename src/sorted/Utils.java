package sorted;

public class Utils {
	public static void swap(int[] array , int right, int i){
		int temp = array[right];
		array[right] = array[i];
		array[i] = temp;
	}
}
