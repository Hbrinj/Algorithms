
public class quicksort2 {
	private static int[] array;
	
	public static void sort(int[] a)
	{
		array = a;
		quicksort(0,a.length-1);
	}
	
	private static void quicksort(int lower, int higher){		
		int index = partition(lower,higher);
		if(lower < index-1)
			quicksort(lower, index-1);
		if(index < higher)
			quicksort(index, higher);
	}
	
	private static int partition(int lower, int higher){
		int pivot = array[(lower + higher) /2];
		int i = lower;
		int j = higher;
		
		while(i <= j){
			while(array[i] < pivot)
				i++;
			while(array[j] > pivot)
				j--;
			if(i <= j){
				swap(i,j);
				i++;
				j--;
			}
		}
		
		return i;
	}
	
	private static void swap(int i, int j)
	{
		int t= array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
