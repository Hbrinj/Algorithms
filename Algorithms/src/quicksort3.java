
public class quicksort3 {
	private static int[] array;
	public static void sort(int[] a){
		array = a;
		quicksort(0,a.length-1);
	}
	
	private static void quicksort(int lower, int upper){
		int index = partition(lower, upper);
		if(lower < index-1)
			quicksort(lower,index-1);
		
		if(index < upper)
			quicksort(index,upper);
	}
	
	private static int partition(int lower, int upper){
		int mid = array[(lower+upper)/2];
		int i = lower;
		int j = upper;
		while(i <= j){
			while(array[i] < mid)
				i++;
			while(array[j] > mid)
				j--;
			
			if(i <=j){
				swap(i,j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	private static void swap(int i, int j){
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
	
}
