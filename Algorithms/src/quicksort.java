public class quicksort {
	private static int[] array;
	public static void sort(int a[]) {
		array = a;
		quicksort(0, a.length-1);
		
	}

	private static void quicksort(int lower, int higher) {
		int pivot = array[lower + (higher - lower)/2];
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
		
		if(lower < j)
			quicksort(lower, j);
		if(i < higher)
			quicksort(i, higher);
	}
	
	private static void swap(int i, int j){
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
}
